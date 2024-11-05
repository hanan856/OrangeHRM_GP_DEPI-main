package Tests;

import Base.baseTest;
import Data.TestData;
import Pages.ClaimPage;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ClaimTest extends baseTest {
    String expectedMSG = "Success\nSuccessfully Saved";
    String errMSG ="Error message while adding a new expense";

    @Owner("Ahmed")
    @Test(description = "Verify adding a new expense claim with valid data",dataProvider = "ClaimTestData", dataProviderClass = TestData.class)
    public void addExpenseClaimTest(String date,String amount,String note){
        claimPage = new ClaimPage(driver);

        claimPage.navigateToClaims();
        claimPage.clickMyClaims();
        claimPage.clickViewDetails();
        claimPage.clickAddExpense();
        claimPage.selectExpenseType();
        claimPage.enterDateOfApplication(date);
        claimPage.enterAmount(amount);
        claimPage.addNote(note);
        claimPage.clickSave();
        claimPage.clickSubmit();
    }

    @Owner("Ahmed")
    @Test(description = "Assert that success message is displayed",dependsOnMethods = {"addExpenseClaimTest"})
    public void AssertSuccessMessageDisplayed() {
        // Assert the existence of the success message after adding a new Expense
        String actualMSG = claimPage.isSuccessMessageDisplayed();
        Assert.assertEquals(actualMSG, expectedMSG,errMSG);
    }
}