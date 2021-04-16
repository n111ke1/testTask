package apiModels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SearchResponseItem{

	@JsonProperty("country")
	private String country;

	@JsonProperty("brewery_type")
	private String breweryType;

	@JsonProperty("city")
	private String city;

	@JsonProperty("address_2")
	private Object address2;

	@JsonProperty("latitude")
	private Object latitude;

	@JsonProperty("address_3")
	private Object address3;

	@JsonProperty("created_at")
	private String createdAt;

	@JsonProperty("obdb_id")
	private String obdbId;

	@JsonProperty("website_url")
	private String websiteUrl;

	@JsonProperty("updated_at")
	private String updatedAt;

	@JsonProperty("phone")
	private String phone;

	@JsonProperty("street")
	private String street;

	@JsonProperty("name")
	private String name;

	@JsonProperty("county_province")
	private Object countyProvince;

	@JsonProperty("id")
	private int id;

	@JsonProperty("state")
	private String state;

	@JsonProperty("postal_code")
	private String postalCode;

	@JsonProperty("longitude")
	private Object longitude;
}