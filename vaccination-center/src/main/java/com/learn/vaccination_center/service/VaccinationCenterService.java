package com.learn.vaccination_center.service;

import com.learn.vaccination_center.entity.VaccinationCenter;
import com.learn.vaccination_center.model.Citizen;

import java.util.List;

public interface VaccinationCenterService {

    VaccinationCenter addVaccinationCenter(VaccinationCenter vaccinationCenter);

    VaccinationCenter findById(Integer id);

    List<Citizen> getCitizens(Integer id);
}
