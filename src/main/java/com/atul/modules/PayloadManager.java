package com.atul.modules;

import com.atul.pojo.Booking;
import com.atul.pojo.Bookingdates;
import com.atul.pojo.Bookingresponse;
import com.google.gson.Gson;

public class PayloadManager {

    Gson gson;

    public String createPayloadBookingASString() {

        Booking booking = new Booking();
        booking.setFirstname("atul");
        booking.setLastname("singh");
        booking.setTotalprice(1144);
        booking.setDepositpaid(true);

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2024-02-01");
        bookingdates.setCheckout("2024-02-05");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");
        gson = new Gson();
        String jsonPayload = gson.toJson(booking);
        return  jsonPayload;

    }

    public String createInvalidPayloadBookingASString() {


        return  "{}";

    }

    public String FullupdatepayloadReturnasString() {

        Booking booking = new Booking();
        booking.setFirstname("james");
        booking.setLastname("singh");
        booking.setTotalprice(1144);
        booking.setDepositpaid(true);

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2024-02-01");
        bookingdates.setCheckout("2024-02-05");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");
        return gson.toJson(booking);

    }


    public Bookingresponse bookingResponseJava(String responseString) {
        gson = new Gson();
        Bookingresponse bookingresponse = gson.fromJson(responseString, Bookingresponse.class);
        return bookingresponse;
    }

}