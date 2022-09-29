// Описание локаторов и методов страницы Про аренду

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ArendaPage {

    private final static By BUTTON_ORDER_TOP = By.className("Button_Button__ra12g");
    private final WebDriver driver;

    public ArendaPage(WebDriver driver) {
        this.driver = driver;
    }
}
