package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyInfoPage {
    WebDriver driver;
    WebDriverWait wait;

    //locators
    By infoMenu = By.xpath("(//span[@class=\"oxd-text oxd-text--span oxd-main-menu-item--name\"])[6]");
    By Nationality = By.xpath("(//div[@class=\"oxd-select-text-input\"])[1]");
    By NationalityOption = By.xpath("(//div[@class=\"oxd-select-option\"])[2]");
    By SaveBtn1 = By.xpath("(//button[@class=\"oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space\"])[1]");
    By SaveBtn2 = By.xpath("(//button[@class=\"oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space\"])[3]");
    By addBTM = By.xpath("(//button[@class=\"oxd-button oxd-button--medium oxd-button--text\"])");
    By resumeUploadField = By.xpath("//input[@type='file']");
    By successMSG = By.xpath("//div[@id='oxd-toaster_1']/div/div");
    By dataField = By.xpath("(//input[@placeholder='yyyy-dd-mm'])[2]");

    public MyInfoPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to navigate to the PIM section
    public void navigateToMyInfo() {
        driver.findElement(infoMenu).click();
    }

    public void selectNationality() {
        // Click the dropdown to open the options
        WebElement dropDown = driver.findElement(Nationality);
        dropDown.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(NationalityOption));
        WebElement option = driver.findElement(NationalityOption);
        option.click();
    }

    public void enterDateOfBirth(String date) {
        WebElement dateField = driver.findElement(dataField);
        dateField.sendKeys(Keys.CONTROL + "a");
        dateField.sendKeys(Keys.DELETE);
        dateField.sendKeys(date);
    }

    public void clickSaveButton1() {
        driver.findElement(SaveBtn1).click();
    }

    public String isSuccessMessageDisplayed() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement msg = driver.findElement(successMSG);
        return msg.getText();
    }

    public void clickAddButton() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(addBTM).click();
    }

    public void enterResumeFile(String resumeUpload) {
        WebElement resumeUploadFieldElement = driver.findElement(resumeUploadField);
        resumeUploadFieldElement.sendKeys(resumeUpload);
    }

    public void clickSaveButton2() {
        driver.findElement(SaveBtn2).click();
    }
}

