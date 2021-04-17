package service;

import io.restassured.response.ValidatableResponse;
import models.SearchResponse;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_NOT_FOUND;
import static org.apache.http.HttpStatus.SC_OK;


public class BreweriesService extends BaseApi {


    public List<SearchResponse> getBrewery(String searchTerm) {
        List<SearchResponse> response = Arrays.asList(
                given(baseRequest())
                        .when()
                        .log().all()
                        .param("query", searchTerm)
                        .get("search")
                        .then().statusCode(SC_OK)
                        .extract().response().as(SearchResponse[].class));
        return response;
    }

    public String getBreweryBadRequest(String inValidRequest) {
              return given(baseRequest())
                        .when()
                        .log().all()
                        .param("query")
                        .get(inValidRequest)
                        .then().statusCode(SC_NOT_FOUND)
                        .extract().asString();
    }



}
