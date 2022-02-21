package apiTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GetTests {

    public static RequestSpecification httpRequest;

    @BeforeClass
    public static void setup(){
        RestAssured.baseURI = "https://reqres.in";
        httpRequest = RestAssured.given();

    }

    @Test
    public static void getUserDetails(){

        Response response = httpRequest.get("/api/users/2");
        Assert.assertEquals(200, response.getStatusCode());
        Assert.assertEquals("janet.weaver@reqres.in", response.jsonPath().get("data.email"));

    }

}
