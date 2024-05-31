package com.github.williamdlm.camel.service;

import com.github.williamdlm.camel.dto.LocalPatientDTO;
import com.github.williamdlm.camel.exception.PatientNotFoundException;
import com.github.williamdlm.camel.model.LocalPatient;
import com.github.williamdlm.camel.repository.LocalPatientRepository;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import lombok.RequiredArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@WebService(endpointInterface = "com.github.williamdlm.camel.service.LocalPatientService")
public class LocalPatientServiceImpl implements LocalPatientService {

    private final LocalPatientRepository patientRepository;

    @WebMethod
    public LocalPatient findByDocumentId(String codeDocumentId) throws Exception {
        return patientRepository.findByCodeDocumentId(codeDocumentId).orElseThrow(() -> new PatientNotFoundException("Patient not found"));

    }


    @WebMethod
    public LocalPatient savePatient(LocalPatientDTO localPatientDTO) throws Exception {
        patientRepository.save(localPatientDTO.toModel());
        LocalPatient newPatient = patientRepository.findByCodeDocumentId(localPatientDTO.getCodeDocumentId()).orElseThrow(()-> new Exception("Patient not found"));
        return newPatient;
    }

    @WebMethod
    public List<LocalPatient> findAllPatient() {
        List<LocalPatient> patientList = patientRepository.findAll();
        return patientList;
    }
}
