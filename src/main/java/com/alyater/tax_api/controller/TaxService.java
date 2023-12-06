package com.alyater.tax_api.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.alyater.tax_api.model.AuthenticatedUser;
import com.alyater.tax_api.model.BillData;
import com.alyater.tax_api.model.ExpenseData;
import com.alyater.tax_api.model.User;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * The `TaxService` class provides methods to interact with a tax-related API.
 */
public class TaxService {
    // Static RestTemplate instance for making HTTP requests
    static RestTemplate restTemplate = new RestTemplate();

    // Base URL of the tax API
    static String baseUrl = "http://91.144.16.41/Taxapi/";

    /**
     * Performs user authentication and returns an authenticated user with a token.
     *
     * @param user The user object containing login credentials.
     * @return AuthenticatedUser object with user details and access token.
     */
    public AuthenticatedUser login(User user) {

        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Object> requesEntity = new HttpEntity<>(user, headers);

        // Make a POST request to the API endpoint for user authentication
        ResponseEntity<String> responseEntity = restTemplate.exchange(baseUrl + "api/Account/AccountingSoftWareLogin",
                HttpMethod.POST, requesEntity, String.class);

        // Get token from response body
        JsonObject jsonObject = JsonParser.parseString(responseEntity.getBody()).getAsJsonObject();
        JsonObject loginData = jsonObject.getAsJsonObject("data");
        String token = loginData.get("token").getAsString();

        // Create and return an AuthenticatedUser with user details and access token
        return new AuthenticatedUser(user.getUsername(), user.getPassword(), user.getTaxnumber(), token);

    }

    /**
     * Retrieves all taxes from the tax API.
     *
     * @param accessToken The access token for authentication.
     * @return A JSON string containing the response from the API.
     */
    public String getAllTaxs(String accessToken) {

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", accessToken);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> requesEntity = new HttpEntity<>("{}", headers);
        // Make a POST request to the API endpoint for retrieving all taxes
        ResponseEntity<String> responseEntity = restTemplate.exchange(baseUrl + "api/bill/GetAllTaxes",
                HttpMethod.POST, requesEntity, String.class);

        // Return the JSON response from the API
        return responseEntity.getBody();

    }

    // Similar methods for retrieving all items, bill types, and expenses types...

    public String getAllItem(String accessToken) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", accessToken);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> requesEntity = new HttpEntity<>("{}", headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(baseUrl + "api/bill/GetAllItems",
                HttpMethod.POST, requesEntity, String.class);
        System.out.println(responseEntity.getStatusCode());
        return responseEntity.getBody();

    }

    public String getAllBillType(String accessToken) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", accessToken);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> requesEntity = new HttpEntity<>("{}", headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(baseUrl + "api/bill/GetAllBillType",
                HttpMethod.POST, requesEntity, String.class);
        System.out.println(responseEntity.getStatusCode());
        return responseEntity.getBody();
    }

    public String GetAllExpensesType(String accessToken) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", accessToken);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> requesEntity = new HttpEntity<>("{}", headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(baseUrl + "api/Expenses/GetAllExpensesType",
                HttpMethod.POST, requesEntity, String.class);
        System.out.println(responseEntity.getStatusCode());
        return responseEntity.getBody();
    }

    /**
     * Adds a new bill to the tax API.
     *
     * @param bill        The BillData object representing the bill to be added.
     * @param accessToken The access token for authentication.
     * @return A JSON string containing the response from the API.
     */
    public String addBill(BillData bill, String accessToken) {
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", accessToken);

        HttpEntity<Object> requesEntity = new HttpEntity<>(bill, headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(baseUrl + "api/Bill/AddBill",
                HttpMethod.POST, requesEntity, String.class);
        return responseEntity.getBody();
    }

    /**
     * Adds a new expense to the tax API.
     *
     * @param expenseBill The ExpenseData object representing the expense to be
     *                    added.
     * @param accessToken The access token for authentication.
     * @return A JSON string containing the response from the API.
     */
    public String addExpense(ExpenseData expenseBill, String accessToken) {
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", accessToken);

        HttpEntity<Object> requesEntity = new HttpEntity<>(expenseBill, headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(baseUrl + "api/Expenses/AddExpense",
                HttpMethod.POST, requesEntity, String.class);
        System.out.println(responseEntity.getStatusCode());
        return responseEntity.getBody();
    }

}
