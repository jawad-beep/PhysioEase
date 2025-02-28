package com.jetbrain.jawad.PhysioEase.Service;

import com.jetbrain.jawad.PhysioEase.Model.Patient;
import com.jetbrain.jawad.PhysioEase.Repository.PatientRepository;  // Corrected the import statement
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;  // The correct repository is injected here

    public List<Patient> getAllPatients() {

        return patientRepository.findAll();
    }
    public Patient updatePatient(int patientid, Patient updatedPatient)
    {
        Optional<Patient> existingPatient = patientRepository.findById(patientid);

        if (existingPatient.isPresent()) {
            Patient patient = existingPatient.get();
            patient.setFirstname(updatedPatient.getFirstname());
            patient.setLastname(updatedPatient.getLastname());
            patient.setEmailaddress(updatedPatient.getEmailaddress());
            patient.setAddress(updatedPatient.getAddress());
            patient.setAge(updatedPatient.getAge());
            patient.setGender(updatedPatient.getGender());
            patient.setContactnumber(updatedPatient.getContactnumber());

            return patientRepository.save(patient); // Save updated data in the database
        } else {
            throw new RuntimeException("Patient not found with ID: " + patientid);
        }



    }
    public Optional<Patient> getPatientById(int patientid) {
        return patientRepository.findById(patientid);
    }


}
