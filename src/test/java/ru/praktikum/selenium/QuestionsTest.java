package ru.praktikum.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.praktikum.selenium.page_objects.MainPage;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

import static ru.praktikum.selenium.config.AppConfig.APP_URL;


@RunWith(Parameterized.class)
public class QuestionsTest {

    WebDriver webDriver;
    private final String queastionPanel;
    private final String answerPanel;
    private final String answerText;


    public QuestionsTest(String queastionPanel, String answerPanel, String answerText) {
        this.queastionPanel = queastionPanel;
        this.answerPanel = answerPanel;
        this.answerText = answerText;
    }

    @Parameterized.Parameters
    public static Object[][] getAnswersList() {
        return new Object[][]{
                {MainPage.questionListButtons[0], MainPage.textQuestionsList[0], "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {MainPage.questionListButtons[1], MainPage.textQuestionsList[1], "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {MainPage.questionListButtons[2], MainPage.textQuestionsList[2], "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {MainPage.questionListButtons[3], MainPage.textQuestionsList[3], "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {MainPage.questionListButtons[4], MainPage.textQuestionsList[4], "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {MainPage.questionListButtons[5], MainPage.textQuestionsList[5], "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {MainPage.questionListButtons[6], MainPage.textQuestionsList[6], "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {MainPage.questionListButtons[7], MainPage.textQuestionsList[7], "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }


    @Test
    public void testEqualsTextQuestions() {

        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        webDriver.get(APP_URL);
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        MainPage mainPage = new MainPage(webDriver);
        mainPage.scrollMainPage();
        mainPage.clickQuestionButton(queastionPanel);

        String actualAnswerText = webDriver.findElement(By.id(answerPanel)).getText();
        Assert.assertEquals("Выявлено различие в текстах", answerText, actualAnswerText);

    }

    @After
    public void clean() {
        webDriver.quit();
    }
}

