package com.jetbrain.jawad.PhysioEase.Repository;
import com.jetbrain.jawad.PhysioEase.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
