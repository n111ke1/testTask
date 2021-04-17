1. https://api.openbrewerydb.org/breweries/search?query=dog
    - check response quantity with per_page and page params;
    example https://api.openbrewerydb.org/breweries//search?query=dog&per_page=1&page=10

2. Get All Breweries
GET https://api.openbrewerydb.org/breweries
    - check status code 200
    - check status code 404 with invalid url

3. Filter breweries by city
GET https://api.openbrewerydb.org/breweries?by_city=san_diego
    - check status code 200
    - check every response "city" have value "san_diego"
        use different query values like: "seattle", "sea", "san_diego", "san%20diego"

4. Filter breweries by state
GET https://api.openbrewerydb.org/breweries?by_state=Florida
    - check status code 200
    - check every response "state" have value "florida"
        use different query values like: "florida", "flo", "san_diego", "san%20diego"

5. Filter breweries by postal code (Boundary Value Testing, Equivalence Class Testing)
GET https://api.openbrewerydb.org/breweries?by_postal=44107
     - check response status code is 200;
     - check every response "postal" contains value "44107";
     - check is it possible to filter by 1 digits
     - check is it possible to filter by 5 digits
     - check is it possible to filter by 5 digits with hyphen (44107-)
     - check is it possible to filter by 9 digits with hyphen (44107-1015) max in USA
     - check is it possible to filter by 9 digits with underscore (44107_1015) -  response should be empty
     - check is it possible to filter by 10 digits (response should be empty)

6. Filter by type of brewery (Equivalence Class Testing)
GET https://api.openbrewerydb.org/breweries?by_type=micro
     - check response status code is 200;
     - check every response "type" contains value "micro";
     - check all available valid values: micro, regional, brewpub, large, planning, bar, contract, proprietor
     - check is it possible use type not from the list ("micro123")

7. Quantity of breweries to return each call (Boundary Value Testing)
    GET https://api.openbrewerydb.org/breweries?per_page=10
    - count values quantity in response (by default 20) https://api.openbrewerydb.org/breweries
    - check values quantity per_page = 0
    - check values quantity per_page = 1
    - check values quantity per_page = 50
    - check values quantity per_page = 51
    - check invalid value per_page = -1

9. Sort the results by one or more fields (Pairwise testing)
    GET https://api.openbrewerydb.org/breweries?by_state=ohio&sort=type,-name
    - sort=name,-type;
    - sort=-city,state;
    - sort=-postal_code,country;
    - sort=-longitude,latitude;
    - sort=-updated_at;
