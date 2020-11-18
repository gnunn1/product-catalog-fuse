package com.redhat.demo.routes;

import java.sql.SQLException;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

@Component
public class GetProduct extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        onException(SQLException.class)
            .handled(true)
            .to("direct:databaseerror");

        from("direct:getproduct")
            .routeId("direct-getProductById")
            .to("sql:{{product.sql.selectById}}")
            .marshal().json(JsonLibrary.Jackson);
    }
}