
import org.testng.annotations.*;

public class test {


    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method");
    }


    @Test
    public void testCase2() {
        System.out.println("Executing Test Case 2");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After Class");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite");
    }
}
