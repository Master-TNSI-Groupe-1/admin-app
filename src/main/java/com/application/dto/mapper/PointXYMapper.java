package com.application.dto.mapper;

import com.application.dto.PointXYDTO;
import com.application.entity.PointXY;

public class PointXYMapper {

    public static PointXYDTO entityToDTO(PointXY pointXY) {
        PointXYDTO pointXYDTO = new PointXYDTO();
        pointXYDTO.setIdPoint(pointXY.getIdPoint());
        pointXYDTO.setLatitude(pointXY.getLatitude());
        pointXYDTO.setLongitude(pointXY.getLongitude());
        return pointXYDTO;
    }

    public static PointXY dtoToEntity(PointXYDTO pointXYDTO) {
        PointXY pointXY = new PointXY();
        pointXY.setIdPoint(pointXYDTO.getIdPoint());
        pointXY.setLatitude(pointXYDTO.getLatitude());
        pointXY.setLongitude(pointXYDTO.getLongitude());
        return pointXY;
    }
}
