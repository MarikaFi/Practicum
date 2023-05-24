package ru.praktikum.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.praktikum.selenium.page_objects.MainPage;
import ru.praktikum.selenium.page_objects.OrderFormPage;
import ru.praktikum.selenium.page_objects.RentFormPage;

import java.util.concurrent.TimeUnit;

import static ru.praktikum.selenium.config.AppConfig.APP_URL;


@RunWith(Parameterized.class)
    public class OrderTest{

        WebDriver webDriver;
        private final String firstName;
        private final String lastName;
        private final String address;
        private final String phone;
        private final String startDate;
        private final String comment;


        public OrderTest(String firstName, String lastName, String address, String phone,String startDate, String comment) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.address = address;
            this.phone = phone;
            this.startDate = startDate;
            this.comment = comment;
        }

        @Parameterized.Parameters
        public static Object[][] getCredentials() {
            return new Object[][]{
                    {"Иван", "Иванов", "Иваново", "+79000000000","22.05.2023","Очень жду самокат"},
                    {"Петр", "Петров", "Петрово", "+79000000000","23.05.2023","Сильно жду самокат"},
            };
        }


        @Test
        public void testOrderUpperOrderButton() {
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
            webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            webDriver.get(APP_URL);
            webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            MainPage mainPage = new MainPage(webDriver);
            mainPage.clickCookieButton();
            mainPage.clickUpperOrderButton();

            OrderFormPage orderPage = new OrderFormPage(webDriver);
            orderPage.order(firstName, lastName, address, phone);

            RentFormPage rentPage = new RentFormPage(webDriver);
            rentPage.rent(startDate, comment);

            Assert.assertTrue(rentPage.checkOrderWindow());
        }

        @Test
        public void testOrderLowerOrderButton() {
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
            webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            webDriver.get(APP_URL);
            webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            MainPage mainPage = new MainPage(webDriver);
            mainPage.clickCookieButton();
            mainPage.clickLowerOrderButton();

            OrderFormPage orderPage = new OrderFormPage(webDriver);
            orderPage.order(firstName, lastName, address, phone);

            RentFormPage rentPage = new RentFormPage(webDriver);
            rentPage.rent(startDate, comment);

            Assert.assertTrue(rentPage.checkOrderWindow());
        }

        @After
        public void clean() {
            webDriver.quit();
        }
    }

