package com.jetbrain.jawad.PhysioEase.Repository;

import com.jetbrain.jawad.PhysioEase.Controller.BookedAppointmentController;
import com.jetbrain.jawad.PhysioEase.Model.Appointment;
import com.jetbrain.jawad.PhysioEase.Model.BookedAppointment;
import com.jetbrain.jawad.PhysioEase.Model.Patient;
import org.springframework.data.domain.Limit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BookedAppointmentRepository extends JpaRepository<BookedAppointment, Integer> {



}
