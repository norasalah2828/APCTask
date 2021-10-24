package data;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;

public class Specifications {
    public static RequestSpecification req;

    public static RequestSpecification requestSpecification(String accessKey, String country)
    {
        req=new RequestSpecBuilder()
                .setBaseUri("http://api.weatherstack.com/current")
                .addQueryParam("access_key",accessKey)
                .addQueryParam("query",country)
                .build();
        return req;
    }
}
