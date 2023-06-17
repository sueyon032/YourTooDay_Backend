package org.fire.service;

import lombok.RequiredArgsConstructor;
import org.fire.domain.DiaryCover;
import org.fire.dto.AddDiaryCoverRequest;
import org.fire.dto.UpdateDiaryCoverRequest;
import org.fire.dto.UpdateUserRequest;
import org.fire.repository.DiaryCoverRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DiaryCoverService {
    private final DiaryCoverRepository diaryCoverRepository;

    public DiaryCover save(AddDiaryCoverRequest request){
        return diaryCoverRepository.save(request.toEntity());
    }

    public List<DiaryCover> findAll(){
        return diaryCoverRepository.findAll();
    }

    public DiaryCover findById(long id){
        return diaryCoverRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("not found" + id));
    }

    public void delete(long id){
        diaryCoverRepository.deleteById(id);
    }

    @Transactional
    public DiaryCover update(long id, UpdateDiaryCoverRequest request){
        DiaryCover diaryCover= diaryCoverRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("not found: " + id));

        diaryCover.update(request.getDiaryCoverName(), request.getDiaryCoverKeyword());

        return diaryCover;
    }
}
