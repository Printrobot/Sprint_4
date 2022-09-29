import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// описание локаторов и методов страницы Для кого самокат
 public class OrderSamokatPage extends BasePage {
  // будем тестить с этими параметрами:
 private final String firstname;
 private final String secondname;
 private final String address;
 private final String metro;
 private final String phone;
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
 private final static By INPUT_PERIOD = By.xpath("//div[text()='двое суток']");
 // Цвет самоката:
 private final static By CHECKBOX_COLOR = By.id("black"); // черный жемчуг
 // Комментарии:
 private final static By INPUT_COMMENTS = By.xpath("//input[@placeholder='Комментарий для курьера']");
 // Кнопка заказать:
 private final static By BUTTON_ORDER = By.xpath("//*[@class='Button_Button__ra12g Button_Middle__1CSJM']");

 public OrderSamokatPage(WebDriver driver, String firstname, String secondname, String address, String metro, String phone) {
  super(driver);
  this.firstname = firstname;
  this.secondname = secondname;
  this.address = address;
  this.metro = metro;
  this.phone = phone;
 }
 public void inputFirstName(String firstname) {
    driver.findElement(INPUT_FIRST_NAME).sendKeys(firstname);
 }
}
