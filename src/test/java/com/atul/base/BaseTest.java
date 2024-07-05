package com.atul.base;
import com.atul.Actions.Assertactions;
import com.atul.endpoints.APIConstants;
import com.atul.modules.PayloadManager;
import com.atul.pojo.Bookingresponse;
import com.google.gson.Gson;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;
import com.google.gson.Gson;

public class BaseTest {

    // basetest (father)- testcase(son)  - single inheritance

    public RequestSpecification requestSpecification;
    public Assertactions assertActions;
    public PayloadManager payloadManager;
    public JsonPath jsonPath;
    public Response response;
    public ValidatableResponse validatableResponse;


    @BeforeTest

    public  void setConfig(){
        System.out.println("Before test");
        payloadManager = new PayloadManager();
        assertActions = new Assertactions();
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(APIConstants.BASE_URL)
                .addHeader("Content-Type","application/json")
                .build().log().all();


//        requestSpecification = RestAssured.
//                given()
//                .baseUri(APIConstants.BASE_URL)
//                .contentType(ContentType.JSON)
//                .log().all();

    }

    public String gettoken(){
        return null;
    }





}
