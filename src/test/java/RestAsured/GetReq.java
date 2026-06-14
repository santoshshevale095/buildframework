package RestAsured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GetReq {

    @Test
    public void getuser(){

        Response response =    RestAssured
                .given()
                .when()
                .get("https://automationexercise.com");
        response.then().statusCode(200);

        System.out.println(response.asPrettyString());

    }

}
