package com.jetbrain.jawad.PhysioEase.Repository;

import com.jetbrain.jawad.PhysioEase.Model.Appointment;
import com.jetbrain.jawad.PhysioEase.Model.BookedAppointment;
import com.jetbrain.jawad.PhysioEase.Model.Patient;
import org.springframework.data.domain.Limit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookedAppointmentRepository extends JpaRepository<BookedAppointment, Integer> {


}
