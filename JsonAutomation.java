package org.example;

import io.restassured.response.Response;
//import org.junit.jupiter.api.Test;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class JsonAutomation
{
    @Test (priority = 1)
    public void post()
    {
        Response response = given()
                .header("accept","*/*")
                .header("Content-Type","application/json")
                .body("{\n" +
                        "    \"id\": \"16\",\n" +
                        "    \"name\": \"RRaj\",\n" +
                        "    \"username\": \"Anjali\",\n" +
                        "    \"email\": \"Shanna@melissa.tv\",\n" +
                        "    \"address\": {\n" +
                        "        \"street\": \"Ghansoli\",\n" +
                        "        \"suite\": \"Suite 879\",\n" +
                        "        \"city\": \"Wisokyburgh\",\n" +
                        "        \"zipcode\": \"90566-7771\",\n" +
                        "        \"geo\": {\n" +
                        "            \"lat\": \"-43.9509\",\n" +
                        "            \"lng\": \"-34.4618\"\n" +
                        "        }\n" +
                        "    },\n" +
                        "    \"phone\": \"010-692-6593 x09125\",\n" +
                        "    \"website\": \"anastasia.net\",\n" +
                        "    \"company\": {\n" +
                        "        \"name\": \"Deckow-Crist\",\n" +
                        "        \"catchPhrase\": \"Proactive didactic contingency\",\n" +
                        "        \"bs\": \"synergize scalable supply-chains\"\n" +
                        "    }\n" +
                        "}")
                .when()
                .post("http://localhost:3000/Users");
        response.prettyPrint();
        response.then().statusCode(201);
    }
    @Test
    public void put()
    {
        Response response = given()
                .header("accept","*/*\n")
                .header("Content-Type","application/json")
                .body("{\n" +
                        "            \"id\": \"1\",\n" +
                        "            \"name\": \"Raj\",\n" +
                        "            \"username\": \"Antonette\",\n" +
                        "            \"email\": \"Shanna@melissa.tv\",\n" +
                        "            \"address\": {\n" +
                        "                \"street\": \"Victor Plains\",\n" +
                        "                \"suite\": \"Suite 879\",\n" +
                        "                \"city\": \"Wisokyburgh\",\n" +
                        "                \"zipcode\": \"90566-7771\",\n" +
                        "                \"geo\": {\n" +
                        "                    \"lat\": \"-43.9509\",\n" +
                        "                    \"lng\": \"-34.4618\"\n" +
                        "                }\n" +
                        "            },\n" +
                        "            \"phone\": \"010-692-6593 x09125\",\n" +
                        "            \"website\": \"anastasia.net\",\n" +
                        "            \"company\": {\n" +
                        "                \"name\": \"Deckow-Crist\",\n" +
                        "                \"catchPhrase\": \"Proactive didactic contingency\",\n" +
                        "                \"bs\": \"synergize scalable supply-chains\"\n" +
                        "            }}")
                .when()
                .put("http://localhost:3000/Users/1");
        response.prettyPrint();
        response.then().statusCode(200);
    }
    @Test
    public void patch()
    {
        Response response = given()
                .header("accept","*/*\n")
                .header("Content-Type","application/json")
                .body("{\"name\": \"RRaj\"}")
                .when()
                .patch("http://localhost:3000/Users/1");
        response.prettyPrint();
        response.then().statusCode(200);
    }
    @Test
    public void get()
    {
        Response response = given()
                .header("accept","application/json")
                .when()
                .get("http://localhost:3000/Users");
        response.prettyPrint();
        response.then().statusCode(200);
    }
    @Test
    public void delete()
    {
        Response response = given()
                .header("accept","application/json")
                .when()
                .delete("http://localhost:3000/Users/11");
        response.prettyPrint();
        response.then().statusCode(404);
    }
}
