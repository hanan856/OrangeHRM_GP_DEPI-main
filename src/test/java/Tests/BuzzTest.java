package Tests;
import Base.baseTest;
import Data.TestData;
import Pages.BuzzPage;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BuzzTest extends baseTest {
    String expectedMSG = "Success\nSuccessfully Saved";
    String errorMSG = "Error message while adding a new post";

    @Owner("Hanan")
    @Test(description = "Verify adding a new post", dataProvider = "addPost", dataProviderClass = TestData.class)
    public void addPost(String captionPost) {
        buzzpage =new BuzzPage(driver);
        buzzpage.navigateToBuzz();
        buzzpage.addCaptionPost(captionPost);
        buzzpage.clickPost();
    }

    @Owner("Hanan")
    @Test(description = "assertion",dependsOnMethods = "addPost")
    public void assertion( ){
        String actualMSG = buzzpage.isSuccessMessageDisplayed();
        Assert.assertEquals(actualMSG, expectedMSG, errorMSG);

    }
    @Owner("Hanan")
    @Test(description = "Verify delete  post",dependsOnMethods = "assertion")
    public void deletePost( ) {
        buzzpage =new BuzzPage(driver);
       // buzzpage.navigateToBuzz();
        buzzpage.toDelete();
        buzzpage.clickDelete();
        buzzpage.clickYesDelete();
    }

}
