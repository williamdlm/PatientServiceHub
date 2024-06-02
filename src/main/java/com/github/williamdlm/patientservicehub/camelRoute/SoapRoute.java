package com.github.williamdlm.patientservicehub.camelRoute;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class SoapRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("cxf:/hello?serviceClass=com.github.williamdlm.camel.services.SoapService") //http:localhost:8080/hello?wsdl
                .log("Received request for ${header.CamelCxfMessage}");
//                .to("bean:SoapServiceImpl");
    }
}
