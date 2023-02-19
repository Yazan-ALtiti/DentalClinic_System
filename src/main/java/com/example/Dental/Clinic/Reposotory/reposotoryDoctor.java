package com.example.Dental.Clinic.Reposotory;

import com.example.Dental.Clinic.Entity.doctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface reposotoryDoctor extends JpaRepository<doctorEntity,Long> {
    doctorEntity findByname(String name);
    doctorEntity findByphone(String phone);
}
