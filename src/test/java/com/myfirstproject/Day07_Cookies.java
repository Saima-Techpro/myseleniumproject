package com.myfirstproject;

import com.myfirstproject.utilitles.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

import java.util.Set;

public class Day07_Cookies extends TestBase {
    @Test
    public void cookiesTest() throws InterruptedException {
//        Go to amazon
        driver.get("https://www.amazon.com");
        Thread.sleep(1000);
        driver.navigate().refresh(); // to get rid of captcha

//        1. Find the total number of cookies
        Set<Cookie> cookieList = driver.manage().getCookies(); // import the right cookie .. from Selenium -> org.openqa.selenium.Cookie;

        System.out.println("Cookie size : "+cookieList.size());
        System.out.println("===============================");
//        2. Print all the cookies
        for (Cookie eachCookie:cookieList){
            System.out.println("Each Cookie : "+eachCookie);
            System.out.println("Cookie Name : "+eachCookie.getName());
            System.out.println("Cookie Value : "+eachCookie.getValue());
        }

        System.out.println("===============================");
//        3. Get the cookies by their name
        System.out.println("Cookies By Name => "+driver.manage().getCookieNamed("i18n-prefs"));
        System.out.println("===============================");
//        4. Add new cookie
        Cookie myFavCookie = new Cookie("my-cookies","login-cookie");
        driver.manage().addCookie(myFavCookie);
        Thread.sleep(3000);   // need to give time to browser to add your cookie
        for (Cookie each : driver.manage().getCookies()){
            System.out.println(each);//printing all cookies to see if the new cookie is added
        }

        System.out.println("===============================");
//        5. Delete all  cookies
        driver.manage().deleteAllCookies();
        Thread.sleep(3000);
        System.out.println("After deleting all cookies, there are "+driver.manage().getCookies().size()+" cookies");
    }
}
