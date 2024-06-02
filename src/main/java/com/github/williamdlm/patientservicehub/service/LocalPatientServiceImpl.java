package com.github.williamdlm.patientservicehub.service;

import com.github.williamdlm.patientservicehub.dto.LocalPatientDTO;
import com.github.williamdlm.patientservicehub.exception.PatientNotFoundException;
import com.github.williamdlm.patientservicehub.model.LocalPatient;
import com.github.williamdlm.patientservicehub.repository.LocalPatientRepository;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
