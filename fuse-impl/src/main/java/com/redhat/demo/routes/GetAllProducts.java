package com.redhat.demo.routes;

import java.sql.SQLException;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

@Component
public class GetAllProducts extends RouteBuilder {

    @Override
    public void configure() throws Exception {

      onException(SQLException.class)
        .handled(true)
        .to("direct:databaseerror");

      from("direct:getproducts")
        .id("direct-getAllProducts")
        .to("sql:{{product.sql.selectAll}}")
        .marshal().json(JsonLibrary.Jackson);
    }
}