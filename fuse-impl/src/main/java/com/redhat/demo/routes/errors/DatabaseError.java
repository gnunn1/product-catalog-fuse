package com.redhat.demo.routes.errors;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class DatabaseError extends RouteBuilder {
  
    @Override
    public void configure() throws Exception {
      from("direct:databaseerror")
        .id("error-databaseError")
        .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(500))
        .setHeader(Exchange.CONTENT_TYPE, constant("text/plain"))
        .setBody().constant("Unexpected error occurred in the database");
    }
}