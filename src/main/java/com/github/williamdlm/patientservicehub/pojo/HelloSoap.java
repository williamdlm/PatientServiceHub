package com.github.williamdlm.patientservicehub.pojo;


import jakarta.jws.WebService;

@WebService
public interface HelloSoap {
    String sayHi(String text);
}
