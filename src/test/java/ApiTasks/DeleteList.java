package ApiTasks;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class DeleteList {

    private final static String baseUrl = "https://api.trello.com/";
    private final static String yourkey = "77c295ce5af4dcf6e1878306ace9d3ca";
    private final static String yourtoken = "1a1cfab1a058439ea474fd2de6d58cc3c37536dbdbb7e3a83bc6ce91bd799c7d";
    private final static int Boardid = 123;


    @Before
    public static void setup() {
        RestAssured.baseURI = "https://api.trello.com";
    }

    @Test
    public void deleteList(int Boardid) {
        Response response = given()
                .header("Content-type", "application/json")
                .pathParam("id", Boardid)
                .when()
                .delete("/1/lists/{id}/closed")
                .then()
                .extract().response();

        Assert.assertEquals(200, response.statusCode());
    }

}