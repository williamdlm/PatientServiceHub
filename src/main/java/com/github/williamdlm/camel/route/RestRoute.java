package com.github.williamdlm.camel.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class RestRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("netty-http:http://localhost:8291/test?sync=true")
                .choice()
                .when(simple("${header.CamelHttpMethod} == 'GET'"))
                .setBody(constant("The request was GET"))
                .otherwise()
                .setBody(simple("The request was POST: ${body}"))
                .process(exchange -> {
                    if(exchange.getIn().getBody().toString().contains("foo"))
                        System.out.println("CONTAINS FOO");
                    System.out.println(exchange);
                })
                .log("${body}");
    }
}
