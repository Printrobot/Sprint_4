package src.model;

import org.openqa.selenium.WebDriver;

public abstract class BaseWebDriver {
    protected final WebDriver driver;
    public BaseWebDriver(WebDriver driver) {
        this.driver = driver;
    }
}
