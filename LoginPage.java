package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    
    By emailField = By.id("Email");
    By passwordField = By.id("Password");
    By loginButton = By.cssSelector("input[value='Log in']");
    
    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }
    
    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }
    
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }
    
    public boolean isLoginPageDisplayed() {
        return driver.getTitle().contains("Login");
    }
}