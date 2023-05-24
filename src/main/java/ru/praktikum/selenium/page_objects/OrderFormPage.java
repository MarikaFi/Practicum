package ru.praktikum.selenium.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderFormPage {
    private final By firstName = By.xpath(".//input[@placeholder='* Имя']");
    private final By lastName =  By.xpath(".//input[@placeholder='* Фамилия']");
    private final By address = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By metroStation =  By.xpath(".//input[@placeholder='* Станция метро']");
    private final By listMetroStation =  By.xpath(".//*[@class='Order_SelectOption__82bhS select-search__option' and @value='10']");
    private final By phone =  By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By next = By.xpath(".//button[(@class ='Button_Button__ra12g Button_Middle__1CSJM' and text()='Далее')]");
    private final WebDriver driver;

    public OrderFormPage(WebDriver driver) {
        this.driver = driver;
    }
    public void fillFirstName(String firstNameCustomer) {
        driver.findElement(firstName).sendKeys(firstNameCustomer);
    }
    public void fillLastName(String lastNameCustomer) {
        driver.findElement(lastName).sendKeys(lastNameCustomer);
    }
    public void fillAddress(String addressCustomer) {
        driver.findElement(address).sendKeys(addressCustomer);
    }
    public void fillListMetroStation() {
        driver.findElement(metroStation).click();
        driver.findElement(listMetroStation).click();

    }
    public void fillPhone(String phoneCustomer) {
        driver.findElement(phone).sendKeys(phoneCustomer);
    }
    public void clickNextButton() {
        driver.findElement(next).click();
    }
    public void order(String firstNameCustomer, String lastNameCustomer, String addressCustomer, String phoneCustomer) {
        fillFirstName(firstNameCustomer);
        fillLastName(lastNameCustomer);
        fillAddress(addressCustomer);
        fillListMetroStation();
        fillPhone(phoneCustomer);
        clickNextButton();
    }
}
