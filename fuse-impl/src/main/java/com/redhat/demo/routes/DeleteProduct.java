package com.redhat.demo.routes;

import java.sql.SQLException;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class DeleteProduct extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        onException(SQLException.class)
            .handled(true)
            .to("direct:databaseerror");

        from("direct:deleteproduct")
            .routeId("direct-deleteProduct")
            .to("sql:{{product.sql.delete}}");
}
}