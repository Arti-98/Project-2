package StepDefination;

import Pages.*;
import Utilities.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import java.util.List;
import java.util.Map;

public class WebShopStepDef {
    private WebDriver driver;
    private HomePage homePage;
    private AccountPage accountPage;
    private ProductListingPage productListingPage;
    private ProductDetailsPage productDetailsPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;

    @Before
    public void setUp() {
        TestBase.initialization();
        driver = TestBase.driver;
        homePage = new HomePage(driver);
        accountPage = new AccountPage(driver);
    }

    @After
    public void tearDown() {
        TestBase.tearDown();
    }

    // Home Page Steps
    @Given("I am on the home page")
    public void i_am_on_the_home_page() {
        // Already initialized in setup
    }

    @Then("I should see the following links:")
    public void i_should_see_the_following_links(List<String> links) {
        for (String link : links) {
            Assert.assertTrue("Link " + link + " not found", 
                homePage.isLinkDisplayed(link));
        }
    }

    @When("I click on the {string} link")
    public void i_click_on_the_link(String linkText) {
        homePage.clickLinkByText(linkText);
    }

    @Then("I should be on the registration page")
    public void i_should_be_on_the_registration_page() {
        Assert.assertTrue(accountPage.isRegisterPageDisplayed());
    }

    @Then("I should be on the login page")
    public void i_should_be_on_the_login_page() {
        Assert.assertTrue(accountPage.isLoginPageDisplayed());
    }

    // Account Steps
    @Given("I am on the registration page")
    public void i_am_on_the_registration_page() {
        homePage.navigateToRegisterPage();
    }

    @When("I select {string} gender")
    public void i_select_gender(String gender) {
        accountPage.selectGender(gender);
    }

    @When("I enter {string} as first name")
    public void i_enter_as_first_name(String firstName) {
        accountPage.enterFirstName(firstName);
    }

    @When("I enter {string} as last name")
    public void i_enter_as_last_name(String lastName) {
        accountPage.enterLastName(lastName);
    }

    @When("I enter {string} as email")
    public void i_enter_as_email(String email) {
        accountPage.enterEmail(email);
    }

    @When("I enter {string} as password")
    public void i_enter_as_password(String password) {
        accountPage.enterPassword(password);
    }

    @When("I confirm {string} as password")
    public void i_confirm_as_password(String password) {
        accountPage.enterConfirmPassword(password);
    }

    @When("I click the register button")
    public void i_click_the_register_button() {
        accountPage.clickRegisterButton();
    }

    @Then("I should see the registration success message")
    public void i_should_see_the_registration_success_message() {
        Assert.assertTrue(accountPage.getRegistrationResult().contains("Your registration completed"));
    }

    @Then("I should be logged in as {string}")
    public void i_should_be_logged_in_as(String email) {
        Assert.assertTrue(homePage.isUserLoggedIn(email));
    }

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        homePage.navigateToLoginPage();
    }

    @When("I click the login button")
    public void i_click_the_login_button() {
        accountPage.clickLoginButton();
    }

    @Then("I should see an error message {string}")
    public void i_should_see_an_error_message(String errorMessage) {
        Assert.assertTrue(accountPage.getLoginError().contains(errorMessage));
    }

    // Product Steps
    @When("I click on the {string} category")
    public void i_click_on_the_category(String category) {
        homePage.navigateToCategory(category);
        productListingPage = new ProductListingPage(driver);
    }

    @Then("I should see a list of books")
    public void i_should_see_a_list_of_books() {
        Assert.assertTrue(productListingPage.getProductCount() > 0);
    }

    @Then("the page title should be {string}")
    public void the_page_title_should_be(String title) {
        Assert.assertEquals(title, productListingPage.getPageTitle());
    }

    @When("I click on the product {string}")
    public void i_click_on_the_product(String productName) {
        productListingPage.clickProductByName(productName);
        productDetailsPage = new ProductDetailsPage(driver);
    }

    @Then("I should see the product details page for {string}")
    public void i_should_see_the_product_details_page_for(String productName) {
        Assert.assertEquals(productName, productDetailsPage.getProductName());
    }

    @Then("I should see the product price")
    public void i_should_see_the_product_price() {
        Assert.assertFalse(productDetailsPage.getProductPrice().isEmpty());
    }

    @When("I click the {string} button")
    public void i_click_the_button(String buttonText) {
        if (buttonText.equals("Add to cart")) {
            productDetailsPage.addToCart();
        }
    }

    @Then("I should see a notification that the product was added to cart")
    public void i_should_see_a_notification_that_the_product_was_added_to_cart() {
        Assert.assertTrue(productDetailsPage.getNotificationMessage().contains("The product has been added to your"));
    }

    // Cart Steps
    @When("I add the product {string} to cart")
    public void i_add_the_product_to_cart(String productName) {
        productListingPage.addProductToCartByName(productName);
        productDetailsPage = new ProductDetailsPage(driver);
    }

    @When("I navigate to the shopping cart")
    public void i_navigate_to_the_shopping_cart() {
        homePage.navigateToShoppingCart();
        cartPage = new CartPage(driver);
    }

    @Then("I should see {string} in my cart")
    public void i_should_see_in_my_cart(String productName) {
        Assert.assertTrue(cartPage.isProductInCart(productName));
    }

    @Then("the cart should have {int} item")
    public void the_cart_should_have_item(int count) {
        Assert.assertEquals(count, cartPage.getCartItemCount());
    }

    @Given("I have {string} in my cart")
    public void i_have_in_my_cart(String productName) {
        homePage.navigateToBooksCategory();
        productListingPage = new ProductListingPage(driver);
        productListingPage.addProductToCartByName(productName);
        homePage.navigateToShoppingCart();
        cartPage = new CartPage(driver);
    }

    @When("I update the quantity to {string}")
    public void i_update_the_quantity_to(String quantity) {
        cartPage.updateQuantity(0, Integer.parseInt(quantity));
    }

    @When("I click the update cart button")
    public void i_click_the_update_cart_button() {
        cartPage.clickUpdateCartButton();
    }

    @Then("the quantity should be {string}")
    public void the_quantity_should_be(String expectedQuantity) {
        Assert.assertEquals(expectedQuantity, cartPage.getQuantity(0));
    }

    @Then("the subtotal should reflect the updated quantity")
    public void the_subtotal_should_reflect_the_updated_quantity() {
        double price = Double.parseDouble(cartPage.getItemPrice(0).replace("$", ""));
        int quantity = Integer.parseInt(cartPage.getQuantity(0));
        double expectedSubtotal = price * quantity;
        double actualSubtotal = Double.parseDouble(cartPage.getItemSubtotal(0).replace("$", ""));
        
        Assert.assertEquals(expectedSubtotal, actualSubtotal, 0.001);
    }

    @When("I remove the product from cart")
    public void i_remove_the_product_from_cart() {
        cartPage.removeItem(0);
    }

    @Then("the cart should be empty")
    public void the_cart_should_be_empty() {
        Assert.assertEquals(0, cartPage.getCartItemCount());
    }

    @Then("I should see the empty cart message")
    public void i_should_see_the_empty_cart_message() {
        Assert.assertTrue(cartPage.getEmptyCartMessage().contains("Your Shopping Cart is empty!"));
    }

    // Checkout Steps
    @Given("I am logged in as {string}")
    public void i_am_logged_in_as(String email) {
        homePage.navigateToLoginPage();
        accountPage.enterLoginEmail(email);
        accountPage.enterLoginPassword("password123");
        accountPage.clickLoginButton();
    }

    @When("I proceed to checkout")
    public void i_proceed_to_checkout() {
        cartPage.acceptTermsAndCheckout();
        checkoutPage = new CheckoutPage(driver);
    }

    @When("I enter billing address:")
    public void i_enter_billing_address(Map<String, String> addressDetails) {
        checkoutPage.selectCountry(addressDetails.get("Country"));
        checkoutPage.enterCity(addressDetails.get("City"));
        checkoutPage.enterAddress(addressDetails.get("Address"));
        checkoutPage.enterZipCode(addressDetails.get("Zip"));
        checkoutPage.enterPhoneNumber(addressDetails.get("Phone"));
        checkoutPage.clickBillingContinue();
    }

    @When("I continue through shipping and payment")
    public void i_continue_through_shipping_and_payment() {
        checkoutPage.clickShippingMethodContinue();
        checkoutPage.clickPaymentMethodContinue();
        checkoutPage.clickPaymentInfoContinue();
    }

    @When("I confirm the order")
    public void i_confirm_the_order() {
        checkoutPage.clickConfirmOrder();
    }

    @Then("I should see the order confirmation page")
    public void i_should_see_the_order_confirmation_page() {
        Assert.assertTrue(checkoutPage.getOrderConfirmationTitle().contains("Thank you"));
    }

    @Then("I should receive an order number")
    public void i_should_receive_an_order_number() {
        Assert.assertFalse(checkoutPage.getOrderNumber().isEmpty());
    }

    // Responsiveness Steps
    @Given("I am on the home page with mobile viewport")
    public void i_am_on_the_home_page_with_mobile_viewport() {
        driver.manage().window().setSize(new Dimension(375, 812)); // iPhone X size
    }

    @Then("all main elements should be visible and properly aligned")
    public void all_main_elements_should_be_visible_and_properly_aligned() {
        // Implementation would check element visibility and positioning
        Assert.assertTrue(homePage.isLogoDisplayed());
    }

    @When("I click on the menu toggle")
    public void i_click_on_the_menu_toggle() {
        homePage.clickMobileMenuToggle();
    }

    @Then("I should see the navigation menu")
    public void i_should_see_the_navigation_menu() {
        Assert.assertTrue(homePage.isMobileMenuDisplayed());
    }

    @Given("I am on the {string} category page with tablet viewport")
    public void i_am_on_the_category_page_with_tablet_viewport(String category) {
        driver.manage().window().setSize(new Dimension(768, 1024)); // iPad size
        homePage.navigateToCategory(category);
        productListingPage = new ProductListingPage(driver);
    }

    @Then("the product grid should adjust to the screen size")
    public void the_product_grid_should_adjust_to_the_screen_size() {
        // Implementation would check grid layout
        Assert.assertTrue(productListingPage.isGridResponsive());
    }

    @Then("all product information should be readable")
    public void all_product_information_should_be_readable() {
        // Implementation would check font sizes and element visibility
        Assert.assertTrue(productListingPage.isProductInfoReadable());
    }
}