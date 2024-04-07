package com.techelevator.controller;

import com.techelevator.dao.CastleDao;
import com.techelevator.model.Castle;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
@CrossOrigin
@RestController
public class CastleController {
    private CastleDao castleDao;
    public CastleController (CastleDao castleDao) {
        this.castleDao = castleDao;
    }
    @RequestMapping(path = "/castles", method = RequestMethod.GET)
    public Castle[] listCastles() {
        List<Castle> castleList = castleDao.getCastles();
        if (castleList.size() == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No castles found");
        } else {
            return castleDao.getCastles().toArray(new Castle[castleList.size()]);
        }
    }
}
