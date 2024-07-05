package com.atul.testcases.Crud;

import com.atul.base.BaseTest;
import com.atul.endpoints.APIConstants;
import com.atul.pojo.Bookingresponse;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

public class TestcreateBookingpost  extends BaseTest {


    @Test(groups = "smoke")
    @Owner("Promode")
    @Severity(SeverityLevel.NORMAL)
    @Description("TC#1 - Verify that the Booking can be Created")
    public void testCreateBooking() {

        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
        response = RestAssured
                .given(requestSpecification)
                .when().body(payloadManager.createPayloadBookingASString()).post();

        validatableResponse = response.then().log().all();
        // validatable assertion
        validatableResponse.statusCode(200);
       // validatableResponse.body("booking.firstname", Matchers.equalTo("atul"));

        //deserialize it
        Bookingresponse bookingresponse = payloadManager.bookingResponseJava(response.asString());

        // AssertJ
        // assertThat(bookingresponse.getBookingId()).isNotNull();
        assertThat(bookingresponse.getBooking().getFirstname()).isNotNull().isNotBlank();
        assertThat(bookingresponse.getBooking().getFirstname()).isEqualTo("atul");

        // Testng assertion


        assertActions.verifyStatusCode(response,200);


    }
    @Test(groups = "smoke")
    @Owner("Promode")
    @Severity(SeverityLevel.NORMAL)
    @Description("TC#1 - Verify that the Booking can be Created")
    public void testCreateBookingnegative() {

        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
        response = RestAssured
                .given(requestSpecification)
                .when().body(payloadManager.createInvalidPayloadBookingASString()).post();

        validatableResponse = response.then().log().all();




        assertActions.verifyStatusCode(response,500);


    }
}