package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage {
    WebDriver driver;

    // Locators
    By signInLink = By.xpath("//a[contains(text(),'Sign In')]");
    By emailField = By.id("email");
    By passwordField = By.id("pass");
    By signInButton = By.id("send2");
//    By welcomeText = By.xpath("//div[contains(@class, 'welcome-msg')]//span[contains(text(),'Welcome,')]");

    // Constructor
    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    // Methods
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

//    public boolean isWelcomeTextDisplayed() {
//        WebElement welcomeElement = driver.findElement(welcomeText);
//        return welcomeElement.isDisplayed();
//    }
//
//    public String getWelcomeText() {
//        return driver.findElement(welcomeText).getText();
//    }
}
