package com.github.williamdlm.patientservicehub.service;

import com.github.williamdlm.patientservicehub.dto.LocalPatientDTO;
import com.github.williamdlm.patientservicehub.model.LocalPatient;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;


import java.util.List;
@WebService
public interface LocalPatientService {

    @WebMethod
    LocalPatient findByDocumentId(String codeDocumentId) throws Exception;


    @WebMethod
    LocalPatient savePatient(LocalPatientDTO localPatientDTO) throws Exception;

    @WebMethod
    List<LocalPatient> findAllPatient();
}
