package com.github.williamdlm.camel.repository;

import com.github.williamdlm.camel.model.LocalPatient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocalPatientRepository extends JpaRepository<LocalPatient, Long> {

    Optional<LocalPatient> findByCodeDocumentId(String codeDocumentId);
}
