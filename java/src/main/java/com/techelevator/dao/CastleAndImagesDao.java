package com.techelevator.dao;

import com.techelevator.model.CastleAndImages;

public interface CastleAndImagesDao {
    CastleAndImages getCastleAndImagesByCastleId(int castleId);
}
