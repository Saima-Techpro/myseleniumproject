package com.myfirstproject;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

public class Day04_JavaFaker {
    /*
    java faker can be used to get fake test data
    -Where do you get your test data?
        -BA(writes the acceptance criteria)
        -Test Lead
        -Manual Tester
        -Developer
        -Team Lead
        -Database call
        -API calls
        -java faker > randomly generates data
        (Use it if allowed in the company)
     */

    @Test
    public void fakerTest(){

        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        System.out.println("firstName = " + firstName);

        String lastName = faker.name().lastName();
        System.out.println("lastName = " + lastName);

        //        title
        System.out.println(faker.name().title());
//        city
        System.out.println(faker.address().city());
//        state
        System.out.println(faker.address().state());
//        full address
        System.out.println(faker.address().fullAddress());
//        zip code
        System.out.println(faker.address().zipCode());
//        phone number
        System.out.println(faker.phoneNumber().cellPhone());
//        email
        System.out.println(faker.internet().emailAddress());
//        random digit number
        System.out.println(faker.number().digits(10));
//        random number in between
        System.out.println(faker.number().numberBetween(100000,200000));


    }
}
