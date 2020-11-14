package com.redhat.fuse.boosters.rest.demo;

import javax.annotation.Generated;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestParamType;
import org.springframework.stereotype.Component;

/**
 * Generated from OpenApi specification by Camel REST DSL generator.
 */
@Generated("org.apache.camel.generator.openapi.PathGenerator")
@Component
public final class CamelRoutes extends RouteBuilder {
    /**
     * Defines Apache Camel routes using REST DSL fluent API.
     */
    public void configure() {

        restConfiguration().component("servlet").contextPath("/");

        rest()
            .post("/api/auth")
                .description("Authenticate a user")
                .produces("application/json")
                .to("direct:rest1")
            .post("/api/auth/register")
                .description("Register a new user")
                .consumes("application/x-www-form-urlencoded")
                .param()
                    .name("email")
                    .type(RestParamType.formData)
                    .dataType("string")
                .endParam()
                .param()
                    .name("password")
                    .type(RestParamType.formData)
                    .dataType("string")
                .endParam()
                .param()
                    .name("password_confirmation")
                    .type(RestParamType.formData)
                    .dataType("string")
                .endParam()
                .to("direct:rest2")
            .get("/api/auth/user")
                .description("Get the current user")
                .produces("application/json")
                .to("direct:rest3")
            .get("/api/category")
                .produces("application/json")
                .to("direct:rest4")
            .post("/api/category")
                .description("Create a new category")
                .consumes("application/json")
                .param()
                    .name("body")
                    .type(RestParamType.body)
                    .required(true)
                .endParam()
                .to("direct:rest5")
            .get("/api/category/{id}")
                .description("Get specific category by ID")
                .produces("application/json")
                .param()
                    .name("id")
                    .type(RestParamType.path)
                    .dataType("integer")
                    .required(true)
                .endParam()
                .to("direct:rest6")
            .put("/api/category/{id}")
                .description("Update an existing category")
                .consumes("application/json")
                .produces("application/json")
                .param()
                    .name("id")
                    .type(RestParamType.path)
                    .dataType("integer")
                    .required(true)
                .endParam()
                .param()
                    .name("body")
                    .type(RestParamType.body)
                    .required(true)
                .endParam()
                .to("direct:rest7")
            .delete("/api/category/{id}")
                .description("Delete a category")
                .param()
                    .name("id")
                    .type(RestParamType.path)
                    .dataType("integer")
                    .required(true)
                .endParam()
                .to("direct:rest8")
            .get("/api/product")
                .description("Get product list with support for paging and ordering")
                .produces("application/json")
                .param()
                    .name("item_per_page")
                    .type(RestParamType.query)
                    .dataType("integer")
                    .defaultValue("0")
                    .required(false)
                .endParam()
                .param()
                    .name("name")
                    .type(RestParamType.query)
                    .dataType("string")
                    .required(false)
                .endParam()
                .param()
                    .name("order_by")
                    .type(RestParamType.query)
                    .dataType("string")
                    .defaultValue("name")
                    .required(false)
                .endParam()
                .param()
                    .name("order_type")
                    .type(RestParamType.query)
                    .dataType("string")
                    .defaultValue("asc")
                    .required(false)
                .endParam()
                .param()
                    .name("page")
                    .type(RestParamType.query)
                    .dataType("integer")
                    .defaultValue("0")
                    .required(false)
                .endParam()
                .to("direct:rest9")
            .post("/api/product")
                .description("Create a new product")
                .consumes("application/x-www-form-urlencoded")
                .produces("application/json")
                .param()
                    .name("name")
                    .type(RestParamType.formData)
                    .dataType("string")
                .endParam()
                .param()
                    .name("description")
                    .type(RestParamType.formData)
                    .dataType("string")
                .endParam()
                .param()
                    .name("category_id")
                    .type(RestParamType.formData)
                    .dataType("integer")
                .endParam()
                .param()
                    .name("price")
                    .type(RestParamType.formData)
                    .dataType("number")
                .endParam()
                .to("direct:rest10")
            .get("/api/product/count")
                .description("Get the total count of products available")
                .to("direct:rest11")
            .post("/api/product/delete")
                .description("Delete a set of products as specified by their IDs")
                .consumes("application/x-www-form-urlencoded")
                .param()
                    .name("del_ids[]")
                    .type(RestParamType.formData)
                .endParam()
                .to("direct:rest12")
            .get("/api/product/{id}")
                .description("Get specific product by it's ID")
                .produces("application/json")
                .param()
                    .name("id")
                    .type(RestParamType.path)
                    .dataType("integer")
                    .required(true)
                .endParam()
                .to("direct:rest13")
            .put("/api/product/{id}")
                .description("Update an existing product")
                .consumes("application/x-www-form-urlencoded")
                .produces("application/json")
                .param()
                    .name("id")
                    .type(RestParamType.path)
                    .dataType("integer")
                    .required(true)
                .endParam()
                .param()
                    .name("id")
                    .type(RestParamType.formData)
                    .dataType("integer")
                .endParam()
                .param()
                    .name("name")
                    .type(RestParamType.formData)
                    .dataType("string")
                .endParam()
                .param()
                    .name("description")
                    .type(RestParamType.formData)
                    .dataType("string")
                .endParam()
                .param()
                    .name("category_id")
                    .type(RestParamType.formData)
                    .dataType("integer")
                .endParam()
                .param()
                    .name("price")
                    .type(RestParamType.formData)
                    .dataType("number")
                .endParam()
                .to("direct:rest14")
            .delete("/api/product/{id}")
                .description("Delete a single product by ID")
                .param()
                    .name("id")
                    .type(RestParamType.path)
                    .dataType("integer")
                    .required(true)
                .endParam()
                .to("direct:rest15")
            .post("/api/user")
                .description("Create a new user")
                .consumes("application/json")
                .param()
                    .name("body")
                    .type(RestParamType.body)
                    .required(true)
                .endParam()
                .to("direct:rest16")
            .get("/api/user/{id}")
                .description("Get specific user by it's ID")
                .produces("application/json")
                .param()
                    .name("id")
                    .type(RestParamType.path)
                    .dataType("integer")
                    .required(true)
                .endParam()
                .to("direct:rest17")
            .put("/api/user/{id}")
                .description("Update an existing user")
                .consumes("application/json")
                .produces("application/json")
                .param()
                    .name("id")
                    .type(RestParamType.path)
                    .dataType("integer")
                    .required(true)
                .endParam()
                .param()
                    .name("body")
                    .type(RestParamType.body)
                    .required(true)
                .endParam()
                .to("direct:rest18")
            .delete("/api/user/{id}")
                .description("Delete a user")
                .param()
                    .name("id")
                    .type(RestParamType.path)
                    .dataType("integer")
                    .required(true)
                .endParam()
                .to("direct:rest19");
    }
}