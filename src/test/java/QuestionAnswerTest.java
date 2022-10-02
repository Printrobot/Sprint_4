    package src.test.java;

    import org.junit.After;
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
            String actual = driver.findElement(ANSWER1).getText();
            String expected = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
            assertEquals("Текст ответа неправильный", expected, actual);
        }

        @Test
        public void checkQuestion2() {
            WebElement element = driver.findElement(QUESTION2);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
            driver.findElement(QUESTION2).click();
            String actual = driver.findElement(ANSWER2).getText();
            String expected = "Пока что у нас так: один заказ — один самокат. " +
                    "Если хотите покататься с друзьями, " +
                    "можете просто сделать несколько заказов — один за другим.";
            assertEquals("Текст ответа неправильный", expected, actual);
        }

        @Test
        public void checkQuestion3() {
            WebElement element = driver.findElement(QUESTION3);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
            driver.findElement(QUESTION3).click();
            String actual = driver.findElement(ANSWER3).getText();
            String expected = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. " +
                    "Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. " +
                    "Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
            assertEquals("Текст ответа неправильный", expected, actual);
        }

        @Test
        public void checkQuestion4() {
            WebElement element = driver.findElement(QUESTION4);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
            driver.findElement(QUESTION4).click();
            String actual = driver.findElement(ANSWER4).getText();
            String expected = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
            assertEquals("Текст ответа неправильный", expected, actual);
        }

        @Test
        public void checkQuestion5() {
            WebElement element = driver.findElement(QUESTION5);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
            driver.findElement(QUESTION5).click();
            String actual = driver.findElement(ANSWER5).getText();
            String expected = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
            assertEquals("Текст ответа неправильный", expected, actual);
        }

        @Test
        public void checkQuestion6() {
            WebElement element = driver.findElement(QUESTION6);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
            driver.findElement(QUESTION6).click();
            String actual = driver.findElement(ANSWER6).getText();
            String expected = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — " +
                    "даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
            assertEquals("Текст ответа неправильный", expected, actual);
        }

        @Test
        public void checkQuestion7() {
            WebElement element = driver.findElement(QUESTION7);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
            driver.findElement(QUESTION7).click();
            String actual = driver.findElement(ANSWER7).getText();
            String expected = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
            assertEquals("Текст ответа неправильный", expected, actual);
        }

        @Test
        public void checkQuestion8() {
            WebElement element = driver.findElement(QUESTION8);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
            driver.findElement(QUESTION8).click();
            String actual = driver.findElement(ANSWER8).getText();
            String expected = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
            assertEquals("Текст ответа неправильный", expected, actual);
        }

        @After
        public void tearDown() {
            driver.quit();
        }
    }
