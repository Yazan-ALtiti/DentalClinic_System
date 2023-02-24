package com.example.Dental.Clinic.Reposotory;

import com.example.Dental.Clinic.Entity.patientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface reposotoryPationt extends JpaRepository<patientEntity,Long> {
    patientEntity findByname(String name);
    patientEntity findByphone(String phone);


    List<patientEntity> findBydayOfPay(int day);
    List<patientEntity> findBydateOfNextVisit(LocalDate day);
}
