package com.application.service;

import com.application.dto.NewPointXYDTO;
import com.application.entity.PointXY;

public interface PointXYService {

    PointXY addPointsXY(final NewPointXYDTO newPointXYDTO);

    void deleteById(final Integer idPoint);

    void update(final PointXY pointXY);
}
