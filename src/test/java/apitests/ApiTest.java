package apitests;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ApiTest {

    @BeforeTest
    public void setup(){
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Test
    public void verifyCommentWithId3() {
        given()
                .when()
                .get("/comments/3")
                .then()
                .statusCode(200)
                .body("name", equalTo("odio adipisci rerum aut animi"))
                .body("email", equalTo("Nikita@garfield.biz"))
                .log().ifError();
    }

    @Test
    public void postCommentAndVerifyId(){
        given()
                .contentType("application/json")
                .body("{\"postId\": 1, \"name\": \"Melissa\", \"email\": \"abc@gmail.com\"}")
                .when()
                .post("/comments")
                .then()
                .statusCode(201)
                .body("id", equalTo(501))
                .log().ifError();
    }

    @Test
    public void verifyUserWithId6(){
        given()
                .when()
                .get("/users/6")
                .then()
                .statusCode(200)
                .body("address.street", equalTo("Norberto Crossing"))
                .body("address.city", equalTo("South Christy"))
                .log().ifError();
    }
}
