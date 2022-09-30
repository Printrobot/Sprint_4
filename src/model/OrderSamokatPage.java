package src.model;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import src.model.BaseWebDriver;

// описание локаторов и методов страницы Для кого самокат
 public class OrderSamokatPage extends BaseWebDriver {
  // будем тестить с этими параметрами:
 private final String firstname;
 private final String secondname;
 private final String address;
 private final String metro;
 private final String phone;
 private final String comments;
 //
 // Имя:
 private final static By INPUT_FIRST_NAME = By.xpath("//input[@placeholder='* Имя']");
 // Фамилия:
 private final static By INPUT_SECOND_NAME = By.xpath("//input[@placeholder='* Фамилия']");
 // Адрес куда привезти заказ:
 private final static By INPUT_ADDRESS = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
 // Станция метро. Поле со списком:
 private final static By SELECT_METRO = By.xpath("//input[@placeholder= '* Станция метро']");
 // Телефон: на него позвонит курьер:
 private final static By INPUT_PHONE = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
 // Кнопка далее
 private final static By BUTTON_NEXT = By.className("Button_Middle__1CSJM");
 // Поля ввода формы Про аренду:
 // Когда привезти самокат:
 private final static By INPUT_DELIVERY = By.xpath("//input[@placeholder= '* Когда привезти самокат']");
 // Календарь:
 private final static By PICK_CALENDAR = By.xpath("//div[@class='react-datepicker__day react-datepicker__day--016']");
 // Срок аренды:
 private final static By SELECT_PERIOD = By.xpath("//div[@class='Dropdown-placeholder']");
 // Выбор из списка срока аренды:
 private final static By INPUT_PERIOD = By.xpath("//div[text()='двое суток']"); // двое суток
 // Цвет самоката:
 private final static By CHECKBOX_COLOR = By.id("black"); // черный жемчуг
 // Комментарии:
 private final static By INPUT_COMMENTS = By.xpath("//input[@placeholder='Комментарий для курьера']");
 // Кнопка заказать:
 private final static By BUTTON_ORDER = By.xpath("//*[@class='Button_Button__ra12g Button_Middle__1CSJM']");
 // Хотите оформить заказ?
 private final static By HEADER_ORDER = By.className("Order_ModalHeader__3FDaJ");
 //локатор для кнопки Заказать наверху страницы
 private final static By BUTTON_ORDER_TOP = By.className("Button_Button__ra12g");
    //локатор для кнопки Заказать внизу страницы
    // protected final By buttonOrderOnTheDown = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");


    public OrderSamokatPage(WebDriver driver, String firstname, String secondname, String address, String metro, String phone, String comments) {
     super(driver);
  // будем тестить с этими параметрами:
     this.firstname = firstname;
     this.secondname = secondname;
     this.address = address;
     this.metro = metro;
     this.phone = phone;
     this.comments = comments;
    }
   public void clickButtonTop() {
        driver.findElement(BUTTON_ORDER_TOP).click();
   }
 // Имя:
   public void setFirstName(String firstname) {
       driver.findElement(INPUT_FIRST_NAME).sendKeys(firstname);
    }
// Фамилия:
   public void setSecondName(String secondname) {
       driver.findElement(INPUT_SECOND_NAME).sendKeys(secondname);
   }
// Адрес:
   public void setAddress(String address) {
       driver.findElement(INPUT_ADDRESS).sendKeys(address);
   }
// Метро
    public void setMetro(String metro) {
        WebElement clickable = driver.findElement(SELECT_METRO);
        clickable.sendKeys(metro);
        clickable.click();
        clickable.sendKeys(Keys.DOWN);
        clickable.sendKeys(Keys.ENTER);
    }
// Телефон:
    public void setPhone(String phone) {
       driver.findElement(INPUT_PHONE).sendKeys(phone);
    }
//  Кнопка далее:
    public void clickButtonNext() {
       driver.findElement(BUTTON_NEXT).click();
    }

//Когда привезти самокат:
    public void setDelivery() {
       driver.findElement(INPUT_DELIVERY).click();
       driver.findElement(PICK_CALENDAR).click(); //  Календарь
    }

//  Срок аренды:
    public void setPeriod() {
       driver.findElement(SELECT_PERIOD).click();
       driver.findElement(INPUT_PERIOD).click();
    }

//  Цвет самоката:
    public void setColor() {
       driver.findElement(CHECKBOX_COLOR).click();
    }
//            driver.findElement(By.id("black")); // черный жемчуг
//            driver.findElement(By.id("grey")).click(); // серая безысходность
// Комментарии:
    public void setComments(String comments) {
       driver.findElement(INPUT_COMMENTS).sendKeys(comments);
    }
// Кнопка заказать:
    public void clickButtonOrder() {
       driver.findElement(BUTTON_ORDER).click();
    }
    public boolean isDisplay() {
        return driver.findElement(HEADER_ORDER).isDisplayed();
    }
}
