package Tests;

import Base.baseTest;
import Data.TestData;
import Pages.MaintenancePage;
import io.qameta.allure.Owner;
import org.testng.annotations.Test;

public class MaintenanceDownloadTests extends baseTest {
    MaintenancePage maintenancePage;

    @Owner("Haitham")
    @Test(priority = 1, description = "Verify employee data download",
            dataProvider = "PerformanceTestData", dataProviderClass = TestData.class)
    public void downloadEmployeeData_TC1(String employeeName,String password) {
        maintenancePage = new MaintenancePage(driver);


        maintenancePage.navigateToMaintenance();


        maintenancePage.loginToMaintenance(password);


        maintenancePage.clickAccessRecords();


        maintenancePage.inputEmployeeName(employeeName);

        maintenancePage.searchEmployee();

        maintenancePage.downloadData();
    }
}


