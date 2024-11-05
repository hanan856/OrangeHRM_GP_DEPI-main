package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Set;

public class NavigationBarPage {
    WebDriver driver;

    //My locators
    By userDropDownButton = By.xpath("//span[@class=\"oxd-userdropdown-tab\"]");
    By userAboutButton = By.xpath("//a[contains(text(),'About')]");
    By closeAboutButton = By.xpath("//button[@class=\"oxd-dialog-close-button oxd-dialog-close-button-position\"]");
    By assertAbout = By.xpath("//p[text()='OrangeHRM']");
    By userSupport = By.xpath("//a[contains(text(),'Support')]");
    By assertSupport = By.xpath("//h6[text()='Getting Started with OrangeHRM']");
    By upgradeButton = By.xpath("//button[@class='oxd-glass-button orangehrm-upgrade-button']");


    public NavigationBarPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickDropDownButton() {
        WebElement userDropDownButtonElement = driver.findElement(userDropDownButton);
        userDropDownButtonElement.click();
    }

    //method to click on about button
    public void clickAboutButton() {
        WebElement aboutButtonElement = driver.findElement(userAboutButton);
        aboutButtonElement.click();
    }

    //close about button after read website data
    public void clickCloseAboutButton() {
        WebElement closeAboutButtonElement = driver.findElement(closeAboutButton);
        closeAboutButtonElement.click();
    }

    public String AssertAboutButton() {
        WebElement msg = driver.findElement(assertAbout);
        return msg.getText();
    }
    ////////////////////////////////////////////////////////////////////////////////////////
    //click on support tap
    public void clickSupportButton() {
        WebElement userSupportElement = driver.findElement(userSupport);
        userSupportElement.click();
    }
    public String AssertSupportButton() {
        WebElement msg = driver.findElement(assertSupport);
        return msg.getText();
    }
    ////////////////////////////////////////////////////////////////////////////////////////

    //click on Upgrade button
    public void clickUpgradeButton() {
        // Wait for the Upgrade button to be clickable and then click it
        WebElement upgradeButtonElement = driver.findElement(upgradeButton);
        upgradeButtonElement.click();
    }
    //After clicking the button, switch the driver's context to the newly opened tab.
    public void switchToNewTab() {
        // Get all window handles
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        // Switch to the new tab
        driver.switchTo().window(tabs.get(1));
    }
    // Return the current URL
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
