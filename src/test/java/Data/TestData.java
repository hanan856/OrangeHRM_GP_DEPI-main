package Data;

import org.testng.annotations.DataProvider;

public class TestData {
    //Test Data used for login test cases
    @DataProvider(name = "LoginTestData")
    public Object[][] LoginTestData() {
        return new Object[][]{
                {
                        "Admin"
                        ,"admin123"
                },
        };
    }


    //Test Data used for Recruitment test cases
    @DataProvider(name = "RecruitmentTestData")
    public Object[][] RecruitmentTestData() {
        return new Object[][]{
                {
                    "Ahmed"
                        ,"Abdelhamid"
                        ,"Hassan"
                        ,"Ahmed@gmail.com"
                        ,"01128793499"
                        ,"C:\\Users\\ammod\\Downloads\\YAT235.pdf"
                        ,"|","2024-10-10"
                        ,"I'm the best person for that vacancy"
                },
        };
    }
    //Test Data used for My info test cases
    @DataProvider(name = "MyInfoTestData")
    public Object[][] MyInfoTestData() {
        return new Object[][]{
                {
                        "C:\\Users\\ammod\\Downloads\\YAT235.pdf"
                },
        };
    }
    //Test Data used for edit info test cases
    @DataProvider(name = "EditInfoTestData")
    public Object[][] EditInfoTestData() {
        return new Object[][]{
                {
                        "2024-10-13"
                },
        };
    }

    //Test Data used for Claim test cases
    @DataProvider(name = "ClaimTestData")
    public Object[][] ClaimTestData() {
        return new Object[][]{
                {
                        "2024-10-13"
                        ,"222"
                        ,"Transportation expense for meeting"
                },
        };
    }
    @DataProvider(name = "EditEmployeeData")
    public Object[][] EditEmployeeData() {
        return new Object[][]{
                {
                        "0364","Nancy","Yousery"
                },
        };
    }

    @DataProvider(name = "ResetPasswordData")
    public Object[][] ResetPasswordData() {
        return new Object[][]{
                {
                        "Admin"
                },
        };
    }
    @DataProvider(name = "LeaveTestData")
    public Object[][] getLeaveTestData() {
        return new Object[][]{
                {"CAN - FMLA", "2024-11-01", "2024-11-10", "Start Day Only", "Vacation with family"},
        };
    }

    @DataProvider(name = "PerformanceTestData")
    public Object[][] PerformanceTestData() {
        return new Object[][]{
                {
                        "a",
                        "admin123"
                },
        };
    }

    @DataProvider(name = "SideBarTestData")
    public Object[][] SideBarTestData() {
        return new Object[][]{
                {
                        "PIM"  // partial employee name
                },
        };
    }

    @DataProvider(name = "jobTitleData")
    public Object[][] jobTitleData() {
        return new Object[][]{
                {
                        "AAAAA Software Tester"
                        ,"Manual Testing and Automation testing"
                        ,"C:\\Users\\ammod\\Downloads\\YAT235.pdf"
                        ,"My task is done"

                },
        };
    }


    @DataProvider(name = "searchData")
    public Object[][] adminSearchData() {
        return new Object[][]{
                {
                        "Admin"
                        ,""


                },
        };
    }

    @DataProvider(name = "addPost")
    public Object[][] addPost() {
        return new Object[][]{
                {
                        "helllooooooo"

                },
        };
    }

    @DataProvider(name = "DeleteEmployeeData")
    public Object[][] DeleteEmployeeData() {
        return new Object[][]{
                {
                        "0303"
                },
        };
    }

}