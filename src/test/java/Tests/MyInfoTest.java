package Tests;

import Base.baseTest;
import Data.TestData;
import Pages.MyInfoPage;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyInfoTest extends baseTest {
    String expectedAssertSuccessMSG = "Success\nSuccessfully Saved";
    String errInAssertSuccessMSG ="Error message while Editing";
    String expectedAssertSuccessMSGUpdate = "Success\nSuccessfully Updated";

    @Owner("Nancy")
    @Test(priority = 0,dataProvider = "EditInfoTestData", dataProviderClass = TestData.class)
    public void EditInfo(String date) {
        myInfoPage = new MyInfoPage(driver);
        myInfoPage.navigateToMyInfo();
        myInfoPage.enterDateOfBirth(date);
        myInfoPage.clickSaveButton1();
    }

    @Owner("Nancy")
    @Test(description = "Assert that success message is displayed", dependsOnMethods = {"EditInfo"})
    public void AssertSuccessMessageDisplayedEditInfo() {
        String actualMSG = myInfoPage.isSuccessMessageDisplayed();
        Assert.assertEquals(actualMSG, expectedAssertSuccessMSGUpdate, errInAssertSuccessMSG);
    }

    @Owner("Nancy")
    @Test(priority = 1,dataProvider = "MyInfoTestData", dataProviderClass = TestData.class)
    public void AddAttachment(String resumePath){
        myInfoPage = new MyInfoPage(driver);
        myInfoPage.navigateToMyInfo();
        myInfoPage.clickAddButton();
        myInfoPage.enterResumeFile(resumePath);
        myInfoPage.clickSaveButton2();
    }

    @Owner("Nancy")
    @Test(description = "Assert that success message is displayed",dependsOnMethods = {"AddAttachment"})
    public void AssertSuccessMessageDisplayedAddAttachment() {
        String actualMSG = myInfoPage.isSuccessMessageDisplayed();
        Assert.assertEquals(actualMSG, expectedAssertSuccessMSG, errInAssertSuccessMSG);
    }
}


