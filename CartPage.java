package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import java.util.List;

public class CartPage extends BasePage {
    
    @FindBy(how = How.CSS, using = ".cart-item-row")
    private List<WebElement> cartItems;
    
    @FindBy(how = How.NAME, using = "removefromcart")
    private List<WebElement> removeCheckboxes;
    
    @FindBy(how = How.NAME, using = "updatecart")
    private WebElement updateCartButton;
    
    @FindBy(how = How.CSS, using = ".order-summary-content")
    private WebElement emptyCartMessage;
    
    @FindBy(how = How.CSS, using = ".qty-input")
    private List<WebElement> quantityFields;
    
    @FindBy(how = How.CSS, using = ".product-unit-price")
    private List<WebElement> itemPrices;
    
    @FindBy(how = How.CSS, using = ".product-subtotal")
    private List<WebElement> itemSubtotals;
    
    @FindBy(how = How.ID, using = "termsofservice")
    private WebElement termsOfServiceCheckbox;
    
    @FindBy(how = How.ID, using = "checkout")
    private WebElement checkoutButton;
    
    public CartPage(WebDriver driver) {
        super(driver);
    }
    
    public int getCartItemCount() {
        return cartItems.size();
    }
    
    public void removeItem(int index) {
        click(removeCheckboxes.get(index));
        click(updateCartButton);
    }
    
    public String getEmptyCartMessage() {
        return getText(emptyCartMessage);
    }
    
    public void updateQuantity(int index, int quantity) {
        quantityFields.get(index).clear();
        sendKeys(quantityFields.get(index), String.valueOf(quantity));
        click(updateCartButton);
    }
    
    public String getItemPrice(int index) {
        return getText(itemPrices.get(index));
    }
    
    public String getItemSubtotal(int index) {
        return getText(itemSubtotals.get(index));
    }
    
    public void acceptTermsAndCheckout() {
        click(termsOfServiceCheckbox);
        click(checkoutButton);
    }
}