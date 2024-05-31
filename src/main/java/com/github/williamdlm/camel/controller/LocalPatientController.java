package com.github.williamdlm.camel.controller;

import com.github.williamdlm.camel.dto.LocalPatientDTO;
import com.github.williamdlm.camel.model.LocalPatient;
import com.github.williamdlm.camel.service.LocalPatientServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/")
@RequiredArgsConstructor
public class LocalPatientController {
    private final LocalPatientServiceImpl localPatientServiceImpl;

    @GetMapping
    public ResponseEntity<List<LocalPatient>> findAllPatient() {
        return ResponseEntity.ok(localPatientServiceImpl.findAllPatient());
    }

    @PostMapping
    public ResponseEntity<LocalPatient> savePatient(@RequestBody LocalPatientDTO localPatientDTO) throws Exception {
      localPatientServiceImpl.savePatient(localPatientDTO);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{codeDocumentId}")
                .buildAndExpand(localPatientDTO.getCodeDocumentId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{codeDocumentId}")
    public ResponseEntity<LocalPatient> findByDocument(@PathVariable String codeDocumentId) throws Exception {
        LocalPatient localPatient = localPatientServiceImpl.findByDocumentId(codeDocumentId);
        return ResponseEntity.ok(localPatient);
    }
}
