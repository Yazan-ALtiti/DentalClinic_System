package com.example.Dental.Clinic.Sirveses;

import com.example.Dental.Clinic.DTO.doctorDTO;
import com.example.Dental.Clinic.Entity.doctorEntity;
import com.example.Dental.Clinic.Reposotory.reposotoryDoctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class doctorService {
    @Autowired
    reposotoryDoctor reposotoryDoctor;

    public HttpStatus addDoctor(doctorDTO doctorDTO) {
        doctorEntity doctor = new doctorEntity(doctorDTO.getName(), doctorDTO.getSalary(), doctorDTO.getPhone());

        reposotoryDoctor.save(doctor);

        return HttpStatus.OK;
    }

    public HttpStatus deleteDoctor(Long id) {
        reposotoryDoctor.deleteById(id);
        return HttpStatus.OK;
    }

    public HttpStatus updateDoctor(Long id, doctorDTO doctorDTO) {
        doctorEntity doctor = reposotoryDoctor.findById(id).orElseThrow(() -> new IllegalArgumentException("invalid user id" + id));
        doctor.setName(doctor.getName());
        doctor.setPhone(doctor.getPhone());
        doctor.setSalary(doctorDTO.getSalary());
        reposotoryDoctor.save(doctor);
        return HttpStatus.OK;
    }
    public doctorEntity findDoctorById(Long id) {
        doctorEntity doctor = reposotoryDoctor.findById(id).orElseThrow(() -> new IllegalArgumentException("invalid user id" + id));
        return doctor;
    }


}
