package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class MainPage {

    private final WebDriver driver;
    private final By upperOrderButton = By.className("Button_Button__ra12g");
    private final By lowerOrderButton = By.xpath(".//button[(@class ='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать')]");

    public static final String[] questionListButtons = new String[]{
            "accordion__heading-0",
            "accordion__heading-1",
            "accordion__heading-2",
            "accordion__heading-3",
            "accordion__heading-4",
            "accordion__heading-5",
            "accordion__heading-6",
            "accordion__heading-7"};

    public static final String[]  textQuestionsList = new String[]{
            "accordion__panel-0",
            "accordion__panel-1",
            "accordion__panel-2",
            "accordion__panel-3",
            "accordion__panel-4",
            "accordion__panel-5",
            "accordion__panel-6",
            "accordion__panel-7"};
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickUpperOrderButton() {
        driver.findElement(upperOrderButton).click();
    }
    public void clickLowerOrderButton() {
        driver.findElement(lowerOrderButton).click();
    }

    public void scrollMainPage() {
        WebElement element = driver.findElement(By.id(questionListButtons[7]));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void clickQuestionButton(String queastionPanel) {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(By.id(queastionPanel)));
        driver.findElement(By.id(queastionPanel)).click();
    }
}
