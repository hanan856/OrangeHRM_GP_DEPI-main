package Tests;

import Base.baseTest;
import Pages.RecruitmentPage;
import Data.TestData;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RecruitmentTests extends baseTest {
    String expectedPageTitleMSG = "Recruitment";
    String errPageTitleMSG = "Failed to navigate to the Recruitment page.";
    String expectedAssertSuccessMSG = "Success\nSuccessfully Saved";
    String errAssertSuccessMSG = "Error message while adding a new candidate";

    @Owner("Ahmed")
    @Test(description = "Verify navigation to the Recruitment module")
    public void AssertNavigateToRecruitmentModule() {
        recruitmentPage = new RecruitmentPage(driver);
        recruitmentPage.navigateToRecruitment();
        // Add assertion to verify the page has navigated successfully
        String pageTitle = recruitmentPage.getPageTitle();
        Assert.assertEquals(pageTitle, expectedPageTitleMSG,errPageTitleMSG);
    }

    @Owner("Ahmed")
    @Test( description = "Verify adding a new candidate with valid data", dataProvider = "RecruitmentTestData", dataProviderClass = TestData.class)
    public void addCandidateTestCase(String firstName, String middleName, String lastName, String email, String contactNumber, String resumeFilePath, String keywords, String applicationDate, String note){
        recruitmentPage = new RecruitmentPage(driver);

        recruitmentPage.navigateToRecruitment();
        recruitmentPage.clickOnCandidatesTab();
        recruitmentPage.clickAddButton();
        recruitmentPage.enterFirstName(firstName);
        recruitmentPage.enterMiddleName(middleName);
        recruitmentPage.enterLastName(lastName);
        recruitmentPage.selectVacancy();
        recruitmentPage.enterEmail(email);
        recruitmentPage.enterContactNumber(contactNumber);
        recruitmentPage.enterResumeFile(resumeFilePath);
        recruitmentPage.enterKeywords(keywords);
        recruitmentPage.enterDateOfApplication(applicationDate);
        recruitmentPage.enterNote(note);
        recruitmentPage.enterCheckButton();
        recruitmentPage.clickSaveButton();
    }

    @Owner("Ahmed")
    @Test(description = "Assert that success message is displayed",dependsOnMethods = {"addCandidateTestCase"})
    public void AssertSuccessMessageDisplayed() {
        // Assert the existence of the success message after adding a new candidate
        String actualMSG = recruitmentPage.isSuccessMessageDisplayed();
        Assert.assertEquals(actualMSG, expectedAssertSuccessMSG, errAssertSuccessMSG);
    }
}
