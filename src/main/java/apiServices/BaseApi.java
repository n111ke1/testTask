package apiServices;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;


abstract class BaseApi {

    public RequestSpecification baseRequest(){
        RestAssured.baseURI = "https://api.openbrewerydb.org/";
        RestAssured.basePath = "breweries";
        RequestSpecification requestSpec = new RequestSpecBuilder()
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .build();
        return requestSpec;
    }



}
