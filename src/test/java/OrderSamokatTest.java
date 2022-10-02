    package src.test.java;

    import org.junit.After;
    import org.junit.Assert;
    import org.junit.Before;
    import org.junit.Test;
    import org.junit.runner.RunWith;
    import org.junit.runners.Parameterized;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.chrome.ChromeDriver;
    import src.main.java.OrderSamokatPage;
    import java.util.concurrent.TimeUnit;

    @RunWith(Parameterized.class)
    public class OrderSamokatTest {
        private final String firstname;
        private final String secondname;
        private final String address;
        private final String metro;
        private final String phone;
        private final String comments;

        public OrderSamokatTest(String firstname, String secondname, String address, String metro, String phone, String comments) {
            // будем тестить с этими параметрами:
            this.firstname = firstname;
            this.secondname = secondname;
            this.address = address;
            this.metro = metro;
            this.phone = phone;
            this.comments = comments;
        }

        private WebDriver driver;

        @Before
        public void setUp() {
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.get("https://qa-scooter.praktikum-services.ru");
        }

        @Parameterized.Parameters
        public static Object[][] getTestData() {
            return new Object[][]{
                    {"Кирилл", "Генин", "Москва", "Лубянка", "84951234567", "Доставить к подъзду"},
                    {"Сергей", "Иванов", "Москва", "Сокольники", "+79161234567", "Позвонить за час"},
            };
        }

        @Test
        public void orderButton_Positive() {
            OrderSamokatPage order = new OrderSamokatPage(driver, firstname, secondname, address, metro, phone, comments);
            order.clickButtonTop();
            order.setFirstName(firstname);
            order.setSecondName(secondname);
            order.setAddress(address);
            order.setMetro(metro);
            order.setPhone(phone);
            order.clickButtonNext();
            order.setDelivery();
            order.setPeriod();
            order.setColor();
            order.setComments(comments);
            order.clickButtonOrder();
            Assert.assertTrue("Ошибка оформления заказа", order.isDisplay());
        }

        @After
        public void tearDown() {
            driver.quit();
        }

    }
