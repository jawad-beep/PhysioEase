package com.jetbrain.jawad.PhysioEase.Repository;
import com.jetbrain.jawad.PhysioEase.Model.Patient;
import com.jetbrain.jawad.PhysioEase.Model.Physiotherapist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PhysiotherapistRepository extends JpaRepository<Physiotherapist, Integer> {
    List<Physiotherapist> findBySpecialization(String specialization);
}
