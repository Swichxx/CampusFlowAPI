package com.campusFlow.CampusFlow.service;

import com.campusFlow.CampusFlow.dto.AccessCreateDTO;
import com.campusFlow.CampusFlow.dto.AccessResponseDTO;
import com.campusFlow.CampusFlow.dto.HeatmapPointDTO;
import com.campusFlow.CampusFlow.mapper.AcessMapper;
import com.campusFlow.CampusFlow.model.Access;
import com.campusFlow.CampusFlow.repository.AcessRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccessService {

    private final AcessRepository repository;

    @Transactional
    public AccessResponseDTO create(AccessCreateDTO dto){
        Access access = AcessMapper.toEntity(dto);
        Access saved = repository.save(access);
        return AcessMapper.toDTO((saved));
    }

    @Transactional(readOnly = true)
    public List<AccessResponseDTO> findAll(){
        return repository.findAll().stream()
                .map(AcessMapper::toDTO)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<HeatmapPointDTO> heatmapPoints(){
        return repository.findAll().stream()
                .map(AcessMapper::toHeatmapPoint)
                .toList();
    }
}
