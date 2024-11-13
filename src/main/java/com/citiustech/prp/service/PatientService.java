package com.citiustech.prp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiustech.prp.dao.PatientRepository;
import com.citiustech.prp.model.Allergy;
import com.citiustech.prp.model.Patient;
import com.citiustech.prp.model.Prescription;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

   
   
        public Patient registerPatient(Patient patient) {
        	for (Prescription prescription : patient.getPrescriptions()) {
                prescription.setPatient(patient);
            }
            for (Allergy allergy : patient.getAllergies()) {
                allergy.setPatient(patient);
            }
            return patientRepository.save(patient);
        }

        public Optional<Patient> getPatient(Long id) {
            return patientRepository.findById(id);
        }

        public Patient updatePatient(Patient patient) {
            
        	Patient existingPatient = patientRepository.findById(patient.getId())
                    .orElseThrow(() -> new RuntimeException("Patient not found"));

        	existingPatient.getPrescriptions().clear();
            existingPatient.getAllergies().clear();

            for (Prescription prescription : patient.getPrescriptions()) {
                prescription.setPatient(existingPatient);
                existingPatient.getPrescriptions().add(prescription);
            }

            for (Allergy allergy : patient.getAllergies()) {
                allergy.setPatient(existingPatient);
                existingPatient.getAllergies().add(allergy);
            }
            
        	return patientRepository.save(patient);
        }
        
        public void deletePatient(Long id) {
            patientRepository.deleteById(id);
        }

    // Other service methods...
}
