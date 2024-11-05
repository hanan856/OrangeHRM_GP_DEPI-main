package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SideBarPage {
    WebDriver driver;

    // Locator for the search field
    By searchSideBarField = By.xpath("//input[@placeholder=\"Search\"]");
    String attributeName = "value";

    public SideBarPage(WebDriver driver) {
        this.driver = driver;
    }

    // perform search in the sidebar
    public void search(String searchText) {
        WebElement searchField = driver.findElement(searchSideBarField);
        searchField.clear();
        searchField.sendKeys(searchText);
    }

    //verify if the search is displayed
    public boolean isSearchTermDisplayed(String searchText) {
        WebElement searchField = driver.findElement(searchSideBarField);
        String currentValue = searchField.getAttribute(attributeName);
        return currentValue.equals(searchText);
    }
}
