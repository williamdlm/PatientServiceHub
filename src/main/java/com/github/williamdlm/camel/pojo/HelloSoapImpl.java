package com.github.williamdlm.camel.pojo;

import jakarta.jws.WebService;
import org.springframework.stereotype.Service;

@Service
@WebService(endpointInterface = "com.github.williamdlm.camel.pojo.HelloSoap")
public class HelloSoapImpl implements HelloSoap{
    @Override
    public String sayHi(String text) {
        System.out.println("sayHi called");
        return "Hello " + text;
    }
}
