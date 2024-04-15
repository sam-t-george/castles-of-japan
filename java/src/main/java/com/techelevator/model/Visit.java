package com.techelevator.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Visit {

    private int castleId;
    private Integer visitId;
    private String username;
    private LocalDate visitDate;
    public Visit(){};
//    public Visit (int castleId, int visitId, String username, LocalDate visitDate) {
//        this.castleId = castleId;
//        this.visitId = visitId;
//        this.username = username;
//        this.visitDate = visitDate;
//    }

    public int getCastleId() {
        return castleId;
    }

    public void setCastleId(int castleId) {
        this.castleId = castleId;
    }

    public int getVisitId() {
        return visitId;
    }

    public void setVisitId(int visitId) {
        this.visitId = visitId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDate getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(LocalDate visitDate) {
        this.visitDate = visitDate;
    }
}
