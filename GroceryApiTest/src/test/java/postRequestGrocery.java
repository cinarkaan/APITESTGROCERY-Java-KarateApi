import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class postRequestGrocery {

    @BeforeClass
    public void initializeJsonData () {
        RestAssured.baseURI = "https://494b24db-e699-4dbf-8078-8ac7951c593e.mock.pstmn.io/";
        RestAssured.basePath = "/addFood";
    }

    @Test
    public void addGrocery () {
        Header header = new Header("Accept","application/json");

        JSONObject food = new JSONObject();
        food.put("id",3);
        food.put("name","pepper");
        food.put("price",12.6);
        food.put("stock",55);

        Response response =
                given().contentType(ContentType.JSON).
                        body(food.toString()).
                        when().
                        post().
                        then().statusCode(201).statusLine("HTTP/1.1 201 Created").
                        extract().response();

    }

}
