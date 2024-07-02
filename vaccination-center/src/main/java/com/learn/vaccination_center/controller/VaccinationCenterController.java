package com.learn.vaccination_center.controller;

import com.learn.vaccination_center.entity.VaccinationCenter;
import com.learn.vaccination_center.repository.CenterRepo;
import com.learn.vaccination_center.service.VaccinationCenterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vaccinationcenter")
public class VaccinationCenterController {

    private final VaccinationCenterService vaccinationCenterService;

    public VaccinationCenterController(VaccinationCenterService vaccinationCenterService) {
        this.vaccinationCenterService = vaccinationCenterService;
    }

    /**
     * @Desc This endpoint should add vaccination center to db
     * @param newVaccinationCenter
     * @return
     */
    @PostMapping(path = "/add")
    public ResponseEntity<VaccinationCenter> addCenter(@RequestBody VaccinationCenter newVaccinationCenter){
        VaccinationCenter vaccinationCenter = vaccinationCenterService.addVaccinationCenter(newVaccinationCenter);
        return new ResponseEntity<>(vaccinationCenter, HttpStatus.OK);
    }
}
