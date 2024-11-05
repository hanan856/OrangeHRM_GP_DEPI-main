package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BuzzPage {


    WebDriver driver;
    WebDriverWait wait;

    //define my locators
    By buzzModule=By.xpath("//span[text()='Buzz']");
    By captionPost=By.xpath("    //div[@class=\"oxd-buzz-post oxd-buzz-post--active\"]//textarea[@class=\"oxd-buzz-post-input\"]");
    By postButton=By.xpath("//button[@type=\"submit\"]");
    By toDeleteButton=By.xpath(" (//li[@class='']//button[@class=\"oxd-icon-button\"])[1]");
    By delete=By.xpath("(//li[@class=\"orangehrm-buzz-post-header-config-item\"])[1] ");
    By yesDelete=By.xpath("    //button[@class=\"oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin\"]\n ");
    By successMSG=By.xpath("//div[@id='oxd-toaster_1']/div/div");

    // Constructor
    public BuzzPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToBuzz() {
        driver.findElement(buzzModule).click();
    }


    public void addCaptionPost(String caption) {
        WebElement addCaptionElement = driver.findElement(captionPost);
        addCaptionElement.clear(); // Clear any existing text if needed
        addCaptionElement.sendKeys(caption);
    }
    public void clickPost() {
        WebElement addButtonElement = driver.findElement(postButton);
        addButtonElement.click();
    }


    public void toDelete() {
        WebElement toDeleteElement = driver.findElement(toDeleteButton);
        toDeleteElement.click();
    }

    public void clickDelete() {
        WebElement deleteElement = driver.findElement(delete);
        deleteElement.click();
    }

    public void clickYesDelete() {
        WebElement yesDeleteElement = driver.findElement(yesDelete);
        yesDeleteElement.click();
    }

    public String isSuccessMessageDisplayed() {
        WebElement msg = driver.findElement(successMSG);
        return msg.getText();
    }
}
