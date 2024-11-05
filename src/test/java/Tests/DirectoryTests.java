package Tests;

import Base.baseTest;
import Pages.DirectoryPage;
import io.qameta.allure.Owner;
import org.testng.annotations.Test;


public class DirectoryTests extends baseTest {
    DirectoryPage directoryPage;

    @Owner("Haitham")
    @Test(priority = 1, description = "Verify job title search for 'Chief Financial Officer'")
    public void searchJobTitle() {

        directoryPage = new DirectoryPage(driver);

        directoryPage.navigateToDirectory();

        directoryPage.openJobTitleDropdown();

        directoryPage.selectJobTitleSuggestion();

        directoryPage.clickSearchButton();
    }
}
