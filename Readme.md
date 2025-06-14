 Selenium Java Automation - Tricentis Demo Web Shop
This project demonstrates end-to-end test automation using Selenium WebDriver with Java, following the Page Object Model (POM) design pattern and TestNG framework on the Tricentis Demo Web Shop.

🌐 Website Under Test
URL: https://demowebshop.tricentis.com 

For manual
Excel

Google Docs

Operating System and browsers used:

Chrome

Edge

Firefox

For Automation
Selenium

Testing Types
Functional Testing
Usability Testing
Cross browser Testing
Automation testing (Selenium)


The site includes features such as user registration, login, shopping cart, wishlist, product filtering, and checkout — ideal for testing typical e-commerce workflows.

✅ Features Covered in Automation
User registration & login

Adding items to shopping cart

Searching & filtering products

Wishlist management

Proceeding through checkout

UI validations & error message checks

Test reporting with ExtentReports (or Allure)

🚀 Getting Started
1. Clone the Repository
bash
Copy
Edit
git clone https://github.com/your-org/demo-webshop-selenium.git
cd demo-webshop-selenium
2. Import Project
Open in IntelliJ IDEA / Eclipse

Use as a Maven Project

3. Run Tests
Using TestNG:
bash
Copy
Edit
Right-click on testng.xml → Run
Or via Maven:

bash
Copy
Edit
mvn clean test
🗂️ Project Structure
bash
Copy
Edit
src/
  ├── main/
  │   └── java/
  │       └── pages/             # Page Object classes
  ├── test/
  │   └── java/
  │       ├── tests/             # TestNG test classes
  │       └── utils/             # Utility classes (driver, config)
testng.xml
pom.xml
📄 Sample Test - Add to Cart
java
Copy
Edit
@Test
public void addToCartTest() {
    HomePage home = new HomePage(driver);
    home.navigateToHomePage();
    home.addFirstProductToCart();
    Assert.assertTrue(home.getNotificationMessage().contains("The product has been added"));
}
🛠 Tools & Technologies
Java 17+

Selenium WebDriver

TestNG

Maven

Page Object Model

ExtentReports / Allure for reporting

⚠️ Notes
This is a demo site, no real transactions occur.

Use fake data during testing.

Data persistence may vary; some data resets can happen.

📘 Resources
Selenium Documentation

TestNG Documentation

ExtentReports

Tricentis Demo Web Shop

POM
Codes are reusable
Well maintained
Clean testcase
Improved readability
If i have done any mistake in codes or if left any defectfree feel to modify it

Feedback
If you have any feedback, please reach out to me at chamlearti95@gmail.com

