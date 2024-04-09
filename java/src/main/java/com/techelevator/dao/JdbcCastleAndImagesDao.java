package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Castle;
import com.techelevator.model.CastleAndImages;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcCastleAndImagesDao implements CastleAndImagesDao{
    private final JdbcTemplate jdbcTemplate;
    public JdbcCastleAndImagesDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public CastleAndImages getCastleAndImagesByCastleId(int castleId) {
        CastleAndImages castleAndImages = new CastleAndImages();
        String sql = "SELECT " +
                        "c.castle_id, " +
                        "c.castle_name, " +
                        "c.castle_banner_photo, " +
                        "c.short_desc, " +
                        "c.long_desc, " +
                        "c.address, " +
                        "c.longitude, " +
                        "c.latitude, " +
                        "c.site_url, " +
                        "c.map_location, " +
                        "" +
                        "i.img_id,  " +
                        "i.img_name,  " +
                        "i.img_path " +
                    "FROM castle c " +
                    "JOIN img i ON c.castle_id = i.castle_id " +
                    "WHERE c.castle_id = ?;";
        try {
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, castleId);
            while (rowSet.next()) {
                castleAndImages = mapRowToCastleAndImages(rowSet);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return castleAndImages;
    }

    public CastleAndImages mapRowToCastleAndImages(SqlRowSet rowSet) {
        CastleAndImages castleAndImages = new CastleAndImages();
        castleAndImages.setCastleId(rowSet.getInt("castle_id"));
        castleAndImages.setCastleName(rowSet.getString("castle_name"));
        castleAndImages.setCastleBannerPhoto(rowSet.getString("castle_banner_photo"));
        castleAndImages.setShortDesc(rowSet.getString("short_desc"));
        castleAndImages.setLongDesc(rowSet.getString("long_desc"));
        castleAndImages.setAddress(rowSet.getString("address"));
        castleAndImages.setLongitude(rowSet.getString("longitude"));
        castleAndImages.setLatitude(rowSet.getString("latitude"));
        castleAndImages.setSiteUrl(rowSet.getString("site_url"));
        castleAndImages.setMapLocation(rowSet.getString("map_location"));

        castleAndImages.setImgId(rowSet.getInt("img_id"));
        castleAndImages.setImgName(rowSet.getString("img_name"));
        castleAndImages.setImgPath(rowSet.getString("img_path"));
        return castleAndImages;
    }

}
