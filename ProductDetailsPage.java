package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProductDetailsPage extends BasePage {
    
    @FindBy(how = How.CSS, using = ".product-name")
    private WebElement productName;
    
    @FindBy(how = How.CSS, using = ".product-price")
    private WebElement productPrice;
    
    @FindBy(how = How.ID, using = "add-to-cart-button")
    private WebElement addToCartButton;
    
    @FindBy(how = How.ID, using = "add-to-wishlist-button")
    private WebElement addToWishlistButton;
    
    @FindBy(how = How.ID, using = "product_enteredQuantity")
    private WebElement quantityField;
    
    @FindBy(how = How.CSS, using = ".content")
    private WebElement notificationBar;
    
    @FindBy(how = How.CSS, using = ".close")
    private WebElement notificationCloseButton;
    
    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }
    
    public String getProductName() {
        return getText(productName);
    }
    
    public String getProductPrice() {
        return getText(productPrice);
    }
    
    public void addToCart() {
        click(addToCartButton);
    }
    
    public void addToWishlist() {
        click(addToWishlistButton);
    }
    
    public void setQuantity(int quantity) {
        quantityField.clear();
        sendKeys(quantityField, String.valueOf(quantity));
    }
    
    public String getNotificationMessage() {
        return getText(notificationBar);
    }
    
    public void closeNotification() {
        click(notificationCloseButton);
    }
}