import apiServices.BreweriesService;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ApiTests {
    BreweriesService breweriesService = new BreweriesService();


    @DataProvider(name = "searchValue")
    public static Object[][] value() {
        return new Object[][]{{"dog", 200}, {"Airways Brewing", 200}, {null, 200}};
    }


    @Test(dataProvider = "searchValue")
    public void checkSearchStatusCode(String searchTerms, Integer statusCode) {
        breweriesService.searchByTerm(searchTerms, statusCode);
    }


    @Test()
    public void checkSearchPepPageResult() {
        int breweriesQuantity = breweriesService.searchByTerm("dog", 200, 1);
        assertThat(breweriesQuantity).isEqualTo(1);
    }

}
