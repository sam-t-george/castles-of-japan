package com.techelevator.controller;

import com.techelevator.dao.UserDao;
import com.techelevator.dao.VisitDao;
import com.techelevator.model.Castle;
import com.techelevator.model.User;
import com.techelevator.model.Visit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

@CrossOrigin
@RestController
public class VisitController {

    private UserDao userDao;
    private VisitDao visitDao;

    public VisitController(UserDao userDao, VisitDao visitDao) {
        this.userDao = userDao;
        this.visitDao = visitDao;
    }

    @PostMapping(path = "/add/visit")
    public Visit createVisit(@Valid @RequestBody Visit visit, Principal principal){
        System.out.println("date = " + visit.getVisitDate());
        System.out.println("castleId = " + visit.getCastleId());
        return visitDao.createVisit(visit);
    }

    @RequestMapping(path = "/visit/{visitId}", method = RequestMethod.GET)
    public Visit getVisitById(@PathVariable("visitId") int visitId) {
        Visit visit = visitDao.getVisitById(visitId);
        return visit;
    }
    @RequestMapping(path = "/itinerary/{visitDate}", method = RequestMethod.GET)
    public List<Visit> getVisitsByUserIdAndVisitDate(
            Principal principal,
            @PathVariable("visitDate")
            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate visitDate) {
        User currentUser = userDao.getUserByUsername(principal.getName());
        return visitDao.getVisitsByUserIdAndVisitDate(currentUser.getUsername(), visitDate);
    }
}

