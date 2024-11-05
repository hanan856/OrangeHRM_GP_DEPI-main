package Tests;

import Base.baseTest;
import Data.TestData;
import Pages.AdminPage;

import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminTest extends baseTest {
    String expectedMSG = "Success\nSuccessfully Saved";
    String ErrorMsg = "Error message while adding a new job title";

    @Owner("Hanan")
    @Test(description = "Verify search for user", dataProvider = "searchData", dataProviderClass = TestData.class)
    public void searchUser( String userName, String empName){
        adminPage = new AdminPage(driver);
        adminPage.navigateToAdmin();
        adminPage.setUsers_option();
        adminPage.addUserName(userName);
        adminPage.selectRole();
        adminPage.addEmployeeName(empName);
        adminPage.selectStatus();
        adminPage.clickSearchButton();

    }
    @Owner("Hanan")
    @Test(description = "Verify adding a new job title", dataProvider = "jobTitleData", dataProviderClass = TestData.class,dependsOnMethods = "searchUser")
    public void addJobTitle(String JobTitle, String JobDescription, String resumeFilePath, String note) {
        adminPage = new AdminPage(driver);
        adminPage.navigateToAdmin();
        adminPage.setJobTitles_option();
        adminPage.clickAddButton();
        adminPage.addJobTitle(JobTitle);
        adminPage.addJobDescription(JobDescription);
        adminPage.enterResumeFile(resumeFilePath);
        adminPage.enterNote(note);
        adminPage.clickSaveButton();
}

    @Owner("Hanan")
    @Test(description = "assertion ",dependsOnMethods = "addJobTitle")
    public void assertion(){
        String actualMSG = adminPage.isSuccessMessageDisplayed();
        Assert.assertEquals(actualMSG, expectedMSG,ErrorMsg);
    }


}
