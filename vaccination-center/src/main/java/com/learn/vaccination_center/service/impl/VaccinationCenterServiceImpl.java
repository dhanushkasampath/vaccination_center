package com.learn.vaccination_center.service.impl;

import com.learn.vaccination_center.entity.VaccinationCenter;
import com.learn.vaccination_center.model.Citizen;
import com.learn.vaccination_center.repository.CenterRepo;
import com.learn.vaccination_center.service.VaccinationCenterService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

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

    /**
     * This is the beauty of eureka. we dont want to hard code the ip port here.
     * 'CITIZEN-SERVICE' <- this name is in eureka server
     */
    @Override
    @TimeLimiter(name = "vaccination-center-service")
    @CircuitBreaker(name = "vaccination-center-service", fallbackMethod = "myFallBackMethod")
    public CompletableFuture<List<Citizen>> getCitizens(Integer id) {
//        return restTemplate.getForObject("http://CITIZEN-SERVICE/citizen/id/" + id, List.class);
//        return restTemplate.getForObject("http://localhost:8081/citizen/id/" + id, List.class);

        return CompletableFuture.supplyAsync(() -> {
            return restTemplate.getForObject("http://CITIZEN-SERVICE/citizen/id/" + id, List.class);
        });

    }

    public CompletableFuture<List<Citizen>> myFallBackMethod(Exception e){
        return CompletableFuture.completedFuture(new ArrayList<>());
    }

// if we don't want a time limiter then we can use the fallback method without completable future
//    public List<Citizen> myFallBackMethod(Exception e){
//        return new ArrayList<>();
//    }
}
