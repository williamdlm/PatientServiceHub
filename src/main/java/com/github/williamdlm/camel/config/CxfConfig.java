package com.github.williamdlm.camel.config;

import com.github.williamdlm.camel.pojo.HelloSoapImpl;
import jakarta.xml.ws.Endpoint;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CxfConfig {


    @Autowired
    Bus bus;

    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, new HelloSoapImpl());
        endpoint.publish("/hello"); // http://localhost:8080/services/hello?wsdl
        return endpoint;
    }
}