package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
//import io.cucumber.java.en.Then;
import pages.SignInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
//import static org.testng.Assert.assertTrue;

public class SignInSteps {
    WebDriver driver;
    SignInPage signInPage;
    Properties prop = new Properties();

    @Given("the user is on the magento homepage")
    public void the_user_is_on_the_homepage() throws IOException {
        // Load config.properties
        FileInputStream fileInput = new FileInputStream("src/test/resources/config.properties");
        prop.load(fileInput);

        // Initialize WebDriver and navigate to the URL
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(prop.getProperty("url"));

        // Initialize SignInPage
        signInPage = new SignInPage(driver);
    }

    @When("the user clicks on the \"Sign In\" button")
    public void the_user_clicks_on_the_sign_in_button() {
        signInPage.clickSignInLink();
    }

    @When("the user enters valid login credentials")
    public void the_user_enters_valid_login_credentials() {
        // Fetch username and password from config.properties
        String username = prop.getProperty("username");
        String password = prop.getProperty("password");

        signInPage.enterEmail(username);
        signInPage.enterPassword(password);
    }

    @When("the user submits the login form")
    public void the_user_submits_the_login_form() {
        signInPage.clickSignInButton();
        driver.quit();
    }

//    @Then("the user should be redirected to the \"My Account\" dashboard")
//    public void the_user_should_be_redirected_to_the_my_account_dashboard() {
//        String expectedUrl = "https://magento.softwaretestingboard.com/";
//        assertTrue(driver.getCurrentUrl().contains(expectedUrl), "User is not on the My Account dashboard");
//    }
//
//    @Then("the page should display \"Welcome, Test User!\"")
//    public void the_page_should_display_my_dashboard() {
//        assertTrue(signInPage.isDashboardDisplayed(), "Dashboard text is not displayed.");
//     driver.quit();
//    }
}
