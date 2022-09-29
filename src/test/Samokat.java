package src.test;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;

//Этот класс черновик для отладки тестов - можно не смотреть

public class Samokat {
    private WebDriver driver;

//    Выпадающий список в разделе «Вопросы о важном».
//    Тебе нужно проверить: когда нажимаешь на стрелочку, открывается соответствующий текст.
//    Важно написать отдельный тест на каждый вопрос.
    @Test
    public void test() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://qa-scooter.praktikum-services.ru/");

        WebElement element = driver.findElement(By.id("accordion__heading-3"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(By.id("accordion__heading-3")).click();
        String actual3 = driver.findElement(By.id("accordion__panel-3")).getText();
        System.out.println(actual3);
        String expected3 = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";

        //      Assert.assertArrayEquals("Message", actual3, text3);
        assertEquals("Message", expected3, actual3);
//        Проверить, что текст тот
    }

//        Заказ самоката. Весь флоу позитивного сценария.
//        Обрати внимание, что есть две точки входа в сценарий: кнопка «Заказать» вверху страницы и внизу.
        @Test
        public void orderButtonOnTop_Positive() {
            driver = new ChromeDriver();
            driver.get("https://qa-scooter.praktikum-services.ru/");

//        Кнопка заказать вверху:
            driver.findElement(By.className("Button_Button__ra12g")).click();
// Поля ввода форма Для кого самокат:
// Имя:
            driver.findElement(By.xpath("//input[@placeholder='* Имя']")).sendKeys("Кирилл");
// Фамилия:
            driver.findElement(By.xpath("//input[@placeholder='* Фамилия']")).sendKeys("Генин");
// Адрес:
            driver.findElement(By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']")).sendKeys("Москва");
// Метро
        WebElement clickable = driver.findElement(By.xpath("//input[@placeholder= '* Станция метро']"));
            clickable.sendKeys("Лубянка");
            clickable.click();
            clickable.sendKeys(Keys.DOWN);
            clickable.sendKeys(Keys.ENTER);

        driver.findElement(By.xpath("//input[@placeholder= '* Телефон: на него позвонит курьер']")).sendKeys("84957777777"); // Телефон
        driver.findElement(By.className("Button_Middle__1CSJM")).click();

// Поля ввода формы Про аренду:

//Когда привезти самокат:
        driver.findElement(By.xpath("//input[@placeholder= '* Когда привезти самокат']")).click();
//            WebElement ddd = driver.findElement(By.xpath("//input[@placeholder= '* Когда привезти самокат']"));
//            ddd.sendKeys("30.10.2022"); // Дата
//            ddd.click();
//  Календарь:
        driver.findElement(By.xpath("//div[@class='react-datepicker__day react-datepicker__day--016']")).click();
//driver.findElement(By.xpath("//div[@class='react-datepicker__day react-datepicker__day--016']")).sendKeys("30.10.2022");

//  Срок аренды:
        driver.findElement(By.xpath("//div[@class='Dropdown-placeholder']")).click();
//  Выбор из списка срока аренды:
        driver.findElement(By.xpath("//div[text()='двое суток']")).click();

//  Цвет самоката:
//            driver.findElement(By.id("black")); // черный жемчуг
            driver.findElement(By.id("grey")).click(); // серая безысходность
// Комментарии:
            driver.findElement(By.xpath("//input[@placeholder='Комментарий для курьера']")).sendKeys("Comments here");
// Кнопка заказать:
            driver.findElement(By.xpath("//*[@class='Button_Button__ra12g Button_Middle__1CSJM']")).click();


//  WebElement period = driver.findElement(By.xpath(".//div[@class='Order_Form__17u6u']//div[@class='Dropdown-control']//span[@class='Dropdown-arrow']"));
//           period.click();
//            xpath("//input[@placeholder='* Когда привезти самокат']")
//            driver.findElement(By.cssSelector(".Dropdown-placeholder.is-selected"));
//            period.sendKeys("двое суток");
//            period.sendKeys(Keys.DOWN);
////            period.click();
//            period.sendKeys(Keys.ENTER);

//        driver.findElement(By.className("Dropdown-control")).sendKeys("двое суток"); // Срок
//        driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[3]/label[2]/input")).sendKeys("Москва"); // Адрес
// Комментарии:
//            driver.findElement(By.xpath(" /html/body/div/div/div[2]/div[2]/div[4]/input")).sendKeys("Comments here");

//        driver.findElement(By.className("Button_Button__ra12g Button_Middle__1CSJM")).click();
        }


    @After
    public void tearDown() {
//        driver.quit();
    }
}