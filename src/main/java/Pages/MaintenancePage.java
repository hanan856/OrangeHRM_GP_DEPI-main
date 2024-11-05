package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class MaintenancePage {
    WebDriver driver;
    WebDriverWait wait;
    LoginPage loginPage;


    By maintenanceModule = By.xpath("//span[text()='Maintenance']");
    By accessRecordsButton = By.xpath("//a[@class='oxd-topbar-body-nav-tab-item']");
    By employeeNameInputXPath = By.xpath("//input[@placeholder='Type for hints...']");
    By searchButton = By.xpath("//button[@type='submit' and contains(@class, 'oxd-button--secondary')]\n");
    By employeeSuggestion = By.xpath("//div[@role='option' and contains(@class, 'oxd-autocomplete-option')]//span[contains(text(), 'Peter Mac Anderson')]");
    By downloadButton = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div[2]/div/form/div[2]/button");


    public MaintenancePage(WebDriver driver) {
        this.driver = driver;
        this.loginPage = new LoginPage(driver);
    }

    public void navigateToMaintenance() {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement maintenanceModuleElement = driver.findElement(maintenanceModule);
        maintenanceModuleElement.click();
    }

    public void loginToMaintenance(String password) {
        loginPage.passwordField(password);
        loginPage.loginButton();
    }

    public void clickAccessRecords() {
        WebElement accessRecordsButtonElement = driver.findElement(accessRecordsButton);
        accessRecordsButtonElement.click();
    }

    public void inputEmployeeName(String employeeName) {
        WebElement employeeNameElement = driver.findElement(employeeNameInputXPath);
        employeeNameElement.clear();
        employeeNameElement.sendKeys(employeeName);
        wait.until(ExpectedConditions.elementToBeClickable(employeeSuggestion)).click();
    }

    public void searchEmployee() {
        WebElement searchButtonElement = driver.findElement(searchButton);
        searchButtonElement.click();
    }

    public void downloadData() {
        WebElement downloadButtonElement = driver.findElement(downloadButton);
        downloadButtonElement.click();
    }
}
