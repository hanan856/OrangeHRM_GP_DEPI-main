package Base;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    // Method to take a screenshot
    public void takeScreenshot(WebDriver driver) {
        // Generate a timestamp for the screenshot filename
        String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
        // Convert WebDriver to TakesScreenshot
        TakesScreenshot screenshot = ((TakesScreenshot) driver);
        // Capture the screenshot as a file
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        // Define the destination path for the screenshot
        String destinationPath = System.getProperty("user.dir") + "/screenshots/screenshot_" + timestamp + ".png";
        File destFile = new File(destinationPath);

        try {
            // Copy the screenshot to the destination path
            FileUtils.copyFile(srcFile, destFile);
            System.out.println("Screenshot saved at: " + destinationPath);
        } catch (IOException e) {
            System.out.println("Failed to take screenshot: " + e.getMessage());
        }
    }
}
