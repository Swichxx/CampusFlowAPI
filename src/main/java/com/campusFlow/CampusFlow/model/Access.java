package com.campusFlow.CampusFlow.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "access")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class Access {

    @Id
    public Long id;

    @Column(nullable = false)
    private Double latitude;

    @Column(nullable = false)
    private Double longitude;

    @Column(nullable = false, length = 100)
    private String device;

    @Column(nullable = false)
    private Instant timestamp;

}
