package com.learn.citizen_service.service;

import com.learn.citizen_service.entity.Citizen;

import java.util.List;

public interface CitizenService {
    List<Citizen> findByVaccinationCenterId(int vaccinationCenterId);

    Citizen addCitizen(Citizen newCitizen);
}
