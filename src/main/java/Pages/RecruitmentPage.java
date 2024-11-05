package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class RecruitmentPage {
    WebDriver driver;
    WebDriverWait wait;

    //define my locators
    By recruitmentModule = By.xpath("//span[text()='Recruitment']");
    By candidatesTab = By.xpath("//a[contains(text(),'Candidates')]");
    By addButton = By.xpath("//i[@class=\"oxd-icon bi-plus oxd-button-icon\"]\n");
    By firstNameField = By.name("firstName");
    By middleNameField = By.name("middleName");
    By lastNameField = By.name("lastName");
    By jobVacancyDropdown = By.xpath("//div[contains(text(),'-- Select --')]");
    By emailField = By.xpath("//label[text()='Email']/ancestor::div[contains(@class, 'oxd-input-group')]/div[contains(@class, '')]/input[@placeholder='Type here']");//
    By contactNumberField = By.xpath("//label[text()='Contact Number']/ancestor::div[contains(@class, 'oxd-input-group')]/div[contains(@class, '')]/input[@placeholder='Type here']");
    By resumeUploadField = By.xpath("//input[@type='file']");
    By keywordsField = By.xpath("//input[@class=\"oxd-input oxd-input--active\" and @placeholder=\"Enter comma seperated words...\"]");
    By noteField = By.xpath("//textarea[@placeholder=\"Type here\"]");
    By checkButton = By.xpath("//label[contains(text(),'Consent to keep data')]");
    By saveButton = By.xpath("//button[@type=\"submit\"]");
    By vacancyOption = By.xpath("//span[contains(text(),\"test\")]");
    By cancelButton = By.xpath("//button[@class=\"oxd-button oxd-button--medium oxd-button--ghost\"]");
    By successMSG = By.xpath("//div[@id='oxd-toaster_1']/div/div");
    By AssertPageTitle = By.xpath("//h6[text()='Recruitment']");
    By datePath = By.xpath("//input[@placeholder='yyyy-dd-mm']");

    // Constructor
    public RecruitmentPage(WebDriver driver) {
        this.driver = driver;
    }

    // Navigate to Recruitment module
    public void navigateToRecruitment() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(recruitmentModule).click();
    }
    public String getPageTitle(){
        WebElement AssertPageTitleElement = driver.findElement(AssertPageTitle);
        System.out.println(AssertPageTitleElement.getText());
        return AssertPageTitleElement.getText();
    }
    // Navigate to Candidates tab
    public void clickOnCandidatesTab() {
        WebElement addButtonElement = driver.findElement(candidatesTab);
        addButtonElement.click();
    }

    // Click Add button
    public void clickAddButton() {
        WebElement addButtonElement = driver.findElement(addButton);
        addButtonElement.click();
    }

    // Method to enter the first name
    public void enterFirstName(String firstName) {
        WebElement firstNameFieldElement = driver.findElement(firstNameField);
        firstNameFieldElement.sendKeys(firstName);
    }

    // Method to enter the middle name
    public void enterMiddleName(String middleName) {
        WebElement middleNameFieldElement = driver.findElement(middleNameField);
        middleNameFieldElement.sendKeys(middleName);
    }

    // Method to enter the last name
    public void enterLastName(String lastName) {
        WebElement lastNameFieldElement = driver.findElement(lastNameField);
        lastNameFieldElement.sendKeys(lastName);
    }

    // Method to enter the email
    public void enterEmail(String email) {
        WebElement emailFieldElement = driver.findElement(emailField);
        emailFieldElement.sendKeys(email);
    }
    public void enterContactNumber(String contactNumber) {
        WebElement contactNumberFieldElement = driver.findElement(contactNumberField);
        contactNumberFieldElement.sendKeys(contactNumber);
    }

    public void enterKeywords(String keywords) {
        WebElement keywordsFieldElement = driver.findElement(keywordsField);
        keywordsFieldElement.sendKeys(keywords);

    }
    public void enterNote(String note) {
        WebElement noteFieldElement = driver.findElement(noteField);
        noteFieldElement.sendKeys(note);
    }
    public void enterCheckButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkButton)).click();
    }
    public void enterResumeFile(String resumeUpload) {
        WebElement resumeUploadFieldElement = driver.findElement(resumeUploadField);
        resumeUploadFieldElement.sendKeys(resumeUpload);
    }


    // select a vacancy from the dropdown list
    public void selectVacancy(){
        // Click the dropdown to open the options
        WebElement dropDown = driver.findElement(jobVacancyDropdown);
        dropDown.click();

        // Wait for the dropdown options to become visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(vacancyOption));

        // Click on the specific vacancy option
        WebElement option = driver.findElement(vacancyOption);
        option.click();
    }

    // Method to enter the date of application
    public void enterDateOfApplication(String date) {
        WebElement dateField = driver.findElement(datePath);
        dateField.sendKeys(Keys.CONTROL + "a");
        dateField.sendKeys(Keys.DELETE);
        dateField.sendKeys(date);
    }

    // Click Save button
    public void clickSaveButton() {
        driver.findElement(saveButton).click();
    }

    // Method to click the Cancel button
    public void clickCancel() {
        driver.findElement(cancelButton).click();
    }

    public String isSuccessMessageDisplayed() {
        WebElement msg = driver.findElement(successMSG);
        return msg.getText();
    }




    // use of the robot to upload the resume
    public RecruitmentPage uploadResumeWithRobot(String resumePath) {
        // Find the file upload button and click it to open the file chooser
        WebElement webElement = driver.findElement(resumeUploadField);
        webElement.click();

        // Use Robot to upload the file
        try {
            Robot robot = new Robot();
            robot.setAutoDelay(2000);

            // Convert the file path to a char array
            StringSelection filePath = new StringSelection(resumePath);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);

            // Press Control
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);

            //Press V button
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);

            // Press Enter to confirm the upload
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

        } catch (AWTException e) {
            e.printStackTrace();
        }
        return this;
    }
}