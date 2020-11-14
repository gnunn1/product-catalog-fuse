package com.redhat.demo.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

@Component
public class GetAllProducts extends RouteBuilder {

    @Override
    public void configure() throws Exception {
      from("direct:getproducts")
        .to("sql:{{product.sql.selectAll}}")
        .marshal().json(JsonLibrary.Jackson);
    }
}