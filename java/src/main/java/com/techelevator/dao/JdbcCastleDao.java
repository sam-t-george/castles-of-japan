package com.techelevator.dao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Castle;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class JdbcCastleDao implements CastleDao {
    private final JdbcTemplate jdbcTemplate;
    public JdbcCastleDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public List<Castle> getCastles() {
        List<Castle> castles = new ArrayList<>();
        String sql =
                "SELECT " +
                "castle_id, " +
                "castle_name, " +
                "castle_banner_photo, " +
                "short_desc, " +
                "long_desc, " +
                "address, " +
                "longitude, " +
                "latitude, " +
                "site_url " +
                "FROM castle;";
        try {
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
            while (rowSet.next()) {
                Castle castle = mapRowToCastle(rowSet);
                castles.add(castle);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return castles;
    }

    public Castle mapRowToCastle(SqlRowSet rowSet) {
        Castle castle = new Castle();
        castle.setCastleId(rowSet.getInt("castle_id"));
        castle.setCastleName(rowSet.getString("castle_name"));
        castle.setCastleBannerPhoto(rowSet.getString("castle_banner_photo"));
        castle.setShortDesc(rowSet.getString("short_desc"));
        castle.setLongDesc(rowSet.getString("long_desc"));
        castle.setAddress(rowSet.getString("address"));
        castle.setLongitude(rowSet.getString("longitude"));
        castle.setLatitude(rowSet.getString("latitude"));
        castle.setSiteUrl(rowSet.getString("site_url"));
        return castle;
    }
}
