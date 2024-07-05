package com.learn.vaccination_center.controller;

import com.learn.vaccination_center.entity.VaccinationCenter;
import com.learn.vaccination_center.model.Citizen;
import com.learn.vaccination_center.model.RequiredResponse;
import com.learn.vaccination_center.service.VaccinationCenterService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/vaccinationcenter")
public class VaccinationCenterController {

    private final VaccinationCenterService vaccinationCenterService;

    @Value("${emp.service.url}")
    private String url;

    public VaccinationCenterController(VaccinationCenterService vaccinationCenterService) {
        this.vaccinationCenterService = vaccinationCenterService;
    }

    @GetMapping(path = "/fetch-url-from-config-server")
    public ResponseEntity<String> readFromConfigServer(){

        return new ResponseEntity<>("url fetched from config-server: " + url, HttpStatus.OK);
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
    public ResponseEntity<RequiredResponse> getVaccinationCenter(@PathVariable Integer id) throws ExecutionException, InterruptedException {
        RequiredResponse requiredResponse = new RequiredResponse();
        VaccinationCenter vaccinationCenter = vaccinationCenterService.findById(id);
        requiredResponse.setCenter(vaccinationCenter);

        //if citizen service is down user should be able to get at least vaccination center details. That is done by resilience4J or hystrix
        List<Citizen> citizenList = vaccinationCenterService.getCitizens(id).get();
        requiredResponse.setCitizens(citizenList);
        return new ResponseEntity<>(requiredResponse, HttpStatus.OK);
    }
}
