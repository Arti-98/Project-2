package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import java.util.List;

public class ProductListingPage extends BasePage {
    
    @FindBy(how = How.CSS, using = ".product-title a")
    private List<WebElement> productTitles;
    
    @FindBy(how = How.CSS, using = ".product-box-add-to-cart-button")
    private List<WebElement> addToCartButtons;
    
    @FindBy(how = How.CSS, using = ".price.actual-price")
    private List<WebElement> productPrices;
    
    @FindBy(how = How.CLASS_NAME, using = "page-title")
    private WebElement pageTitle;
    
    public ProductListingPage(WebDriver driver) {
        super(driver);
    }
    
    public void clickProductByName(String productName) {
        for (WebElement productTitle : productTitles) {
            if (getText(productTitle).equalsIgnoreCase(productName)) {
                click(productTitle);
                break;
            }
        }
    }
    
    public void addProductToCartByName(String productName) {
        for (int i = 0; i < productTitles.size(); i++) {
            if (getText(productTitles.get(i)).equalsIgnoreCase(productName)) {
                click(addToCartButtons.get(i));
                break;
            }
        }
    }
    
    public String getProductPriceByName(String productName) {
        for (int i = 0; i < productTitles.size(); i++) {
            if (getText(productTitles.get(i)).equalsIgnoreCase(productName)) {
                return getText(productPrices.get(i));
            }
        }
        return "";
    }
    
    public String getPageTitle() {
        return getText(pageTitle);
    }
    
    public int getProductCount() {
        return productTitles.size();
    }
}