package com.github.williamdlm.camel.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class LocalPatient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String codeDocumentId;
    private String birthDate;

    public LocalPatient(String firstName, String lastName, String codeDocumentId, String birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.codeDocumentId = codeDocumentId;
        this.birthDate = birthDate;
    }
}
