package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class LeavePage {
    WebDriver driver;
    WebDriverWait wait;

    // Define locators
    By leaveModule = By.xpath("//span[text()='Leave']");
    By applyTab = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[1]");
    By leaveTypeDropdown = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div/div[1]");
    By leaveOption = By.xpath("//span[contains(text(),\"CAN - FMLA\")]");
    By fromDateField = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/div/div/input");
    By toDateField = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/div/div/input");
    By partialDaysField = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/form/div[3]/div/div[1]/div/div[2]/div/div/div[1]");
    By patialOption = By.xpath("//span[contains(text(),\"Start Day Only\")]");
    By commentsField = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/div/div/div/div[2]/textarea");
    By applyButton = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[5]/button");
    By ErrorMessage = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/span"); // Assuming the id for success message
    By successMSG = By.xpath("//div[@id='oxd-toaster_1']/div/div");
    public LeavePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigateToLeaveModule() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(leaveModule)).click();
    }

    public LeavePage navigateToApplyTab() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(applyTab)).click();
        return this;
    }

    public void selectLeaveType(String leaveType) {
        WebElement dropdownElement = driver.findElement(leaveTypeDropdown);
        dropdownElement.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(leaveOption));
        WebElement option = driver.findElement(leaveOption);
        option.click();
    }

    public LeavePage enterFromDate(String fromDate) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(fromDateField)).sendKeys(fromDate);
        return this;
    }

    public void enterToDate(String toDate) {
//        WebElement dateField = driver.findElement(toDateField);
//        dateField.sendKeys(Keys.CONTROL + "a");
//        dateField.sendKeys(Keys.DELETE);
//        dateField.sendKeys(toDate);
        WebElement WebDriverWait = wait.until(ExpectedConditions.visibilityOfElementLocated(toDateField));
        WebDriverWait.sendKeys(Keys.CONTROL + "a");
        //WebDriverWait.sendKeys(Keys.DELETE);
        WebDriverWait.sendKeys(toDate);
    }

    public void enterPartialDays(String partialDays) {
        WebElement dropdownElement = driver.findElement(partialDaysField);
        dropdownElement.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(patialOption));
        WebElement option = driver.findElement(patialOption);
        option.click();
    }

    public void enterComments(String comments) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(commentsField)).sendKeys(comments);
    }

    public void clickApplyButton(int test) {
       if(test == 1){
           wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[4]/button"))).click();
       }
        wait.until(ExpectedConditions.visibilityOfElementLocated(applyButton)).click();
    }

    public String isErrorMessageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorMessage)).getText();
    }

    public String isSuccessMessageDisplayed() {
        WebElement msg = driver.findElement(successMSG);
        return msg.getText();
    }
}
