package com.learn.vaccination_center.service;

import com.learn.vaccination_center.entity.VaccinationCenter;
import com.learn.vaccination_center.model.Citizen;
import java.util.concurrent.CompletableFuture;

import java.util.List;

public interface VaccinationCenterService {

    VaccinationCenter addVaccinationCenter(VaccinationCenter vaccinationCenter);

    VaccinationCenter findById(Integer id);

    CompletableFuture<List<Citizen>> getCitizens(Integer id);
}
