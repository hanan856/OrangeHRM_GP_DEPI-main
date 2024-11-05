package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DirectoryPage {
    WebDriver driver;

    By directoryModule = By.xpath("//span[text()='Directory']");
    By jobTitleDropdownArrow = By.xpath("//div[@class='oxd-select-text--after']/i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']"); // New for the dropdown arrow
    By jobTitle = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div[2]/div[5]");
    By searchButton = By.xpath("//button[@type='submit' and contains(@class, 'oxd-button--secondary')]\n");

    public DirectoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToDirectory() {
        WebElement directoryModuleElement = driver.findElement(directoryModule);
        directoryModuleElement.click();
    }


    public void openJobTitleDropdown() {
        WebElement dropdownArrowElement = driver.findElement(jobTitleDropdownArrow);
        dropdownArrowElement.click();
    }

    public void selectJobTitleSuggestion() {
        WebElement suggestionElement = driver.findElement(jobTitle);
        suggestionElement.click();
    }

    public void clickSearchButton() {
        WebElement searchButtonElement = driver.findElement(searchButton);
        searchButtonElement.click();
    }
}