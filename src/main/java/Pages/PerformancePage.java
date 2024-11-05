package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PerformancePage {
    WebDriver driver;


    By performanceModule = By.xpath("//span[text()='Performance']");
    By employeeNameInputXPath = By.xpath("//input[@placeholder='Type for hints...']");
    By searchButton = By.xpath("//button[@type='submit' and contains(@class, 'oxd-button--secondary')]\n");
    By employeeSuggestion = By.xpath("//div[@role='option' and contains(@class, 'oxd-autocomplete-option')]//span[contains(text(), 'Peter Mac Anderson')]");



    public PerformancePage(WebDriver driver) {
        this.driver = driver;
    }


    public void navigateToPerformance() {
        WebElement performanceModuleElement = driver.findElement(performanceModule);
        performanceModuleElement.click();
    }


    public void enterEmployeeName(String partialEmployeeName) {
        WebElement employeeNameInputField = driver.findElement(employeeNameInputXPath);
        employeeNameInputField.click();
        employeeNameInputField.clear();
        employeeNameInputField.sendKeys(partialEmployeeName);
    }


    public void selectEmployeeSuggestion() {
        WebElement suggestionElement = driver.findElement(employeeSuggestion);
        suggestionElement.click();
    }


    public void clickSearchButton() {
        WebElement searchButtonElement = driver.findElement(searchButton);
        searchButtonElement.click();
    }
}
