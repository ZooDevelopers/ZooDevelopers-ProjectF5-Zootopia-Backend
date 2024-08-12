package org.factoriaf5.zootopia.services;


import org.factoriaf5.zootopia.models.Species;
import org.factoriaf5.zootopia.repository.SpeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpeciesService {

    @Autowired
    private SpeciesRepository speciesRepository;

    public Species saveSpecies(Species species) {
        return speciesRepository.save(species);
    }

    public Species updateSpecies(Long id, Species updatedSpecies) {
        Species species = speciesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Species not found"));
        species.setName(updatedSpecies.getName());
        species.setType(updatedSpecies.getType());
        species.setFamily(updatedSpecies.getFamily());
        species.setGender(updatedSpecies.getGender());
        species.setDateOfEntry(updatedSpecies.getDateOfEntry());
        species.setImageUrl(updatedSpecies.getImageUrl());
        return speciesRepository.save(species);
    }

    public void deleteSpecies(Long id) {
        speciesRepository.deleteById(id);
    }

    public Page<Species> getAllSpecies(Pageable pageable) {
        return speciesRepository.findAll(pageable);
    }

    public List<Species> filterByFamily(String family) {
        return speciesRepository.findByFamily(family);
    }

    public List<Species> filterByType(String type) {
        return speciesRepository.findByType(type);
    }
}