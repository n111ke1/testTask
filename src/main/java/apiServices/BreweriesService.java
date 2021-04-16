package apiServices;

import apiModels.SearchResponse;
import io.restassured.RestAssured;

import java.util.Arrays;
import java.util.List;


public class BreweriesService extends BaseApi {


    public void searchByTerm(String searchTerm, Integer statusCode) {
        RestAssured
                .given(baseRequest())
                .when()
                .param("query", searchTerm)
                .get("search")
                .then()
                .statusCode(statusCode);
    }

    public Integer searchByTerm(String searchTerm, Integer statusCode, Integer per_page_value) {
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
        return response.size();
    }


}
