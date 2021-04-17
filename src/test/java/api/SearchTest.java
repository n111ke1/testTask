package api;


import models.SearchResponse;
import service.BreweriesService;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class SearchTest {
    private final BreweriesService breweriesService = new BreweriesService();
    public final static String ERROR_MESSAGE = "Couldn't find Brewery with 'id'=searching";


    @Test(groups = "SearchProcess")
    public void checkSearchWithValidName() {
        String breweryName = "Barrel Dog Brewing";
        List<SearchResponse>response =  breweriesService.getBrewery(breweryName);
        assertThat(response).isNotEmpty();
        response.forEach(r->assertThat(r.getName()).containsIgnoringCase(breweryName));
    }

    @Test(groups = "SearchProcess")
    public void checkSearchWithValidStreet() {
        String breweryStreet = "4547 N Rancho Dr Ste A";
        List<SearchResponse>response =  breweriesService.getBrewery(breweryStreet);
        assertThat(response.size()).isEqualTo(1);
        response.forEach(r->assertThat(r.getStreet()).containsIgnoringCase(breweryStreet));
    }

    @Test(groups = "SearchProcess")
    public void checkSearchWithValidWebSite() {
        String breweryWebSite = "http://www.willowrockbrew.com";
        List<SearchResponse>response = breweriesService.getBrewery(breweryWebSite);
        assertThat(response.size()).isEqualTo(1);
        response.forEach(r->assertThat(r.getWebsiteUrl()).isEqualToIgnoringCase(breweryWebSite));
    }

    @Test(groups = "SearchProcess")
    public void checkSearchWithInvalidURL() {
       String resp =  breweriesService.getBreweryBadRequest("/searching");
        assertThat(resp).containsIgnoringCase(ERROR_MESSAGE);
    }



    @Test(dataProvider = "searchInValidValue", groups = "SearchProcess")
    public void checkSearchWithInvalidParam(String value) {
        List<SearchResponse>response = breweriesService.getBrewery(value);
        assertThat(response).isEmpty();
    }


    @DataProvider(name = "searchInValidValue")
    public static Object[][] value() {
        return new Object[][]{
                {""},
                {null},
                {"invalidData"},
                {"%20"}};
    }






}
