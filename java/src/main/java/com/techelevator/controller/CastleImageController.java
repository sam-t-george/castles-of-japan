package com.techelevator.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techelevator.dao.CastleAndImagesDao;
import com.techelevator.dao.CastleDao;
import com.techelevator.dao.ImgDao;
import com.techelevator.model.Castle;
import com.techelevator.model.CastleAndImages;
import com.techelevator.model.Img;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class CastleImageController {

    private CastleDao castleDao;
    private ImgDao imgDao;
    private CastleAndImagesDao castleAndImagesDao;

    public CastleImageController(CastleDao castleDao, ImgDao imgDao) {
        this.castleDao = castleDao;
        this.imgDao = imgDao;
    }

//    public CastleImageController (CastleAndImagesDao castleAndImagesDao) {
//        this.castleAndImagesDao = castleAndImagesDao;
//    }




    @RequestMapping(path = "/castles/images/{castleId}", method = RequestMethod.GET)
    public Map<Castle,List<Img>> getCastleAndImagesByCastleId(@PathVariable("castleId") int castleId) {
        Map<Castle,List<Img>> castleAndImages = new HashMap<>();
        Castle castle = castleDao.getCastleById(castleId);
        List<Img> images = imgDao.getImagesByCastleId(castleId);
        castleAndImages.put(castle, images);
        return castleAndImages;
    }
//    public CastleAndImages getCastleAndImagesByCastleId(@PathVariable("castleId") int castleId) {
//        return castleAndImagesDao.getCastleAndImagesByCastleId(castleId);
//    }
}
