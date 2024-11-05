package Tests;
import Base.baseTest;
import Data.TestData;
import io.qameta.allure.Owner;
import org.testng.annotations.Test;


public class LoginTest extends baseTest {
    String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/sendPasswordReset";
    String errLoginMSG ="Logout failed";
    @Owner("Nancy")
    @Test
    public void testLogout() {
        // Perform logout
        loginPage.clickDropdown();
        loginPage.logout();
    }

    @Owner("Nancy")
    @Test (dependsOnMethods = {"testLogout"},dataProvider = "ResetPasswordData", dataProviderClass = TestData.class)
    public void ForgotPassword_TC2(String username) {
        loginPage.clickForgotPassword();
        loginPage.userNameForgetField(username);
        loginPage.resetPassword();
        String actualUrl = driver.getCurrentUrl();
        assert actualUrl.contains(expectedUrl) : errLoginMSG;
    }
}


