package com.learn.vaccination_center.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Citizen {

    // since we use Generation type AUTO, hibernate takes care of the id. So hibernate keeps that data in another
    // table which is auto generated
    private int id;

    private String name;

    private int vaccinationCenterId;
}
