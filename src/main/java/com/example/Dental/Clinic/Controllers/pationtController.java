package com.example.Dental.Clinic.Controllers;

import com.example.Dental.Clinic.DTO.pationtDTO;
import com.example.Dental.Clinic.Entity.patientEntity;
import com.example.Dental.Clinic.Sirveses.patintServese;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class pationtController {
    @Autowired
    patintServese patintServese;

    @PostMapping("/pationt/add")
    public HttpStatus addPationt(@RequestBody pationtDTO pationtDTO) {
        return patintServese.addPationt(pationtDTO);
    }

    @DeleteMapping("/pationt/delete/{id}")
    public HttpStatus deletePationt(@PathVariable("id") Long id) {
        return patintServese.deletePationt(id);
    }

    @PutMapping("/pationt/update/{id}")
    public HttpStatus updatepationt(@RequestBody pationtDTO pationtDTO, @PathVariable("id") Long id) {
        return patintServese.updatePationt(id, pationtDTO);
    }
    @GetMapping("/pationt/find/{id}")
    public patientEntity findPationt(@PathVariable ("id")Long id){
        return patintServese.findPationtById(id);

    }
    @GetMapping("/pationt/notification/{day}")
    public List<patientEntity>findByday(@PathVariable("day")int day){
        return patintServese.notificationsOfPayment(day);
    }

    @PostMapping("/pationt/notofacate/appointent/")
    public List<patientEntity>findApintent(@RequestParam String day){
        return patintServese.notificationsOfPointent(day);
    }

}
