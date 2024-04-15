package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Img;
import com.techelevator.model.Visit;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.sql.Types;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcVisitDao implements VisitDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcVisitDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public Visit getVisitById(int visitId) {
        Visit visit = new Visit();
        String sql = "SELECT visit_id, user_id, castle_id, visit_date FROM visit WHERE visit_id = ?;";

        try{
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql,visitId);
            while (rowSet.next()) {
                visit = mapRowToVisit(rowSet);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database ", e);
        }
        return visit;
    }

    @Override
    public Visit createVisit(Visit visit) {

        Visit newVisit = new Visit();
        String sql =
                "INSERT INTO visit(user_id, castle_id, visit_date) " +
                "VALUES(?, ?, ?) " +
                "RETURNING visit_id;";

        try{
            int newVisitId = jdbcTemplate.queryForObject(sql, Integer.class, visit.getUserId(), visit.getCastleId(), visit.getVisitDate()); //int.class before //visit.getUserId(), visit.getCastleId(), visit.getVisitDate() new Object[]{visit.getUserId(), visit.getCastleId(), java.sql.Date.valueOf(visit.getVisitDate())},
//            new int[]{Types.INTEGER, Types.INTEGER, Types.DATE}
            newVisit = getVisitById(newVisitId); //newVisit.getVisitId()
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data Integrity Violation", e);
        }
        return visit;
    }

    public List<Visit> getVisitsByUserIdAndVisitDate(int userId, LocalDate visitDate) {
        List<Visit> visits = new ArrayList<>();
        String sql =
                "SELECT " +
                "visit_id, " +
                "user_id, " +
                "castle_id, " +
                "visit_date " +
                "FROM visit " +
                "WHERE user_id = ? AND visit_date = ?";
        try{
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, userId, visitDate);
            while (rowSet.next()) {
                visits.add(mapRowToVisit(rowSet));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database ", e);
        }
        return visits;
    }


    public Visit mapRowToVisit(SqlRowSet rowSet) {
        Visit visit = new Visit();
        visit.setVisitId(rowSet.getInt("visit_id"));
        visit.setCastleId(rowSet.getInt("castle_id"));
        visit.setUserId(rowSet.getInt("user_id"));
        visit.setVisitDate(rowSet.getDate("visit_date").toLocalDate());
        return visit;
    }
}
