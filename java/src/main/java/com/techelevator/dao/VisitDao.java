package com.techelevator.dao;

import com.techelevator.model.Visit;

import java.time.LocalDate;
import java.util.List;

public interface VisitDao {
    Visit createVisit(Visit visit);
    Visit getVisitById(int visitId);

    List<Visit> getVisitsByUserIdAndVisitDate(int userId, LocalDate visitDate);

}
