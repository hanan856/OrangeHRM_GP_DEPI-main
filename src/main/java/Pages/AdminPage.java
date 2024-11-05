package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AdminPage {
    WebDriver driver;
    WebDriverWait wait;

    //define my locators
    By userManagement = By.xpath("    //ul//li[@class=\"oxd-topbar-body-nav-tab --parent --visited\"]\n ");
    By users_option = By.xpath("//a[@class=\"oxd-topbar-body-nav-tab-link\" and contains(text(),Users)]\n ");
    By username_field = By.xpath("//div[@class=\"oxd-input-group oxd-input-field-bottom-space\"]//div[@class='']//input[@class=\"oxd-input oxd-input--active\"] ");
    By userRole_dropdown = By.xpath("  (//div[@class='oxd-select-wrapper']//div[@class=\"oxd-select-text--after\"]//i[@class=\"oxd-icon bi-caret-down-fill oxd-select-text--arrow\"])[1]  ");
    By userRole_option = By.xpath(" (//div[@role=\"option\" and @class=\"oxd-select-option\"])[2] ");
    By employeeName_field = By.xpath("//input[@placeholder=\"Type for hints...\"] ");
    By status_dropdown = By.xpath(" (//div[@class='oxd-select-wrapper']//div[@class=\"oxd-select-text--after\"]//i[@class=\"oxd-icon bi-caret-down-fill oxd-select-text--arrow\"])[2] ");
    By status_option = By.xpath(" (//div[@role=\"option\" and @class=\"oxd-select-option\"])[2] ");
    By searchButton = By.cssSelector("  button[type='submit']\n");
    By adminModule = By.xpath("//span[text()='Admin']");
    By job_Tab = By.xpath("//span[@class='oxd-topbar-body-nav-tab-item' and contains(text(),'Job ')]");
    By JobTitles_option = By.xpath("//a[@class=\"oxd-topbar-body-nav-tab-link\" and contains(text(),'Job Titles')] ");
    By addButton = By.xpath(" //button[@class=\"oxd-button oxd-button--medium oxd-button--secondary\"]");
    By JobTitle_field = By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']//div[@class='']//input[@class=\"oxd-input oxd-input--active\"]");
    By JobDescription_field = By.xpath("//div[@class=\"oxd-input-group oxd-input-field-bottom-space\"]//div[@class='']//textarea[@class=\"oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical\" and @placeholder=\"Type description here\" ]");
    By JobSpecification_file = By.xpath("//input[@class=\"oxd-file-input\"]");
    By Note_field = By.xpath("//div[@class=\"oxd-input-group oxd-input-field-bottom-space\"]//div[@class='']//textarea[@class=\"oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical\" and @placeholder=\"Add note\"]");
    By saveButton = By.cssSelector("  button[type='submit']\n");
    By successMSG=By.xpath("//div[@id='oxd-toaster_1']/div/div");



    // Constructor
    public AdminPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToAdmin() {
        driver.findElement(adminModule).click();
    }

    public void setUsers_option() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        WebElement userManagementTab_Element = driver.findElement(userManagement);
        userManagementTab_Element.click();
        WebElement usersChoice_Element = driver.findElement(users_option);
        usersChoice_Element.click();
    }

    public void addUserName(String username) {
        WebElement emailFieldElement = driver.findElement(username_field);
        emailFieldElement.clear();
        emailFieldElement.sendKeys(username);
    }
    public void addEmployeeName(String empName) {
        WebElement emailFieldElement = driver.findElement(employeeName_field);
        emailFieldElement.clear();
        emailFieldElement.sendKeys(empName);
    }

    public void selectRole(){
        // Click the dropdown to open the options
        WebElement dropDown = driver.findElement(userRole_dropdown);
        dropDown.click();
        // Wait for the dropdown options to become visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(userRole_option));
        // Click on the specific user role option
        WebElement option = driver.findElement(userRole_option);
        option.click();
    }


    public void selectStatus(){
        // Click the dropdown to open the options
        WebElement dropDown = driver.findElement(status_dropdown);
        dropDown.click();
        // Wait for the dropdown options to become visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(status_option));
        // Click on the specific status option
        WebElement option = driver.findElement(status_option);
        option.click();
    }

    public void clickSearchButton() {
        driver.findElement(searchButton).click();
    }

    //////////////////////////////


    public void setJobTitles_option() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        WebElement userManagementTab_Element = driver.findElement(job_Tab);
        userManagementTab_Element.click();
        WebElement usersChoice_Element = driver.findElement(JobTitles_option);
        usersChoice_Element.click();

    }

    public void clickAddButton() {
        WebElement addButtonElement = driver.findElement(addButton);
        addButtonElement.click();
    }

    public void addJobTitle(String title) {
        WebElement emailFieldElement = driver.findElement(JobTitle_field);
        emailFieldElement.clear();
        emailFieldElement.sendKeys(title);
    }

    public void addJobDescription(String title) {
        WebElement emailFieldElement = driver.findElement(JobDescription_field);
        emailFieldElement.clear();
        emailFieldElement.sendKeys(title);
    }


    public void enterResumeFile(String resumeUpload) {
        WebElement resumeUploadFieldElement = driver.findElement(JobSpecification_file);
        resumeUploadFieldElement.sendKeys(resumeUpload);
    }


    public void enterNote(String note) {
        WebElement noteFieldElement = driver.findElement(Note_field);
        noteFieldElement.clear();
        noteFieldElement.sendKeys(note);
    }

    public void clickSaveButton() {
        driver.findElement(saveButton).click();
    }

    public String isSuccessMessageDisplayed() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement msg = driver.findElement(successMSG);
        return msg.getText();
    }


}
