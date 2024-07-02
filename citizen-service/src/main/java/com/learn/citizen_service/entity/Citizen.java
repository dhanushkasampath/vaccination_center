package com.learn.citizen_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Citizen {

    // since we use Generation type AUTO, hibernate takes care of the id. So hibernate keeps that data in another
    // table which is auto generated
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String name;

    @Column
    private int vaccinationCenterId;
}
