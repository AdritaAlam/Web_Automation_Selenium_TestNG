package testcases;

import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.DriverSetup;

public class TestHomePage extends DriverSetup {

    HomePage homepage = new HomePage();

    @BeforeMethod
    public void loadHomePageForTest(){
        homepage.loadHomePage();
    }

    @Test
    public void TestHomePageTitle(){
        homepage.addScreenshot("Home page");
        Assert.assertEquals(getDriver().getTitle(),homepage.title);
    }

    @Test(description = "Test Login-Signup button on the Home page")
    @Description("Allure Description Test Login-Signup button")
    public void TestLoginSignupButton(){
        homepage.addScreenshot("Home page");
        homepage.clickOnElement(homepage.login_signup_btn);
        Assert.assertFalse(getDriver().getCurrentUrl().equals(homepage.url));
    }

//    @Test
//    public void TestContactUsButton(){
//        homepage.clickOnElement(homepage.contact_us_btn);
//        Assert.assertFalse(getDriver().getCurrentUrl().equals(homepage.url));
//    }

}
