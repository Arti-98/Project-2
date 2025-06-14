package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends BasePage {
    
    @FindBy(how = How.ID, using = "BillingNewAddress_CountryId")
    private WebElement countryDropdown;
    
    @FindBy(how = How.ID, using = "BillingNewAddress_City")
    private WebElement cityField;
    
    @FindBy(how = How.ID, using = "BillingNewAddress_Address1")
    private WebElement address1Field;
    
    @FindBy(how = How.ID, using = "BillingNewAddress_ZipPostalCode")
    private WebElement zipCodeField;
    
    @FindBy(how = How.ID, using = "BillingNewAddress_PhoneNumber")
    private WebElement phoneNumberField;
    
    @FindBy(how = How.CSS, using = "input[onclick='Billing.save()']")
    private WebElement billingContinueButton;
    
    @FindBy(how = How.CSS, using = "input[onclick='ShippingMethod.save()']")
    private WebElement shippingMethodContinueButton;
    
    @FindBy(how = How.CSS, using = "input[onclick='PaymentMethod.save()']")
    private WebElement paymentMethodContinueButton;
    
    @FindBy(how = How.CSS, using = "input[onclick='PaymentInfo.save()']")
    private WebElement paymentInfoContinueButton;
    
    @FindBy(how = How.CSS, using = "input[onclick='ConfirmOrder.save()']")
    private WebElement confirmOrderButton;
    
    @FindBy(how = How.CSS, using = ".title")
    private WebElement orderConfirmationTitle;
    
    @FindBy(how = How.CSS, using = ".order-number")
    private WebElement orderNumber;
    
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }
    
    public void selectCountry(String country) {
        Select dropdown = new Select(countryDropdown);
        dropdown.selectByVisibleText(country);
    }
    
    public void enterCity(String city) {
        sendKeys(cityField, city);
    }
    
    public void enterAddress(String address) {
        sendKeys(address1Field, address);
    }
    
    public void enterZipCode(String zipCode) {
        sendKeys(zipCodeField, zipCode);
    }
    
    public void enterPhoneNumber(String phoneNumber) {
        sendKeys(phoneNumberField, phoneNumber);
    }
    
    public void clickBillingContinue() {
        click(billingContinueButton);
    }
    
    public void clickShippingMethodContinue() {
        click(shippingMethodContinueButton);
    }
    
    public void clickPaymentMethodContinue() {
        click(paymentMethodContinueButton);
    }
    
    public void clickPaymentInfoContinue() {
        click(paymentInfoContinueButton);
    }
    
    public void clickConfirmOrder() {
        click(confirmOrderButton);
    }
    
    public String getOrderConfirmationTitle() {
        return getText(orderConfirmationTitle);
    }
    
    public String getOrderNumber() {
        return getText(orderNumber).replace("ORDER NUMBER: ", "");
    }
}