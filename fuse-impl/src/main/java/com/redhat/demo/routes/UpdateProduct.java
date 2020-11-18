package com.redhat.demo.routes;

import java.sql.SQLException;

import com.redhat.demo.beans.JSONToHeadersBean;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class UpdateProduct extends RouteBuilder {

    @Override
    public void configure() throws Exception {

      onException(SQLException.class)
        .handled(true)
        .to("direct:databaseerror");

      from("direct:updateproduct")
        .routeId("direct-updateProduct")
        .bean(JSONToHeadersBean.class, "jsonToHeaders")
        .to("sql:{{product.sql.selectById}}")
        .choice()
          .when()
            .simple("${header.CamelSqlRowCount} == 1")
            .to("sql:{{product.sql.update}}")
          .otherwise()
            .log("Record does not exist, could not update record with id ${headers.id}")
            .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(404))
            .setHeader(Exchange.CONTENT_TYPE, constant("text/plain"))
            .setBody().constant("Record does not exist, could not update record");
    }
}