package org.oldcode;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class trialRun {
    // This is my first time performing API Test. This was what I came up with initially using Rest Assured
    // Check the "apitests" package under "test" package for the complete one
    @Test
    public void verifyCommentWithId3(){
        Response response = RestAssured.get("https://jsonplaceholder.typicode.com/comments/3");

        assertEquals(response.getStatusCode(), 200);

        String responseBody = response.getBody().asString();
        String expectedName = "odio adipisci rerum aut animi";
        String expectedEmail = "Nikita@garfield.biz";

        String actualName = response.jsonPath().getString("name");
        String actualEmail = response.jsonPath().getString("email");

        assertEquals(actualName, expectedName, "Name value verification failure! " +
                "Expected: " + expectedName +
                "Actual: " + actualName);

        assertEquals(actualEmail, expectedEmail, "Email value verification failure! " +
                "Expected: " + expectedEmail +
                "Actual: " + actualEmail);
    }
}
