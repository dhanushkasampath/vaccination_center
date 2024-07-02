package com.learn.citizen_service.service.impl;

import com.learn.citizen_service.entity.Citizen;
import com.learn.citizen_service.repository.CitizenRepo;
import com.learn.citizen_service.service.CitizenService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitizenServiceImpl implements CitizenService {

    private final CitizenRepo citizenRepo;

    public CitizenServiceImpl(CitizenRepo citizenRepo) {
        this.citizenRepo = citizenRepo;
    }

    @Override
    public List<Citizen> findByVaccinationCenterId(int vaccinationCenterId) {
        return citizenRepo.findByVaccinationCenterId(vaccinationCenterId);
    }

    @Override
    public Citizen addCitizen(Citizen newCitizen) {
        return citizenRepo.save(newCitizen);
    }
}
