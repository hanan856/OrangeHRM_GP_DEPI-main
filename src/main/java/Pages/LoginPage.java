package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    //init my web driver
    WebDriver driver;
    WebDriverWait wait;

    //define my locators
    By userName = By.name("username");
    By Password = By.name("password");
    By loginButton = By.xpath("//button[@type='submit']");
    By userDropdown = By.xpath("//p[@class=\"oxd-userdropdown-name\"]");
    By logoutButton = By.xpath("//a[contains(text(),\"Logout\")]");
    By forgotPasswordLink = By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[4]/p");
    By resetPasswordButton = By.xpath("//button[@type=\"submit\"]");
    By userNameForget=By.xpath("//input[@name=\"username\"]");

    //constructor to int the driver
    public LoginPage(WebDriver drive) {
        this.driver = drive;
    }

    public void userNameField(String username) {
        WebElement userNameElement = driver.findElement(userName);
        userNameElement.clear();
        userNameElement.sendKeys(username);
    }

    public void passwordField(String password) {
        WebElement passwordElement = driver.findElement(Password);
        passwordElement.clear();
        passwordElement.sendKeys(password);
    }

    public void loginButton() {
        WebElement loginButtonElement = driver.findElement(loginButton);
        loginButtonElement.click();
    }
    public void clickDropdown() {
        WebElement userDropdownElement = driver.findElement(userDropdown);
        userDropdownElement.click();
    }
    public void logout() {
        WebElement logoutButtonElement = driver.findElement(logoutButton);
        logoutButtonElement.click();
    }
    public void clickForgotPassword() {
        WebElement forgotPasswordElement = driver.findElement(forgotPasswordLink);
        forgotPasswordElement.click();
    }
    public void userNameForgetField(String username) {
        WebElement userNameForgetFieldElement = driver.findElement(userNameForget);
        userNameForgetFieldElement.sendKeys(username);
    }
    public void resetPassword() {
        WebElement resetButtonElement = driver.findElement(resetPasswordButton);  // Using the updated XPath for the button
        resetButtonElement.click();
    }
}
