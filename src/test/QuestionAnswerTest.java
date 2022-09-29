package src.test;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
//    Выпадающий список в разделе «Вопросы о важном».
//    Тебе нужно проверить: когда нажимаешь на стрелочку, открывается соответствующий текст.
//    Важно написать отдельный тест на каждый вопрос.

public class QuestionAnswerTest {
// Локаторы вопросы на странице:
    private final static By QUESTION1 = By.id("accordion__heading-0");
    private final static By QUESTION2 = By.id("accordion__heading-1");
    private final static By QUESTION3 = By.id("accordion__heading-2");
    private final static By QUESTION4 = By.id("accordion__heading-3");
    private final static By QUESTION5 = By.id("accordion__heading-4");
    private final static By QUESTION6 = By.id("accordion__heading-5");
    private final static By QUESTION7 = By.id("accordion__heading-6");
    private final static By QUESTION8 = By.id("accordion__heading-7");
// Локаторы ответы на странице:
    private final static By ANSWER1 = By.id("accordion__panel-0");
    private final static By ANSWER2 = By.id("accordion__panel-1");
    private final static By ANSWER3 = By.id("accordion__panel-2");
    private final static By ANSWER4 = By.id("accordion__panel-3");
    private final static By ANSWER5 = By.id("accordion__panel-4");
    private final static By ANSWER6 = By.id("accordion__panel-5");
    private final static By ANSWER7 = By.id("accordion__panel-6");
    private final static By ANSWER8 = By.id("accordion__panel-7");
    private WebDriver driver;


    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

// Методы для работы с вопрос-ответ:
// скролинг до элемента, получить текст, проверить
    @Test
    public void checkQuestion1() {

        WebElement element = driver.findElement(QUESTION1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    driver.findElement(QUESTION1).click();
    String actual1 = driver.findElement(ANSWER1).getText();
    String expected1 = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    assertEquals("Ошибка" , expected1, actual1);
}
}
