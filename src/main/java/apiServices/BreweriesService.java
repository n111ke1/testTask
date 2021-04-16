package apiServices;

import apiModels.SearchResponse;
import apiModels.SearchResponseItem;
import io.restassured.RestAssured;

import java.util.List;


public class BreweriesService extends BaseApi {


    public void getSearch(String searchTerm, Integer statusCode){
        RestAssured
                .given(baseRequest())
                .when()
                .param("query", searchTerm)
                .log().all()
                .get("search")
                .then()
                .log().all()
                .statusCode(statusCode);
    }

    public Integer getSearchPerPage(String searchTerm, Integer statusCode, Integer per_page_value){
           List<SearchResponseItem> searchResponse =  RestAssured
                .given(baseRequest())
                .when()
                .param("query", searchTerm)
                .param("per_page", 1)
                .log().all()
                .get("search")
                .then()
                .log().all()
                .statusCode(statusCode)
                   .extract().body().as(SearchResponse.class).getSearchResponse();
           return searchResponse.size();
    }



}
