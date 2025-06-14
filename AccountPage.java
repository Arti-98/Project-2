package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AccountPage extends BasePage {
    
    @FindBy(how = How.ID, using = "gender-male")
    private WebElement maleGenderRadio;
    
    @FindBy(how = How.ID, using = "gender-female")
    private WebElement femaleGenderRadio;
    
    @FindBy(how = How.ID, using = "FirstName")
    private WebElement firstNameField;
    
    @FindBy(how = How.ID, using = "LastName")
    private WebElement lastNameField;
    
    @FindBy(how = How.ID, using = "Email")
    private WebElement emailField;
    
    @FindBy(how = How.ID, using = "Password")
    private WebElement passwordField;
    
    @FindBy(how = How.ID, using = "ConfirmPassword")
    private WebElement confirmPasswordField;
    
    @FindBy(how = How.ID, using = "register-button")
    private WebElement registerButton;
    
    @FindBy(how = How.CSS, using = ".result")
    private WebElement registrationResult;
    
    @FindBy(how = How.ID, using = "Email")
    private WebElement loginEmailField;
    
    @FindBy(how = How.ID, using = "Password")
    private WebElement loginPasswordField;
    
    @FindBy(how = How.CSS, using = "input[value='Log in']")
    private WebElement loginButton;
    
    @FindBy(how = How.CSS, using = ".validation-summary-errors")
    private WebElement loginError;
    
    public AccountPage(WebDriver driver) {
        super(driver);
    }
    
    public void selectGender(String gender) {
        if (gender.equalsIgnoreCase("male")) {
            click(maleGenderRadio);
        } else {
            click(femaleGenderRadio);
        }
    }
    
    public void enterFirstName(String firstName) {
        sendKeys(firstNameField, firstName);
    }
    
    public void enterLastName(String lastName) {
        sendKeys(lastNameField, lastName);
    }
    
    public void enterEmail(String email) {
        sendKeys(emailField, email);
    }
    
    public void enterPassword(String password) {
        sendKeys(passwordField, password);
    }
    
    public void enterConfirmPassword(String password) {
        sendKeys(confirmPasswordField, password);
    }
    
    public void clickRegisterButton() {
        click(registerButton);
    }
    
    public String getRegistrationResult() {
        return getText(registrationResult);
    }
    
    public void enterLoginEmail(String email) {
        sendKeys(loginEmailField, email);
    }
    
    public void enterLoginPassword(String password) {
        sendKeys(loginPasswordField, password);
    }
    
    public void clickLoginButton() {
        click(loginButton);
    }
    
    public String getLoginError() {
        return getText(loginError);
    }
}