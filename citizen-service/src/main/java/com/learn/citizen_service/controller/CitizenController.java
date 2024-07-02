package com.learn.citizen_service.controller;

import com.learn.citizen_service.entity.Citizen;
import com.learn.citizen_service.service.CitizenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/citizen")
public class CitizenController {

    private final CitizenService citizenService;

    public CitizenController(CitizenService citizenService) {
        this.citizenService = citizenService;
    }

    @GetMapping(path = "/test")
    public ResponseEntity<String> test(){
        return new ResponseEntity<>("hello", HttpStatus.OK);
    }

    /**
     * @Desc This endpoint should return all the information of citizen when we give the id
     * @param id
     * @return
     */
    @GetMapping(path = "/id/{id}")
    public ResponseEntity<List<Citizen>> getById(@PathVariable Integer id){
        List<Citizen> citizenList = citizenService.findByVaccinationCenterId(id);
        return new ResponseEntity<>(citizenList, HttpStatus.OK);
    }

    /**
     * @Desc This endpoint should add citizen to db
     * @param newCitizen
     * @return
     */
    @PostMapping(path = "/add")
    public ResponseEntity<Citizen> addCitizen(@RequestBody Citizen newCitizen){
        Citizen citizen = citizenService.addCitizen(newCitizen);
        return new ResponseEntity<>(citizen, HttpStatus.OK);
    }
}
