package com.github.williamdlm.patientservicehub.repository;

import com.github.williamdlm.patientservicehub.model.LocalPatient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocalPatientRepository extends JpaRepository<LocalPatient, Long> {

    Optional<LocalPatient> findByCodeDocumentId(String codeDocumentId);
}
