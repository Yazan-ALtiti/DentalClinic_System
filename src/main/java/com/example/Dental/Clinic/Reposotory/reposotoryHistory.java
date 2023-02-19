package com.example.Dental.Clinic.Reposotory;

import com.example.Dental.Clinic.Entity.historyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface reposotoryHistory extends JpaRepository<historyEntity,Long> {
    historyEntity findBydetails(String details);
    historyEntity findBydate(Date date);
}
