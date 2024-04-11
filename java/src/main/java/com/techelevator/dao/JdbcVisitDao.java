package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Img;
import com.techelevator.model.Visit;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcVisitDao implements VisitDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcVisitDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public Visit getVisitById(int id) {
        Visit visit = null;

        String sql =
                "SELECT user_id, " +
                "castle_id, " +
                "visit_date, " +
                "visit_id" +
                "FROM visit " +
                "WHERE visit_id = ?;";

        try{
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql,id);
            if (results.next()) {
                visit = mapRowToVisit(results);

            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database ", e);
        }

        return visit;
    }

    @Override
    public Visit createVisit(Visit visit) {
        Visit newVisit = null;
        String sql =
                "INSERT INTO visit(user_id, castle_id, visit_date) " +
                "VALUES(?, ?, ?) " +
                "RETURNING visit_id;";

        try{
            int newVisitId = jdbcTemplate.queryForObject(sql, int.class, visit.getUserId(), visit.getCastleId(), visit.getVisitDate());
            newVisit = getVisitById(newVisit.getVisitId());
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data Integrity Violation", e);
        }
        return visit;
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
