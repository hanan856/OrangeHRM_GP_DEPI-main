package Tests;

import Base.baseTest;
import Pages.ClaimPage;
import Pages.NavigationBarPage;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationBarTest extends baseTest {
    String expectedAboutButtonMSG = "OrangeHRM";
    String errAboutButtonMSG ="assert fail we are not in the support tap";
    String expectedUrl = "https://orangehrm.com/open-source/upgrade-to-advanced";
    String errorSupportButtonMSG = "assert fail we are not in the support tap";
    String errUpgradeButton = "The Upgrade button did not open the correct URL.";
    String expectedSupportButtonMSG = "Getting Started with OrangeHRM";

    @Owner("Ahmed")
    @Test(description = "Verify Functionality of About Button")
    public void AboutButtonTest() {
        navigationBarPage.clickDropDownButton();
        navigationBarPage.clickAboutButton();
        //navigationBarPage.clickCloseAboutButton();
    }

    @Owner("Ahmed")
    @Test(description = "Assert About button work",dependsOnMethods = {"AboutButtonTest"})
    public void AssertAboutButtonTest() {
        String actualMSG = navigationBarPage.AssertAboutButton();
        Assert.assertEquals(actualMSG, expectedAboutButtonMSG, errAboutButtonMSG);
    }

    @Owner("Ahmed")
    @Test(description = "Verify Functionality of Support Button")
    public void SupportButtonTest() {
        navigationBarPage.clickCloseAboutButton();
        navigationBarPage.clickDropDownButton();
        navigationBarPage.clickSupportButton();
    }

    @Owner("Ahmed")
    @Test(description = "Assert support button work",dependsOnMethods = {"SupportButtonTest"})
    public void AssertSupportButtonTest() {
        String actualMSG = navigationBarPage.AssertSupportButton();
        Assert.assertEquals(actualMSG, expectedSupportButtonMSG, errorSupportButtonMSG);
    }

    @Owner("Ahmed")
    @Test(description = "Verify the Upgrade button opens a new tab with the correct URL")
    public void testUpgradeButtonOpensNewTab() {

        navigationBarPage.clickUpgradeButton();
        navigationBarPage.switchToNewTab();

        // Get the current URL in the new tab
        String actualUrl = navigationBarPage.getCurrentUrl();

        // Verify the URL
        Assert.assertEquals(actualUrl, expectedUrl, errUpgradeButton);
    }

}
