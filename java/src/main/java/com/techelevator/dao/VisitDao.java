package com.techelevator.dao;

import com.techelevator.model.Visit;

public interface VisitDao {
    Visit createVisit(Visit visit);
    Visit getVisitById(int visitId);

}
