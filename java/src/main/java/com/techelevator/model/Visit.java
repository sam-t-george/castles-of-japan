package com.techelevator.model;

import java.time.LocalDate;

public class Visit {

    private int castleId;
    private int visitId;
    private int userId;
    private LocalDate visitDate;

    public Visit(int castleId, int visitId, int userId, LocalDate visitDate) {
        this.castleId = castleId;
        this.visitId = visitId;
        this.userId = userId;
        this.visitDate = visitDate;
    }

    public Visit() {
    }

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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public LocalDate getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(LocalDate visitDate) {
        this.visitDate = visitDate;
    }
}
