package com.atul.utils;

import com.github.javafaker.Faker;

public class Fakerutils {
     Faker faker= new Faker();
    public String getfirstname(){

        return faker.name().firstName();

    }

    public String getlastname(){
        faker = new Faker();
        return faker.name().lastName();

    }
}
