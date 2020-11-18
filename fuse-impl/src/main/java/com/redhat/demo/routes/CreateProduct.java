package com.redhat.demo.routes;

import java.sql.SQLException;

import com.redhat.demo.beans.JSONToHeadersBean;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class CreateProduct extends RouteBuilder {

    @Override
    public void configure() throws Exception {

      onException(SQLException.class)
        .handled(true)
        .to("direct:databaseerror");

      from("direct:createproduct")
        .id("direct-createProduct")
        .bean(JSONToHeadersBean.class, "jsonToHeaders")
        .to("sql:{{product.sql.insert}}");
    }
}