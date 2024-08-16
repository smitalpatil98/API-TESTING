package org.example;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class PetStoreAutomation
{
    //USER
    @Test
    public void create_user()
        {
        Response response = given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .body("{\n" +
                        "  \"id\": 1,\n" +
                        "  \"username\": \"Smital98\",\n" +
                        "  \"firstName\": \"Smital\",\n" +
                        "  \"lastName\": \"Patil\",\n" +
                        "  \"email\": \"string\",\n" +
                        "  \"password\": \"patil@1992\",\n" +
                        "  \"phone\": \"string\",\n" +
                        "  \"userStatus\": 0\n" +
                        "}").when().post("https://petstore.swagger.io/v2/user");
        response.prettyPrint();
        response.then().statusCode(200);
        }
        @Test
        public void create_user_array()
        {
    Response response = given()
            .header("accept","application/json")
            .header("Content-Type","application/json")
            .body("[\n" +
                    "  {\n" +
                    "   \n" +
                    "    \"id\": 30,\n" +
                    "    \"username\": \"smital98\",\n" +
                    "    \"firstName\": \"smit\",\n" +
                    "    \"lastName\": \"string\",\n" +
                    "    \"email\": \"string\",\n" +
                    "    \"password\": \"patil@1992\",\n" +
                    "    \"phone\": \"8451098452\",\n" +
                    "    \"userStatus\": 0\n" +
                    "  \n" +
                    "  } \n" +
                    "]")
            .when()
            .post("https://petstore.swagger.io/v2/user/createWithArray");
            response.prettyPrint();
            response.then().statusCode(200);
}
  @Test
  public void username()
{
    Response response = given()
            .header("accept","application/json")

            .queryParam("un","smital98")
            .when()
            .get("https://petstore.swagger.io/v2/user/smital98");
    response.prettyPrint();
    response.then().statusCode(200);
}
@Test
    public void user_login()
{
 Response response = given()
         .header("accept","application/json")
         .queryParam("username","smital98")
         .queryParam("password","patil@92")
         .when()
         //.get("https://petstore.swagger.io/v2/user/login?username=smital98&password=patil%4092");
 .get("https://petstore.swagger.io/v2/user/login");
 response.prettyPrint();
 response.then().statusCode(200);

}
@Test
    public void user_logout()
{
    Response response = given()
            .header("accept","application/json")
            .when()
            .get("https://petstore.swagger.io/v2/user/logout");
    response.prettyPrint();
    response.then().statusCode(200);
}
@Test (priority = 1)
    public void get_username()
    {
        Response response = given()
                .header("accept","application/json")
                .when()
                .get("https://petstore.swagger.io/v2/user/smital98");
        response.prettyPrint();
        response.then().statusCode(200);
    }

    @Test (priority = 2)
    public void put_username()
    {
        Response response = given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .body("{\n" +
                        "  \"id\": 23,\n" +
                        "  \"username\": \"smital98\",\n" +
                        "  \"firstName\": \"sonar\",\n" +
                        "  \"lastName\": \"seth\",\n" +
                        "  \"email\": \"string\",\n" +
                        "  \"password\": \"patil@92\",\n" +
                        "  \"phone\": \"string\",\n" +
                        "  \"userStatus\": 0\n" +
                        "}")
                .when()
                .put("https://petstore.swagger.io/v2/user/smital98");
        response.prettyPrint();
        response.then().statusCode(200);
    }
    @Test (priority = 3)
    public void delete_username()
    {
        Response response = given()
                .header("accept","application/json")
                .when()
                .delete("https://petstore.swagger.io/v2/user/smital98");
        response.prettyPrint();
        response.then().statusCode(200);
    }
    //STORE
    @Test
    public void post_order()
    {
      Response response = given()
              .header("accept","application/json")
              .header("Content-Type","application/json")
              .body("{\n" +
                      "  \"id\": 12,\n" +
                      "  \"petId\": 100,\n" +
                      "  \"quantity\": 452,\n" +
                      "  \"shipDate\": \"2024-08-12T09:26:01.144Z\",\n" +
                      "  \"status\": \"placed\",\n" +
                      "  \"complete\": true\n" +
                      "}")
              .when()
              .post("https://petstore.swagger.io/v2/store/order");
        response.prettyPrint();
        response.then().statusCode(200);
    }
    @Test
    public void get_store_inventory()
    {
        Response response = given()
                .header("accept","application/json")
                .when()
                .get("https://petstore.swagger.io/v2/store/inventory");
        response.prettyPrint();
        response.then().statusCode(200);
    }

    @Test(priority = 1)
    public void get_store_OrderId()
    {
        Response response = given()
                .header("accept","application/json")
                .when()
                .get("https://petstore.swagger.io/v2/store/order/3");
        response.prettyPrint();
        response.then().statusCode(200);
    }

    @Test (priority = 2)
    public void delete_store_OrderId()
    {
        Response response = given()
                .header("accept","application/json")
                .when()
                .delete("https://petstore.swagger.io/v2/store/order/3");
        response.prettyPrint();
        response.then().statusCode(200);
        Assert.assertEquals(response.statusCode(),200); //404 order not found
    }
    //PET
    @Test
    public void post_add_new_pet()
    {
        Response response = given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .body("{\n" +
                        "  \"id\": 1,\n" +
                        "  \"category\": {\n" +
                        "    \"id\": 2,\n" +
                        "    \"name\": \"germanshep\"\n" +
                        "  },\n" +
                        "  \"name\": \"german\",\n" +
                        "  \"photoUrls\": [\n" +
                        "    \"string\"\n" +
                        "  ],\n" +
                        "  \"tags\": [\n" +
                        "    {\n" +
                        "      \"id\": 3,\n" +
                        "      \"name\": \"Snippy\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"status\": \"available\"\n" +
                        "}")
                .when()
                .post("https://petstore.swagger.io/v2/pet");
        response.prettyPrint();
        response.then().statusCode(200);
    }
    @Test
    public void put_update_existing_pet()
    {
        Response response = given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .body("{\n" +
                        "  \"id\": 1,\n" +
                        "  \"category\": {\n" +
                        "    \"id\": 0,\n" +
                        "    \"name\": \"snipper\"\n" +
                        "  },\n" +
                        "  \"name\": \"dogy\",\n" +
                        "  \"photoUrls\": [\n" +
                        "    \"string\"\n" +
                        "  ],\n" +
                        "  \"tags\": [\n" +
                        "    {\n" +
                        "      \"id\": 0,\n" +
                        "      \"name\": \"string\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"status\": \"available\"\n" +
                        "}")
                .when()
                .put("https://petstore.swagger.io/v2/pet");
        response.prettyPrint();
        response.then().statusCode(200);
    }
    @Test
    public void get_finds_pets_by_status()
    {
        Response response = given()
                .header("accept","application/json")
                .when()
                .get("https://petstore.swagger.io/v2/pet/findByStatus?status=available");
        response.prettyPrint();
        response.then().statusCode(200);
    }
    @Test
    public void get_petbyId()
    {
        Response response = given()
                .header("accept","application/json")
                .when()
                .get("https://petstore.swagger.io/v2/pet/1");
        response.prettyPrint();
        response.then().statusCode(200);
    }
    @Test
    //update the pet in the store with form data
    public void post_pet()
    {
        Response response = given()
                .header("accept","application/json")
                .header("Content-Type"," application/x-www-form-urlencoded")
                .body("name=Sunny&status=unavailable")
                .when()
                .post("https://petstore.swagger.io/v2/pet/2");
        response.prettyPrint();
        response.then().statusCode(200);
    }
    @Test
    public void delete_pet()
    {
        Response response = given()
                .header("accept","application/json")
                .when()
                .delete("https://petstore.swagger.io/v2/pet/26");
        response.prettyPrint();
        response.then().statusCode(200);
        Assert.assertEquals(response.statusCode(),200); //404 :- pet
    }
}
