// Repository (Same as before, but we'll focus on the findByPatientname method)
package com.jetbrain.jawad.PhysioEase.Repository;

import com.jetbrain.jawad.PhysioEase.Model.BookedAppointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookedAppointmentRepository extends JpaRepository<BookedAppointment, Integer> {
    // Find appointments by patient name
    List<BookedAppointment> findByPatientname(String patientname);
}