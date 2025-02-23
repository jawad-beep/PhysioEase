package com.jetbrain.jawad.PhysioEase.Repository;

import com.jetbrain.jawad.PhysioEase.Model.Appointment;
import com.jetbrain.jawad.PhysioEase.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

}
