package com.example.Dental.Clinic.Controllers;

import com.example.Dental.Clinic.DTO.doctorDTO;
import com.example.Dental.Clinic.Entity.doctorEntity;
import com.example.Dental.Clinic.Sirveses.doctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class doctorController {
    @Autowired
    doctorService doctorService;

    @PostMapping("/doctor/add")
    public HttpStatus addDoctor(@RequestBody doctorDTO doctorDTO) {
        return doctorService.addDoctor(doctorDTO);
    }


    @DeleteMapping("/doctor/delete/{id}")
    public HttpStatus deleteDoctor(@PathVariable("id")Long id){
        return doctorService.deleteDoctor(id);
    }
    @PutMapping("/doctor/update/{id}")
    public HttpStatus updateDoctor(@RequestBody doctorDTO doctordto,@PathVariable("id")Long id ){
        return doctorService.updateDoctor(id,doctordto);
    }
    @GetMapping("/doctor/find/{id}")
    public doctorEntity findDoctor(@PathVariable ("id")Long id){
        return doctorService.findDoctorById(id);
    }

}
