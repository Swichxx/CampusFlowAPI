package com.campusFlow.CampusFlow.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AccessCreateDTO (
    @NotNull(message = "latitude é obrigatoria")
    @DecimalMin(value = "-90.0", message = "latitute minina é -90")
    @DecimalMax(value = "90.0", message = "latitude maxima 90")
    double latitude,

    @NotNull(message = "longitude é obrigatória")
    @DecimalMin(value = "-180.0", message = "longitude mínima -180")
    @DecimalMax(value = "180.0", message = "longitude máxima 180")
    Double longitude,

    @NotBlank(message = "device é obrigatório")
    String device,

// 
    @NotBlank(message = "timestamp é obrigatório (ISO-8601)")
    String timestamp
    ) {}
