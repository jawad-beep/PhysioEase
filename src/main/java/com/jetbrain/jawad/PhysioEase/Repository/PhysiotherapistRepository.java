package com.jetbrain.jawad.PhysioEase.Repository;
import com.jetbrain.jawad.PhysioEase.Model.Patient;
import com.jetbrain.jawad.PhysioEase.Model.Physiotherapist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhysiotherapistRepository extends JpaRepository<Physiotherapist, Integer> {
    List<Physiotherapist> findBySpecialization(String specialization);
}
