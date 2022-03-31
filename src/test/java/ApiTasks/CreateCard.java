package ApiTasks;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class CreateCard {

    private final static String baseUrl = "https://api.trello.com/";
    private final static String yourkey = "77c295ce5af4dcf6e1878306ace9d3ca";
    private final static String yourtoken = "1a1cfab1a058439ea474fd2de6d58cc3c37536dbdbb7e3a83bc6ce91bd799c7d";
    private final static String idList="5abbe4b7ddc1b351ef961414" ;
    private final static String cardname="test" ;

    @Test
    public void  CreateCard  (String idList,String cardname) {

            RestAssured.baseURI = "https://api.trello.com";

            given().log().all().queryParam("key", yourkey)
                    .header("Content-type", "application/json")
                    .queryParam("token", yourtoken)
                    .queryParam("idList", idList)
                    .queryParam("name", cardname)
                    .when().post("1/cards")
                    .then().log().all().assertThat().statusCode(200);

        }

    }
