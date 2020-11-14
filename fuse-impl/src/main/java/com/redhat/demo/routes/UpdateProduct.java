package com.redhat.demo.routes;

import com.redhat.demo.beans.JSONToHeadersBean;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class UpdateProduct extends RouteBuilder {

    @Override
    public void configure() throws Exception {
      from("direct:updateproduct")
        .bean(JSONToHeadersBean.class, "jsonToHeaders")
        .to("sql:{{product.sql.selectById}}")
        .choice()
          .when()
            .simple("${header.CamelSqlRowCount} == 1")
            .to("sql:{{product.sql.update}}")
          .otherwise()
            .log("Record does not exist, could not insert record with id ${headers.id}")
            .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(404));
    }
}