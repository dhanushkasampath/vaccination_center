package com.learn.vaccination_center.repository;

import com.learn.vaccination_center.entity.VaccinationCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CenterRepo extends JpaRepository<VaccinationCenter, Integer> {

}
