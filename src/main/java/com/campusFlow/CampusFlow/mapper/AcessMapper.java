package com.campusFlow.CampusFlow.mapper;

import com.campusFlow.CampusFlow.dto.AccessCreateDTO;
import com.campusFlow.CampusFlow.dto.AccessResponseDTO;
import com.campusFlow.CampusFlow.dto.HeatmapPointDTO;
import com.campusFlow.CampusFlow.model.Access;

import java.time.Instant;

public class AcessMapper {

    public static Access  toEntity(AccessCreateDTO dto){
       return Access.builder()
               .latitude(dto.latitude())
               .longitude(dto.longitude())
               .device(dto.device())
               .timestamp(Instant.parse(dto.timestamp()))
               .build();
    }

public static AccessResponseDTO toDTO(Access entity){
        return new AccessResponseDTO(
                entity.getId(),
                entity.getLatitude(),
                entity.getLongitude(),
                entity.getDevice(),
                entity.getTimestamp().toString()
        );


}
    public static HeatmapPointDTO toHeatmapPoint(Access entity){
        return new HeatmapPointDTO(entity.getLatitude(), entity.getLongitude(), 1.0);
    }

}