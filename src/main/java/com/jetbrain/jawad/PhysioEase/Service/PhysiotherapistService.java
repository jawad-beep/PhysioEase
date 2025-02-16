package com.jetbrain.jawad.PhysioEase.Service;

import com.jetbrain.jawad.PhysioEase.Model.Physiotherapist;
import com.jetbrain.jawad.PhysioEase.Repository.PhysiotherapistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhysiotherapistService {

    @Autowired
    private PhysiotherapistRepository physiotherapistRepository;

    // Get all physiotherapists
    public List<Physiotherapist> getAllPhysiotherapists() {
        return physiotherapistRepository.findAll();
    }

    // Get a physiotherapist by ID
    public Optional<Physiotherapist> getPhysiotherapistById(int id) {
        return physiotherapistRepository.findById(id);
    }

    // Update a physiotherapist's details
    public Physiotherapist updatePhysiotherapist(int id, Physiotherapist updatedPhysiotherapist) {
        Optional<Physiotherapist> existingPhysiotherapist = physiotherapistRepository.findById(id);

        if (existingPhysiotherapist.isPresent()) {
            Physiotherapist physiotherapist = existingPhysiotherapist.get();
            physiotherapist.setPhysiotherapistName(updatedPhysiotherapist.getPhysiotherapistName());
            physiotherapist.setClinicAddress(updatedPhysiotherapist.getClinicAddress());
            physiotherapist.setPhysiotherapistSpecialization(updatedPhysiotherapist.getPhysiotherapistSpecialization());
            physiotherapist.setPhysiotherapistExperience(updatedPhysiotherapist.getPhysiotherapistExperience());
            physiotherapist.setPhysiotherapistContactNumber(updatedPhysiotherapist.getPhysiotherapistContactNumber());
            physiotherapist.setPhysiotherapistEmailAddress(updatedPhysiotherapist.getPhysiotherapistEmailAddress());

            return physiotherapistRepository.save(physiotherapist);
        } else {
            throw new RuntimeException("Physiotherapist not found with ID: " + id);
        }
    }
}
