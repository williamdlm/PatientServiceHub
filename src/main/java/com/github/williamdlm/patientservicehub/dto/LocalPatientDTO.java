package com.github.williamdlm.patientservicehub.dto;

import com.github.williamdlm.patientservicehub.model.LocalPatient;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class LocalPatientDTO {

    String firstName;
    String lastName;
    String codeDocumentId;
    String birthDate;

    public LocalPatient toModel() {
        LocalPatient newLocalPatient = new LocalPatient(firstName, lastName, codeDocumentId, birthDate);
        return newLocalPatient;
    }
}
