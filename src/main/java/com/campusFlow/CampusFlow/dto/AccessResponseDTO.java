package com.campusFlow.CampusFlow.dto;

public record AccessResponseDTO (
   Long id,
   double latitude,
   double longitude,
   String device,
   String timestamp
) {}
