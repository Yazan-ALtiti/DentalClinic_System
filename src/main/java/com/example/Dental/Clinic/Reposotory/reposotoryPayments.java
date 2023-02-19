package com.example.Dental.Clinic.Reposotory;

import com.example.Dental.Clinic.Entity.patientEntity;
import com.example.Dental.Clinic.Entity.paymentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface reposotoryPayments extends JpaRepository<paymentsEntity,Long> {
    paymentsEntity findByname(String name);
    patientEntity findByphone(String phone);
}
