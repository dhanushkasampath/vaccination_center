package com.learn.vaccination_center.service.impl;

import com.learn.vaccination_center.entity.VaccinationCenter;
import com.learn.vaccination_center.model.Citizen;
import com.learn.vaccination_center.repository.CenterRepo;
import com.learn.vaccination_center.service.VaccinationCenterService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class VaccinationCenterServiceImpl implements VaccinationCenterService {

    private final CenterRepo centerRepo;
    private final RestTemplate restTemplate;

    public VaccinationCenterServiceImpl(CenterRepo centerRepo, RestTemplate restTemplate) {
        this.centerRepo = centerRepo;
        this.restTemplate = restTemplate;
    }

    @Override
    public VaccinationCenter addVaccinationCenter(VaccinationCenter vaccinationCenter) {
        return centerRepo.save(vaccinationCenter);
    }

    @Override
    public VaccinationCenter findById(Integer id) {
        return centerRepo.findById(id)
            .orElse(null);
    }

    @Override
    public List<Citizen> getCitizens(Integer id) {
        return restTemplate.getForObject("http://localhost:8081/citizen/id/" + id, List.class);
    }
}
