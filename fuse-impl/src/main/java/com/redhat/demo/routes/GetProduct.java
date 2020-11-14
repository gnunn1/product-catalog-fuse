package com.redhat.demo.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

@Component
public class GetProduct extends RouteBuilder {

    @Override
    public void configure() throws Exception {
      from("direct:getproduct")
        .to("sql:{{product.sql.selectById}}")
        .marshal().json(JsonLibrary.Jackson);
    }
}