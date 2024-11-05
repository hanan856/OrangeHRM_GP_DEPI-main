package Base;

import Data.TestData;
import Pages.*;
import Tests.LoginTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.time.Duration;

public class baseTest {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected RecruitmentPage recruitmentPage;
    protected LoginTest loginTest;
    protected ClaimPage claimPage;
    protected AdminPage adminPage;
    protected DashboardPage dashboardPage;
    protected EmployeeListPage employeeListPage;
    protected NavigationBarPage navigationBarPage;
    protected SideBarPage sideBarPage;
    protected BuzzPage buzzpage;
    protected MyInfoPage myInfoPage;
    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        loginPage = new LoginPage(driver);
        loginPage.userNameField("Admin");
        loginPage.passwordField("admin123");
        loginPage.loginButton();

        dashboardPage = new DashboardPage(driver);
        navigationBarPage = new NavigationBarPage(driver);

    }

    @AfterMethod
    public void screenShot(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                Utils utils = new Utils();
                utils.takeScreenshot(driver);
            } catch (Exception exception) {
                System.out.println(exception.toString());
            }
        }
    }


    @AfterClass
    public void tearDown(){
        if (driver != null) {
            driver.quit();
        }
    }
}
