package com.api.v1.patient.services;

import com.api.v1.patient.domain.PatientRepository;
import com.api.v1.patient.dtos.PatientResponseDto;
import com.api.v1.patient.mapper.PatientResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
class AllPatientsRetrieverServiceImpl implements AllPatientsRetrieverService {

    private final PatientRepository patientRepository;

    @Override
    public Flux<PatientResponseDto> findAll() {
        return patientRepository
                .findAll()
                .flatMap(patient -> Flux.just(PatientResponseMapper.map(patient)));
    }

}
