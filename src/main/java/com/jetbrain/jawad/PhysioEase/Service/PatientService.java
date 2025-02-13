package com.jetbrain.jawad.PhysioEase.Service;

import com.jetbrain.jawad.PhysioEase.Model.Patient;
import com.jetbrain.jawad.PhysioEase.Repository.PatientRepository;  // Corrected the import statement
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;  // The correct repository is injected here

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }
}
