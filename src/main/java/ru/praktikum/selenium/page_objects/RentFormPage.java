package ru.praktikum.selenium.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RentFormPage {
    private final By dateRent = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private final By arrowTimeRent = By.className("Dropdown-control");
    private final By listTimeRent =  By.xpath(".//*[(@role ='option' and text()='трое суток')]");
    private final By colorBlack = By.xpath(".//input[@id='black']");
    private final By comment =  By.xpath(".//input[@placeholder='Комментарий для курьера']");
    private final By order = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    private final By yes =  By.xpath(".//button[(@class ='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да')]");
    private final By modalWindow = By.className("Order_ModalHeader__3FDaJ");

    private final By orderWindow = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Посмотреть статус']");
    private final WebDriver driver;

    public RentFormPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillDateRent(String startDate) {
        driver.findElement(dateRent).sendKeys(startDate);
        driver.findElement(dateRent).sendKeys(Keys.ENTER);
    }
    public void fillTimeRent() {
        driver.findElement(arrowTimeRent).click();
        driver.findElement(listTimeRent).click();
    }
    public void clickBlack() {
        driver.findElement(colorBlack).click();
    }
    public void writeComment(String ourComment) {
        driver.findElement(comment).sendKeys(ourComment);
    }
    public void clickOrderButton() {
        Assert.assertTrue("Кнопка Заказать неактивна", driver.findElement(order).isEnabled());
        driver.findElement(order).click();
    }
    public void clickYESButton() {
        driver.findElement(yes).click();
    }

    public void waitModalWindow() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(modalWindow));
    }
    public boolean checkOrderWindow() {
        return driver.findElement(orderWindow).isEnabled();
    }
    public void rent(String startDate, String comment) {
        fillDateRent(startDate);
        fillTimeRent();
        clickBlack();
        writeComment(comment);
        clickOrderButton();
        waitModalWindow();
        clickYESButton();
    }

}
