package com.application.service;

import com.application.dto.NewPointXYDTO;
import com.application.entity.PointXY;

public interface PointXYService {

    PointXY addPointsXY(NewPointXYDTO newPointXYDTO);

    void deleteById(Integer idPoint);

    void update(PointXY pointXY);
}
