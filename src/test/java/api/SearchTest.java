package api;

import models.SearchResponse;
import service.BreweriesService;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SearchTest {
    BreweriesService breweriesService = new BreweriesService();


    @DataProvider(name = "searchValue")
    public static Object[][] value() {
        return new Object[][]{{"dog", 200}, {"Airways Brewing", 200}, {null, 200}};
    }


    @Test(dataProvider = "searchValue")
    public void checkSearchStatusCode(String searchTerms, Integer statusCode) {
         breweriesService.searchByTerm(searchTerms).assertThat().statusCode(statusCode);

    }


    @Test()
    public void checkSearchPepPageResult() {
        List<SearchResponse> searchResponses = breweriesService.searchByTerm("dog", 200, 1);
        assertThat(searchResponses.size()).isEqualTo(1);
    }

}
