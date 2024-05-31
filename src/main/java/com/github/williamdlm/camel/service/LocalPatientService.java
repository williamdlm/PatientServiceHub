package com.github.williamdlm.camel.service;

import com.github.williamdlm.camel.dto.LocalPatientDTO;
import com.github.williamdlm.camel.model.LocalPatient;
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
