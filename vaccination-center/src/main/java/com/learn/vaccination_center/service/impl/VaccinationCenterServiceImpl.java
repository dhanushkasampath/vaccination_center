package com.learn.vaccination_center.service.impl;

import com.learn.vaccination_center.entity.VaccinationCenter;
import com.learn.vaccination_center.repository.CenterRepo;
import com.learn.vaccination_center.service.VaccinationCenterService;
import org.springframework.stereotype.Service;

@Service
public class VaccinationCenterServiceImpl implements VaccinationCenterService {

    private final CenterRepo centerRepo;

    public VaccinationCenterServiceImpl(CenterRepo centerRepo) {
        this.centerRepo = centerRepo;
    }

    @Override
    public VaccinationCenter addVaccinationCenter(VaccinationCenter vaccinationCenter) {
        return centerRepo.save(vaccinationCenter);
    }
}
