package com.learn.vaccination_center.controller;

import com.learn.vaccination_center.entity.VaccinationCenter;
import com.learn.vaccination_center.model.Citizen;
import com.learn.vaccination_center.model.RequiredResponse;
import com.learn.vaccination_center.service.VaccinationCenterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    /**
     * @Desc This endpoint should add vaccination center to db
     * @param id
     * @return
     */
    @GetMapping(path = "/id/{id}")
    public ResponseEntity<RequiredResponse> getVaccinationCenter(@PathVariable Integer id){
        RequiredResponse requiredResponse = new RequiredResponse();
        VaccinationCenter vaccinationCenter = vaccinationCenterService.findById(id);
        requiredResponse.setCenter(vaccinationCenter);

        List<Citizen> citizenList = vaccinationCenterService.getCitizens(id);
        requiredResponse.setCitizens(citizenList);
        return new ResponseEntity<>(requiredResponse, HttpStatus.OK);
    }
}
