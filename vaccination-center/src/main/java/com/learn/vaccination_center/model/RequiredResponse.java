package com.learn.vaccination_center.model;

import com.learn.vaccination_center.entity.VaccinationCenter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequiredResponse {

    private VaccinationCenter center;
    private List<Citizen> citizens;
}
