package Tests;

import Base.baseTest;
import Data.TestData;
import Pages.PerformancePage;
import io.qameta.allure.Owner;
import org.testng.annotations.Test;

public class PerformanceTests extends baseTest {
    PerformancePage performancePage;

    @Owner("Haitham")
    @Test(priority = 1, description = "Verify login and searching for a performance review", dataProvider = "PerformanceTestData", dataProviderClass = TestData.class)
    public void searchPerformanceReview_TC1(String partialEmployeeName,String passwordUNUSED) {

        performancePage = new PerformancePage(driver);

        performancePage.navigateToPerformance();
        performancePage.enterEmployeeName(partialEmployeeName);

        performancePage.selectEmployeeSuggestion();

        performancePage.clickSearchButton();



    }
}
