package com.techelevator.controller;

import com.techelevator.dao.UserDao;
import com.techelevator.dao.VisitDao;
import com.techelevator.model.Castle;
import com.techelevator.model.User;
import com.techelevator.model.Visit;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@CrossOrigin
@RestController
public class VisitController {

    private UserDao userDao;
    private VisitDao visitDao;

    @RequestMapping(path = "/add/visit", method = RequestMethod.POST)
    public Visit createVisit(Principal principal, @RequestBody Visit visit){
        User user = userDao.getUserByUsername(principal.getName());
        return visitDao.createVisit(visit);
    }

    @RequestMapping(path = "/visit/{visitId}", method = RequestMethod.GET)
    public Visit getVisitById(@PathVariable("visitId") int visitId) {
        Visit visit = visitDao.getVisitById(visitId);
        return visit;
    }

}
