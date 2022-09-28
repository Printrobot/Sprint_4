package src.test;

import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


import static org.junit.Assert.assertEquals;

public class Samokat {
    private WebDriver driver;

//    Выпадающий список в разделе «Вопросы о важном».
//    Тебе нужно проверить: когда нажимаешь на стрелочку, открывается соответствующий текст.
//    Важно написать отдельный тест на каждый вопрос.
    @Test
    public void test() {
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        WebElement element = driver.findElement(By.id("accordion__heading-3"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(By.id("accordion__heading-3")).click();
        String actual3 = driver.findElement(By.id("accordion__panel-3")).getText();
        System.out.println(actual3);
        String expected3 = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";

        //      Assert.assertArrayEquals("Message", actual3, text3);
        assertEquals(expected3, actual3);
//        Проверить, что текст тот
    }

//        Заказ самоката. Весь флоу позитивного сценария.
//        Обрати внимание, что есть две точки входа в сценарий: кнопка «Заказать» вверху страницы и внизу.
        @Test
        public void orderButtonOnTopPositive() {
            driver = new ChromeDriver();
            driver.get("https://qa-scooter.praktikum-services.ru/");

//        Кнопка заказать вверху:
            driver.findElement(By.className("Button_Button__ra12g")).click();
// Поля ввода форма Для кого самокат:
// Имя:
            driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/input")).sendKeys("Кирилл");
// Фамилия:
            driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/input")).sendKeys("Генин");
// Адрес:
            driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[3]/input")).sendKeys("Москва");
// Метро
        WebElement clickable = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[4]/div/div/input"));
            clickable.sendKeys("Лубянка");
            clickable.click();
            clickable.sendKeys(Keys.DOWN);
            clickable.sendKeys(Keys.ENTER);

        driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[5]/input")).sendKeys("84957777777"); // Телефон
        driver.findElement(By.className("Button_Middle__1CSJM")).click();

// Поля ввода форма Про аренду: подождать
//        driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/div[1]/div/input"));
//                .sendKeys("30.10.2022"); // Дата
//  Срок:
//            WebElement period = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div[2]/div[1]"));
//           period.click();
//            xpath("//input[@placeholder='* Когда привезти самокат']")
//            driver.findElement(By.cssSelector(".Dropdown-placeholder.is-selected"));
////            period.sendKeys("двое суток");
//            period.sendKeys(Keys.DOWN);
////            period.click();
//            period.sendKeys(Keys.ENTER);

//        driver.findElement(By.className("Dropdown-control")).sendKeys("двое суток"); // Срок
//        driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[3]/label[2]/input")).sendKeys("Москва"); // Адрес
// Комментарии:
            driver.findElement(By.xpath(" /html/body/div/div/div[2]/div[2]/div[4]/input")).sendKeys("Comments here");

//        driver.findElement(By.className("Button_Button__ra12g Button_Middle__1CSJM")).click();
        }


    @After
    public void tearDown() {
        driver.quit();
    }
}