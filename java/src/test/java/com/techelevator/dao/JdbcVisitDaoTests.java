package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.RegisterUserDto;
import com.techelevator.model.User;
import com.techelevator.model.Visit;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDate;
import java.util.List;

public class JdbcVisitDaoTests extends BaseDaoTests{
    protected static final Visit VISIT_1 = new Visit(1,1,"brian",
            LocalDate.parse("2024-01-01"), "Nijo",
            "https://batnomad.com/wp-content/uploads/2019/02/DSCF6885.jpg",
            "Japans Most Spectacular Feudal Castle", "Kansai");
    protected static final Visit VISIT_2 = new Visit(2,2,"steve",
            LocalDate.parse("2024-02-02"), "Himeji Castle",
            "https://www.nippon.com/en/ncommon/contents/guide-to-japan/2425564/2425564.jpg",
            "Ancient White Heron", "Kansai");
    private static final Visit VISIT_3 = new Visit(1,1,"john",
            LocalDate.parse("2024-03-03"), "Hirosaki Castle",
            "https://www.hirosaki-kanko.or.jp/hirosaki-pamphlet/english/img/001.jpg",
            "1 of the 12 Authentic Castles in Japan.", "Tohoku");

    private JdbcVisitDao sut;

    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcVisitDao(jdbcTemplate);
    }

    @Test
    public void getVisitById_given_valid_id_returns_visit() {
        Visit actualVisit = sut.getVisitById(VISIT_1.getVisitId());
        Assert.assertEquals(VISIT_1, actualVisit);
    }
}
