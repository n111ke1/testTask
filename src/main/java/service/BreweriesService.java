package service;

import models.SearchResponse;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;

import java.util.Arrays;
import java.util.List;


public class BreweriesService extends BaseApi {


    public ValidatableResponse searchByTerm(String searchTerm) {
       ValidatableResponse response =  RestAssured
                .given(baseRequest())
                .when()
                .param("query", searchTerm)
                .get("search")
                .then();
       return response;
    }

    public List<SearchResponse> searchByTerm(String searchTerm, Integer statusCode, Integer per_page_value) {
        List<SearchResponse> response = Arrays.asList(RestAssured
                .given(baseRequest())
                .when()
                .param("query", searchTerm)
                .param("per_page", 1)
                .log().all()
                .get("search")
                .then()
                .statusCode(statusCode)
                .extract().response().getBody().as(SearchResponse[].class));
        return response;
    }


}
