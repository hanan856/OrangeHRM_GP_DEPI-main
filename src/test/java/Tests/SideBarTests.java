package Tests;

import Base.baseTest;
import Data.TestData;
import Pages.SideBarPage;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SideBarTests extends baseTest {
    String errSideSearchbarMSG = "The search term was not displayed as expected.";

    @Owner("Ahmed")
    @Test(description = "Verify the search functionality in the sidebar",dataProvider = "SideBarTestData", dataProviderClass = TestData.class)
    public void testSidebarSearch(String searchText) {
        sideBarPage = new SideBarPage(driver);
        // Perform a search in the sidebar
        sideBarPage.search(searchText);
    }

    @Owner("Ahmed")
    @Test(description = "Assert that success message is displayed",dependsOnMethods = {"testSidebarSearch"},dataProvider = "SideBarTestData", dataProviderClass = TestData.class)
    public void AssertSuccessMessageDisplayed(String searchText) {
        // Verify that the search term is displayed correctly in the search field
        boolean isSideSearchDisplayed = sideBarPage.isSearchTermDisplayed(searchText);
        Assert.assertTrue(isSideSearchDisplayed, errSideSearchbarMSG);
    }
}
