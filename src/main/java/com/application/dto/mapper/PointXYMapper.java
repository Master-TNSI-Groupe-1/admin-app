package com.application.dto.mapper;

import com.application.dto.PointXYDTO;
import com.application.entity.PointXY;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PointXYMapper {

    public static PointXYDTO entityToDTO(PointXY pointXY) {
        PointXYDTO pointXYDTO = new PointXYDTO();
        pointXYDTO.setIdPoint(pointXY.getIdPoint());
        pointXYDTO.setLatitude(pointXY.getLatitude());
        pointXYDTO.setLongitude(pointXY.getLongitude());
        return pointXYDTO;
    }

    public static Collection<PointXYDTO> entityToDTO(Collection<PointXY> pointXYs) {
        List<PointXYDTO> pointXYDTOs = new ArrayList<>();
        for (PointXY pointXY : pointXYs) {
            pointXYDTOs.add(entityToDTO(pointXY));
        }
        return pointXYDTOs;
    }

    public static PointXY dtoToEntity(PointXYDTO pointXYDTO) {
        PointXY pointXY = new PointXY();
        pointXY.setIdPoint(pointXYDTO.getIdPoint());
        pointXY.setLatitude(pointXYDTO.getLatitude());
        pointXY.setLongitude(pointXYDTO.getLongitude());
        return pointXY;
    }

    public static Collection<PointXY> dtoToEntity(Collection<PointXYDTO> pointXYDTOs) {
        List<PointXY> pointXYs = new ArrayList<>();
        for (PointXYDTO pointXYDTO : pointXYDTOs) {
            pointXYs.add(dtoToEntity(pointXYDTO));
        }
        return pointXYs;
    }
}
