package Tests;
import Base.baseTest;
import Data.TestData;
import Pages.EmployeeListPage;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EmployeeEditTest extends baseTest {
    String expectedMSGEditEmployee = "Success\nSuccessfully Updated";
    String expectedMSGDeleteEmployee = "Success\nSuccessfully Deleted";
    String errorMSGEditing = "Error message while Editing";
    String errorMSGDelete = "Error message while Deleting";

    @Owner("Nancy")
    @Test(dataProvider = "EditEmployeeData", dataProviderClass = TestData.class ,priority = 0)
    public void testEditEmployeeDetails(String id,String Username,String lastname) {
        employeeListPage = new EmployeeListPage(driver);

        employeeListPage.navigateToPIM();
        employeeListPage.selectEmploymentId(id);
        employeeListPage.clickSearchButton();
        employeeListPage.selectEditButton();
        employeeListPage.userNameField(Username);
        employeeListPage.lastnameField(lastname);
        employeeListPage.SaveButton();

    }
    @Owner("Nancy")
    @Test(description = "assertion ",dependsOnMethods = "testEditEmployeeDetails")
    public void EditEmployeeDataAssertSuccessMessageDisplayed(){
        String actualMSG = employeeListPage.isSuccessMessageDisplayed();
        Assert.assertEquals(actualMSG, expectedMSGEditEmployee, errorMSGEditing);
    }

    @Owner("Nancy")
    @Test(dataProvider = "DeleteEmployeeData", dataProviderClass = TestData.class ,priority = 1)
    public void testDeleteEmployee(String id) {
        employeeListPage = new EmployeeListPage(driver);
        employeeListPage.navigateToPIM();
        employeeListPage.selectEmploymentId(id);
        employeeListPage.clickSearchButton();
        employeeListPage.selectDeleteButton();
        employeeListPage.selectConfirmButton();
//        String actualMSG = employeeListPage.isSuccessMessageDisplayed();
//        Assert.assertEquals(actualMSG, expectedMSGDeleteEmployee, errorMSGDelete);
    }

    @Owner("Nancy")
    @Test(description = "assertion ",dependsOnMethods = "testDeleteEmployee")
    public void DeleteEmployeeDataAssertSuccessMessageDisplayed(){
        String actualMSG = employeeListPage.isSuccessMessageDisplayed();
        Assert.assertEquals(actualMSG, expectedMSGDeleteEmployee, errorMSGDelete);
    }
}
