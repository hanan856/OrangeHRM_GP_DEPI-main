package Tests;

import Base.baseTest;
import Pages.DashboardPage;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DashboardTests extends baseTest {
    String errDashboardMSG = "Dashboard header is incorrect";
    String expectedDashboardHeader = "Dashboard";
    String errTimeAtWorkWidgetMSG = "Time at Work widget is not displayed";
    String errMyActionsWidgetMSG ="My Actions widget is not displayed";
    String errQuickLaunchWidgetMSG = "Quick Launch widget is not displayed";
    String errBuzzLatestPostsWidgetMSG =  "Buzz Latest Posts widget is not displayed";
    String errEmployeesOnLeaveTodayWidgetMSG = "Employees on Leave Today widget is not displayed";
    String errEmployeeDistributionBySubUnitWidgetMSG = "Employee Distribution by Sub Unit widget is not displayed";
    String errEmployeeDistributionByLocationWidgetMSG = "Employee Distribution by Location widget is not displayed";
    String errIsWidgetExpandedMSG = "The widget should be expanded.";
    @Owner("Ahmed")
    @Test
    public void testDashboardHeaderDisplayed() {
        // Verify that the dashboard header is displayed correctly
        String actualHeaderText = dashboardPage.getDashboardHeader();
        Assert.assertEquals(actualHeaderText, expectedDashboardHeader, errDashboardMSG);
    }
    @Owner("Ahmed")
    @Test
    public void testWidgetInteractivity() {
        // Verify interactive elements within the widgets
        dashboardPage.clickExpandCollapseWidget();
    }
    @Owner("Ahmed")
    @Test
    public void testIsWidgetExpanded() {
        dashboardPage.clickExpandCollapseWidget();
        boolean isExpanded = dashboardPage.isWidgetExpanded();
        Assert.assertTrue(isExpanded, errIsWidgetExpandedMSG);
    }
    @Owner("Ahmed")
    @Test
    public void testTimeAtWorkWidgetDisplayed() {
        Assert.assertTrue(dashboardPage.isTimeAtWorkWidgetDisplayed(), errTimeAtWorkWidgetMSG);
    }
    @Owner("Ahmed")
    @Test
    public void testMyActionsWidgetDisplayed() {
        Assert.assertTrue(dashboardPage.isMyActionsWidgetDisplayed(), errMyActionsWidgetMSG);
    }
    @Owner("Ahmed")
    @Test
    public void testQuickLaunchWidgetDisplayed() {
        Assert.assertTrue(dashboardPage.isQuickLaunchWidgetDisplayed(), errQuickLaunchWidgetMSG);
    }
    @Owner("Ahmed")
    @Test
    public void testBuzzLatestPostsWidgetDisplayed() {
        Assert.assertTrue(dashboardPage.isBuzzLatestPostsWidgetDisplayed(), errBuzzLatestPostsWidgetMSG);
    }
    @Owner("Ahmed")
    @Test
    public void testEmployeesOnLeaveTodayWidgetDisplayed() {
        Assert.assertTrue(dashboardPage.isEmployeesOnLeaveTodayWidgetDisplayed(), errEmployeesOnLeaveTodayWidgetMSG);
    }
    @Owner("Ahmed")
    @Test
    public void testEmployeeDistributionBySubUnitWidgetDisplayed() {
        Assert.assertTrue(dashboardPage.isEmployeeDistributionBySubUnitWidgetDisplayed(), errEmployeeDistributionBySubUnitWidgetMSG);
    }
    @Owner("Ahmed")
    @Test
    public void testEmployeeDistributionByLocationWidgetDisplayed() {
        Assert.assertTrue(dashboardPage.isEmployeeDistributionByLocationWidgetDisplayed(),errEmployeeDistributionByLocationWidgetMSG);
    }
}
