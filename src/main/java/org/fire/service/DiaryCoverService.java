package org.fire.service;

import lombok.RequiredArgsConstructor;
import org.fire.domain.DiaryCover;
import org.fire.dto.AddDiaryCoverRequest;
import org.fire.repository.DiaryCoverRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DiaryCoverService {
    private final DiaryCoverRepository diaryCoverRepository;

    public DiaryCover save(AddDiaryCoverRequest request){
        return diaryCoverRepository.save(request.toEntity());
    }
}
