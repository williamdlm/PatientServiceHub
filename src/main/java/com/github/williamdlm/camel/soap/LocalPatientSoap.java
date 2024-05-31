package com.github.williamdlm.camel.soap;

import com.github.williamdlm.camel.dto.LocalPatientDTO;
import com.github.williamdlm.camel.service.LocalPatientServiceImpl;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@WebService
@Component
public class LocalPatientSoap {
    @Autowired
    LocalPatientServiceImpl localPatientServiceImpl;

    @WebMethod
    public void savePatient(LocalPatientDTO localPatientDTO) {
        localPatientServiceImpl.savePatient(localPatientDTO);
    }
}
