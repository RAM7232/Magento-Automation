package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignUpPage {
    WebDriver driver;

    By createAccountButton = By.xpath("//a[contains(text(),'Create an Account')]");
    By pageTitle = By.xpath("//h1/span[text()='Create New Customer Account']");
    By firstNameField = By.id("firstname");
    By lastNameField = By.id("lastname");
    By emailField = By.id("email_address");
    By passwordField = By.id("password");
    By confirmPasswordField = By.id("password-confirmation");
    By signUpButton = By.xpath("//button[@title='Create an Account']");

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCreateAccount() {
        driver.findElement(createAccountButton).click();
    }

    public boolean isSignUpPageDisplayed() {
        WebElement title = driver.findElement(pageTitle);
        return title.isDisplayed();
    }

    public void enterFirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        driver.findElement(confirmPasswordField).sendKeys(confirmPassword);
    }

    public void clickSignUp() {
        driver.findElement(signUpButton).click();
    }
}
