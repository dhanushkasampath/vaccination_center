package com.learn.citizen_service.repository;

import com.learn.citizen_service.entity.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitizenRepo extends JpaRepository<Citizen, Integer> {

    List<Citizen> findByVaccinationCenterId(Integer vaccinationCenterId);
}
