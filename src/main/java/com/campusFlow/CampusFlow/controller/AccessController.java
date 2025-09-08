package com.campusFlow.CampusFlow.controller;

import com.campusFlow.CampusFlow.dto.AccessCreateDTO;
import com.campusFlow.CampusFlow.dto.AccessResponseDTO;
import com.campusFlow.CampusFlow.dto.HeatmapPointDTO;
import com.campusFlow.CampusFlow.service.AccessService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/acessos")
@RequiredArgsConstructor
@CrossOrigin
public class AccessController {
    private final AccessService service;

    @PostMapping("/aPzXqM9vFtR3yLkD7sGwJhE2oUcBiZnV5TfHrQxYpNjSm")
    @ResponseStatus(HttpStatus.CREATED)
    public AccessResponseDTO create(@RequestBody @Valid AccessCreateDTO body){
        return service.create(body);
    }

    @GetMapping
    public List<AccessResponseDTO> findAll(){
        return service.findAll();
    }

    @GetMapping("/heatmap")
    public List<HeatmapPointDTO> heatmap(){
        return service.heatmapPoints();
    }

    @DeleteMapping("/delete-all")
@ResponseStatus(HttpStatus.NO_CONTENT)
public void deleteAll() {
    repository.deleteAll();
}

}
