package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchResponseItem{

	@JsonProperty("country")
	private String country;

	@JsonProperty("brewery_type")
	private String brewery_Type;

	@JsonProperty("city")
	private String city;

	@JsonProperty("address_2")
	private String address_2;

	@JsonProperty("latitude")
	private String latitude;

	@JsonProperty("address_3")
	private String address_3;

	@JsonProperty("created_at")
	private String created_At;

	@JsonProperty("obdb_id")
	private String obdb_id;

	@JsonProperty("website_url")
	private String website_url;

	@JsonProperty("updated_at")
	private String updated_at;

	@JsonProperty("phone")
	private String phone;

	@JsonProperty("street")
	private String street;

	@JsonProperty("name")
	private String name;

	@JsonProperty("county_province")
	private String county_province;

	@JsonProperty("id")
	private int id;

	@JsonProperty("state")
	private String state;

	@JsonProperty("postal_code")
	private String postal_code;

	@JsonProperty("longitude")
	private String longitude;
}