package service;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import utils.PropertyUtils;


abstract class BaseApi {

    public RequestSpecification baseRequest() {
        RestAssured.baseURI = PropertyUtils.getProperty("baseApiUrl");
        RestAssured.basePath = PropertyUtils.getProperty("baseApiPath");
        RequestSpecification requestSpec = new RequestSpecBuilder()
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .build();
        return requestSpec;
    }


}
