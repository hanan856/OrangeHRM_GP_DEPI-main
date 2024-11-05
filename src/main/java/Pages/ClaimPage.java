package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ClaimPage {
    WebDriver driver;
    WebDriverWait wait;

    //Define my locators
    By claimModule = By.xpath("//span[text()='Claim']");
    By myClaimTap = By.xpath("//a[text()='My Claims']");
    By viewDetailsButton = By.xpath("(//button[normalize-space()='View Details'])[3]\n");
    //Another valid xpath  //button[@class="oxd-button oxd-button--medium oxd-button--text oxd-table-cell-action-space"]
    By addExpenseButton = By.xpath("//button[@data-v-6a9dd8d1 and @type=\"button\"]//i[@class=\"oxd-icon bi-plus oxd-button-icon\"]");
    By expenseTypeDropdown = By.xpath("//div[text()= '-- Select --']");
    By optExpenseDropDown = By.xpath("//span[text()= 'Fuel Allowance']");
    By dateField = By.xpath("//input[@placeholder=\"yyyy-dd-mm\"]");
    By amountField = By.xpath("//div[contains(@class, 'oxd-input-group') and .//label[text()='Amount']]//input[contains(@class, 'oxd-input--active')]");
    By noteField = By.xpath("//div[contains(@class, 'oxd-input-group oxd-input-field-bottom-space') and .//div[@class='oxd-input-group__label-wrapper'] and .//label[text()='Note']]//textarea");
    By saveButton = By.xpath("//button[@type=\"submit\"]");
    By submitButton = By.xpath("//button[@class=\"oxd-button oxd-button--medium oxd-button--secondary orangehrm-sm-button\"]");
    By overLay = By.className("oxd-dialog-container-default");
    By successMSG = By.xpath("//div[@id='oxd-toaster_1']/div/div");

    // Constructor
    public ClaimPage(WebDriver driver) {
        this.driver = driver;
    }

    // Navigate to Claims module
    public void navigateToClaims() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement claimModuleElement = driver.findElement(claimModule);
        claimModuleElement.click();
    }
    public void enterAmount(String amount) {
        WebElement amountFieldElement = driver.findElement(amountField);
        amountFieldElement.sendKeys(amount);
    }
    // Click My Claims button
    public void clickMyClaims() {
        WebElement myClaimTapElement = driver.findElement(myClaimTap);
        myClaimTapElement.click();
    }
    // Click View Details button for ini record
    public void clickViewDetails() {
        WebElement viewDetailsButtonElement = driver.findElement(viewDetailsButton);
        viewDetailsButtonElement.click();
    }
    // Click Add Expense button
    public void clickAddExpense() {
        WebElement addExpenseButtonElement = driver.findElement(addExpenseButton);
        addExpenseButtonElement.click();
    }

    // add a note
    public void addNote(String note) {
        if (note != null && !note.isEmpty()) {
            driver.findElement(noteField).sendKeys(note);
        }
    }
    // select a vacancy from the dropdown list
    public void selectExpenseType(){
        // Click the dropdown to open the options
        WebElement dropDown = driver.findElement(expenseTypeDropdown);
        dropDown.click();

        // Wait for the dropdown options to become visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(optExpenseDropDown));

        // Click on the specific vacancy option
        WebElement option = driver.findElement(optExpenseDropDown);
        option.click();
    }

    // Method to enter the date of application
    public void enterDateOfApplication(String date) {
        WebElement dateFieldElement = driver.findElement(dateField);
        dateFieldElement.sendKeys(Keys.CONTROL + "a");
        dateFieldElement.sendKeys(Keys.DELETE);
        dateFieldElement.sendKeys(date); // The format is "yyyy-mm-dd"
    }

    // Click Save button
    public void clickSave() {
        WebElement saveButtonElement = driver.findElement(saveButton);
        saveButtonElement.click();
    }

    // Click Submit button
    public void clickSubmit() {
        WebElement submitButtonElement = driver.findElement(submitButton);
        try {
            submitButtonElement.click();
        } catch (ElementClickInterceptedException e) {
            // Retry after waiting for any overlay to disappear
            wait.until(ExpectedConditions.invisibilityOfElementLocated(overLay));
            submitButtonElement.click();
        }
    }
    public String isSuccessMessageDisplayed() {
        WebElement msg = driver.findElement(successMSG);
        return msg.getText();
    }
}