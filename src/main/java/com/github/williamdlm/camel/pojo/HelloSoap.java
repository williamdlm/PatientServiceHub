package com.github.williamdlm.camel.pojo;


import jakarta.jws.WebService;

@WebService
public interface HelloSoap {
    String sayHi(String text);
}
