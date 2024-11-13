package com.citiustech.prp.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.prp.dao.AllergyRepository;
import com.citiustech.prp.dao.PrescriptionRepository;
import com.citiustech.prp.model.Patient;
import com.citiustech.prp.service.PatientService;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;
    
    @Autowired
    private PrescriptionRepository prescriptionRepository;
    
    @Autowired
    private AllergyRepository allergyRepository;

    @PreAuthorize("hasRole('PHYSICIAN')")
    @PostMapping("/save")
    public Patient savePatient(@RequestBody Patient patient) {
        return patientService.registerPatient(patient);
    }

    @GetMapping("/{id}")
    public Optional<Patient> getPatient(@PathVariable Long id) {
        return patientService.getPatient(id);
    }

    @PreAuthorize("hasRole('PHYSICIAN')")
    @PutMapping("/update/{id}")
    public Patient updatePatient(@PathVariable Long id, @RequestBody Patient updatedPatient) {
        return patientService.updatePatient(updatedPatient);
    }
    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
    }
}
