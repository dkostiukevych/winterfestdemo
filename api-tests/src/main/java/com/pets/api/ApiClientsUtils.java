package com.pets.api;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;

import java.util.function.Function;
import java.util.function.Supplier;

import static com.pets.api.pets.GsonObjectMapper.gson;
import static io.restassured.config.ObjectMapperConfig.objectMapperConfig;
import static io.restassured.config.RestAssuredConfig.config;
import static io.restassured.http.ContentType.JSON;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class ApiClientsUtils {

    public static Supplier<RequestSpecBuilder> supplier() {
        return () -> new RequestSpecBuilder()
                .setContentType(JSON)
                .setConfig(config().objectMapperConfig(
                        objectMapperConfig()
                        .defaultObjectMapper(gson())))
                .addFilter(new ErrorLoggingFilter())
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new AllureRestAssured());
    }

    public static final Function<Response, Response> RESPONSE_200_HANDLER = r -> {
        assertThat(r.statusCode(), equalTo(SC_OK));
        return r;
    };

    public static final Function<Response, Response> RESPONSE_HANDLER = r -> r;

    @Override
    public String toString() {
        return super.toString();
    }
}
