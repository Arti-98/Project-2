package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends BasePage {
    
    @FindBy(how = How.LINK_TEXT, using = "Register")
    private WebElement registerLink;
    
    @FindBy(how = How.LINK_TEXT, using = "Log in")
    private WebElement loginLink;
    
    @FindBy(how = How.LINK_TEXT, using = "Shopping cart")
    private WebElement shoppingCartLink;
    
    @FindBy(how = How.LINK_TEXT, using = "Wishlist")
    private WebElement wishlistLink;
    
    @FindBy(how = How.LINK_TEXT, using = "Books")
    private WebElement booksCategoryLink;
    
    @FindBy(how = How.LINK_TEXT, using = "Computers")
    private WebElement computersCategoryLink;
    
    @FindBy(how = How.LINK_TEXT, using = "Electronics")
    private WebElement electronicsCategoryLink;
    
    @FindBy(how = How.LINK_TEXT, using = "Apparel & Shoes")
    private WebElement apparelShoesCategoryLink;
    
    @FindBy(how = How.CLASS_NAME, using = "account")
    private WebElement accountEmailLink;
    
    @FindBy(how = How.LINK_TEXT, using = "Log out")
    private WebElement logoutLink;
    
    @FindBy(how = How.ID, using = "small-searchterms")
    private WebElement searchBox;
    
    @FindBy(how = How.CSS, using = "input[value='Search']")
    private WebElement searchButton;
    
    public HomePage(WebDriver driver) {
        super(driver);
    }
    
    public void navigateToRegisterPage() {
        click(registerLink);
    }
    
    public void navigateToLoginPage() {
        click(loginLink);
    }
    
    public void navigateToShoppingCart() {
        click(shoppingCartLink);
    }
    
    public void navigateToWishlist() {
        click(wishlistLink);
    }
    
    public void navigateToBooksCategory() {
        click(booksCategoryLink);
    }
    
    public void navigateToComputersCategory() {
        click(computersCategoryLink);
    }
    
    public void navigateToElectronicsCategory() {
        click(electronicsCategoryLink);
    }
    
    public void navigateToApparelShoesCategory() {
        click(apparelShoesCategoryLink);
    }
    
    public boolean isUserLoggedIn(String email) {
        return getText(accountEmailLink).equals(email);
    }
    
    public void logout() {
        click(logoutLink);
    }
    
    public void searchForProduct(String productName) {
        sendKeys(searchBox, productName);
        click(searchButton);
    }
    
    public boolean isLogoutLinkDisplayed() {
        return isElementDisplayed(logoutLink);
    }

}