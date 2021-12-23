package com.template.utlis.Objects;

import com.github.javafaker.Faker;
import io.restassured.path.json.JsonPath;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import static com.template.utlis.ObjectUtils.getRandomValue;

@Getter
@Setter
public class Brand {
    public static List<String> phoneCountries = Arrays.asList("United States", "German", "Austria", "Canada", "Mexico");
    static List<String> types = Arrays.asList("Trade-Only", "Trade-Focused", "Retailer");
    Faker faker = new Faker(new Locale("en-US"));
    private String parentCompanyLegalName;
    private String webSite;
    private String brandInstagram;
    private String tradeType;
    private String firstName;
    private String lastName;
    private String workEmail;
    private String workTitle;
    private String phoneCountry;
    private long phoneNumber;
    private String brandName;
    private int federalNumber;
    private String zipCode;
    private String address;
    private String city;
    private String state;


    public Brand(String path) {
        JsonPath jsonPath = JsonPath.from(new File(path));
        this.parentCompanyLegalName = jsonPath.get("parentCompany[0].parentCompanyName[0]");
        this.webSite = jsonPath.get("webSite[0]");
        this.brandInstagram = jsonPath.get("brandInstagram[0]");
        this.tradeType = jsonPath.get("tradeType[0]");
        this.firstName = jsonPath.get("firstName[0]");
        this.lastName = jsonPath.get("lastName[0]");
        this.workEmail = jsonPath.get("workEmail[0]");
        this.workTitle = jsonPath.get("workTitle[0]");
        this.phoneCountry = jsonPath.get("phoneCountry[0]");
        this.phoneNumber = jsonPath.get("phoneNumber[0]");
        this.brandName = jsonPath.get("brandName[0]");
        this.federalNumber = jsonPath.get("federalNumber[0]");
        this.zipCode = jsonPath.get("zipCode[0]");
        this.address = jsonPath.get("address[0]");
        this.city = jsonPath.get("city[0]");
        this.state = jsonPath.get("state[0]");
    }

    public static String getRandomTradeType() {
        return getRandomValue(types);
    }

    public static String getRandomPhoneCountry() {
        return getRandomValue(phoneCountries);
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        return builder.append("Brand name: ").append(brandName)
                .append("\nFirst name:").append(firstName)
                .append("\nLast name:").append(lastName)
                .append("\nWork Email:").append(workEmail)
                .append("\nWork Title:").append(workTitle)
                .append("\nPhone Country:").append(phoneCountry)
                .append("\nPhone Number:").append(phoneNumber)
                .append("\nFederal Number:").append(federalNumber)
                .append("\nState:").append(state)
                .append("\nCity:").append(city)
                .append("\nAddress:").append(address)
                .append("\nZip Code:").append(zipCode).toString();
    }

}
