package com.github.williamdlm.camel.dto;

import com.github.williamdlm.camel.model.LocalPatient;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.time.LocalDate;
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public record LocalPatientDTO(String firstName, String lastName, String codeDocumentId, LocalDate birthDate) {

    public LocalPatient toModel() {
        LocalPatient newLocalPatient = new LocalPatient(firstName, lastName, codeDocumentId, birthDate);
        return newLocalPatient;
    }
}
