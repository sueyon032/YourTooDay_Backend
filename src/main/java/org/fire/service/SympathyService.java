package org.fire.service;

import org.fire.domain.Sympathy;
import org.fire.dto.AddSympathyRequest;
import org.fire.repository.SympathyRepository;

import java.util.List;

public class SympathyService {

    SympathyRepository sympathyRepository;

    public Sympathy save(AddSympathyRequest request) {
        return sympathyRepository.save(request.toEntity());
    }

    public List<Sympathy> findAll(){
        return sympathyRepository.findAll();
    }

    public Sympathy findById(long id){
        return sympathyRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("not found: " + id));
    }
    public void delete(long id) {
        sympathyRepository.deleteById(id);
    }
}
