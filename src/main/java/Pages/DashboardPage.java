package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage {
    WebDriver driver;
    WebDriverWait wait;

    // Locators
    By dashboardHeader = By.xpath("//h6[text()='Dashboard']");
    By expandCollapseWidget = By.xpath("//button[@class='oxd-icon-button oxd-main-menu-button']");
    By PIMContent = By.xpath("//span[text()='PIM']"); // Update the selector as per your HTML
    By timeAtWorkWidget = By.xpath("//p[text()='Time at Work']");
    By myActionsWidget = By.xpath("//p[text()='My Actions']");
    By quickLaunchWidget = By.xpath("//p[text()='Quick Launch']");
    By buzzLatestPostsWidget = By.xpath("//p[text()='Buzz Latest Posts']");
    By employeesOnLeaveTodayWidget = By.xpath("//p[text()='Employees on Leave Today']");
    By employeeDistributionBySubUnitWidget = By.xpath("//p[text()='Employee Distribution by Sub Unit']");
    By employeeDistributionByLocationWidget = By.xpath("//p[text()='Employee Distribution by Location']");


    // Constructor
    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }
    //method to extract dashboard header text
    public String getDashboardHeader() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return driver.findElement(dashboardHeader).getText();
    }
    //click to expand or collapse the sidebar
    public void clickExpandCollapseWidget() {
        driver.findElement(expandCollapseWidget).click();
    }
    //check if sidebar expanded again or not
    public boolean isWidgetExpanded() {
        driver.findElement(expandCollapseWidget).click();
        // Check if the widget content is visible
        WebElement content = driver.findElement(PIMContent);
        return content.getText().equals("PIM");
    }
    // Assert methods for verifying widget visibility
    public boolean isTimeAtWorkWidgetDisplayed() {
        return driver.findElement(timeAtWorkWidget).isDisplayed();
    }

    public boolean isMyActionsWidgetDisplayed() {
        return driver.findElement(myActionsWidget).isDisplayed();
    }
    public boolean isQuickLaunchWidgetDisplayed() {
        return driver.findElement(quickLaunchWidget).isDisplayed();
    }

    public boolean isBuzzLatestPostsWidgetDisplayed() {
        return driver.findElement(buzzLatestPostsWidget).isDisplayed();
    }

    public boolean isEmployeesOnLeaveTodayWidgetDisplayed() {
        return driver.findElement(employeesOnLeaveTodayWidget).isDisplayed();
    }

    public boolean isEmployeeDistributionBySubUnitWidgetDisplayed() {
        return driver.findElement(employeeDistributionBySubUnitWidget).isDisplayed();
    }

    public boolean isEmployeeDistributionByLocationWidgetDisplayed() {
        return driver.findElement(employeeDistributionByLocationWidget).isDisplayed();
    }
}
