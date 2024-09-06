package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.SignUpPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import static org.testng.Assert.assertTrue;

public class SignUpSteps {
    WebDriver driver;
    SignUpPage signUpPage;
    Properties prop = new Properties();

    @Given("the user is on the homepage")
    public void the_user_is_on_the_homepage() throws IOException {
        // Load config.properties
        FileInputStream fileInput = new FileInputStream("src/test/resources/config.properties");
        prop.load(fileInput);

        // Initialize WebDriver and navigate to the URL
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(prop.getProperty("url"));

        // Initialize SignUpPage
        signUpPage = new SignUpPage(driver);
    }

    @When("the user clicks on the \"Create an Account\" button")
    public void the_user_clicks_on_the_create_an_account_button() {
        signUpPage.clickCreateAccount();
    }

    @Then("the user should be redirected to the sign-up page")
    public void the_user_should_be_redirected_to_the_sign_up_page() {
        assertTrue(driver.getCurrentUrl().contains("/customer/account/create/"));
    }

    @Then("the page should display \"Create New Customer Account\"")
    public void the_page_should_display_create_new_customer_account() {
        assertTrue(signUpPage.isSignUpPageDisplayed(), "Sign-up page title is not displayed.");
    }

    @When("the user enters valid sign-up details")
    public void the_user_enters_valid_sign_up_details() {
        signUpPage.enterFirstName("Test");
        signUpPage.enterLastName("User");
        signUpPage.enterEmail("testuser10909@yopmail.com");
        signUpPage.enterPassword("Password123");
        signUpPage.enterConfirmPassword("Password123");
    }

    @When("the user submits the sign-up form")
    public void the_user_submits_the_sign_up_form() {
        signUpPage.clickSignUp();
    }

    @Then("the user should be redirected to the My Account dashboard")
    public void the_user_should_be_redirected_to_the_dashboard() throws InterruptedException {
        String expectedUrl = "https://magento.softwaretestingboard.com/customer/account/";
        assertTrue(driver.getCurrentUrl().contains(expectedUrl));
        Thread.sleep(5000);
        driver.quit();
    }
}
