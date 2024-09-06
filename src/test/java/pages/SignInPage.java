package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {
    WebDriver driver;

    By signInLink = By.xpath("//a[contains(text(),'Sign In')]");
    By emailField = By.id("email");
    By passwordField = By.id("pass");
    By signInButton = By.id("send2");

    
    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSignInLink() {
        driver.findElement(signInLink).click();
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }

}
