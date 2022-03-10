
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class getRequestGrocery {

    @BeforeClass
    public void initialize () {
        RestAssured.baseURI = "https://494b24db-e699-4dbf-8078-8ac7951c593e.mock.pstmn.io";
        RestAssured.basePath = "/allGrocery";
    }

    @Test
    public void getStatusCodes () {
        given().
                when().
                get().
                then().statusCode(200).
                statusLine("HTTP/1.1 200 OK");
    }

    @Test
    public void getAllGroceryFoods () {
        given().
                when().
                get().
                then().
                log().
                body();
    }

    @Test
    public void getGroceryByName () {

        String name = "apple";

        given().
                when().
                get("?name="+name+"").
                then().
                log().
                body();
    }

}
