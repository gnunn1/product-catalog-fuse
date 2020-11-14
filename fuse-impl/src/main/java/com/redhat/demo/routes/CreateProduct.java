package com.redhat.demo.routes;

import com.redhat.demo.beans.JSONToHeadersBean;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class CreateProduct extends RouteBuilder {

    @Override
    public void configure() throws Exception {
      from("direct:createproduct")
        .bean(JSONToHeadersBean.class, "jsonToHeaders")
        .to("sql:{{product.sql.insert}}");
    }
}