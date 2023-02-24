package com.example.Dental.Clinic.Controllers;

import com.example.Dental.Clinic.DTO.doctorDTO;
import com.example.Dental.Clinic.DTO.historyDTO;
import com.example.Dental.Clinic.Sirveses.historyServese;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class historyCotroller {
    @Autowired
    historyServese historyServese;

    @PostMapping("/history/add/{id}")
    public HttpStatus addHistory(@RequestBody historyDTO historyDTO, @PathVariable("id") Long id) {
        return historyServese.addhistory(historyDTO, id);
    }

    @DeleteMapping("/history/delete/{id}")
    public HttpStatus deleteHistory(@PathVariable("id") Long id) {
        return historyServese.deleteHistory(id);
    }

    @PutMapping("/history/update/{id}")
    public HttpStatus updateHistory(@RequestBody historyDTO historyDTO, @PathVariable("id") Long id) {
        return historyServese.updateHistory(id, historyDTO);
    }
}
