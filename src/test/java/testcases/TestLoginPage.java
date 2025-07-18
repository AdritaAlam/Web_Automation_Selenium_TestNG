package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utilities.DataSet;
import utilities.DriverSetup;

public class TestLoginPage extends DriverSetup {
    HomePage homePage = new HomePage();
    LoginPage loginpage = new LoginPage();

    @BeforeMethod
    public void loadHomePageForTest() {
        homePage.loadHomePage();
        homePage.clickOnElement(homePage.login_signup_btn);
    }

    @Test
    public void TestLoginWithValidCredentials() {

        loginpage.writeOnElement(loginpage.login_email,"yepoti4396@2mik.com");
        loginpage.writeOnElement(loginpage.password,"1234");
        loginpage.clickOnElement(loginpage.login_btn);
        homePage.addScreenshot("Login page");
        Assert.assertTrue(homePage.isVisible(homePage.logout_btn));
        Assert.assertFalse(loginpage.isVisible(loginpage.login_btn));
    }

    @Test
    public void TestLoginWithValidEmailAndInvalidPassword() {
        loginpage.writeOnElement(loginpage.login_email,"yeoti4396@2mail.com");
        loginpage.writeOnElement(loginpage.password,"1234ab");
        loginpage.clickOnElement(loginpage.login_btn);
        homePage.addScreenshot("Login page");
        Assert.assertEquals(loginpage.getElement(loginpage.error_msg).getText(),"Your email or password is incorrect!");
        Assert.assertTrue(loginpage.isVisible(loginpage.login_btn));

    }
    @Test
    public void TestLoginWithInValidCredentials() {
        loginpage.writeOnElement(loginpage.login_email,"yeoti4396@2mail.comm");
        loginpage.writeOnElement(loginpage.password,"1234a");
        loginpage.clickOnElement(loginpage.login_btn);
        homePage.addScreenshot("Login page");
        Assert.assertEquals(loginpage.getElement(loginpage.error_msg).getText(),"Your email or password is incorrect!");
        Assert.assertTrue(loginpage.isVisible(loginpage.login_btn));

    }

    @Test
    public void TestLoginWithInValidEmailAndValidPassword() {
        loginpage.writeOnElement(loginpage.login_email,"yeoti4396@2mail.co");
        loginpage.writeOnElement(loginpage.password,"1234");
        loginpage.clickOnElement(loginpage.login_btn);
        homePage.addScreenshot("Login page");
        Assert.assertEquals(loginpage.getElement(loginpage.error_msg).getText(),"Your email or password is incorrect!");
        Assert.assertTrue(loginpage.isVisible(loginpage.login_btn));

    }




    @Test
    public void TestLoginWithoutEmailPassword() {
        loginpage.writeOnElement(loginpage.login_email,"");
        loginpage.writeOnElement(loginpage.password,"");
        loginpage.clickOnElement(loginpage.login_btn);
        homePage.addScreenshot("Login page");
        Assert.assertEquals(loginpage.getAttributeValue(loginpage.login_email,"validationMessage"), "Please fill out this field.");
        Assert.assertTrue(loginpage.isVisible(loginpage.login_btn));

    }

    @Test
    public void TestLoginEmailWithoutPassword() {
        loginpage.writeOnElement(loginpage.login_email,"yepoti4396@2mik.com");
        loginpage.writeOnElement(loginpage.password,"");
        loginpage.clickOnElement(loginpage.login_btn);
        homePage.addScreenshot("Login page");
        Assert.assertEquals(loginpage.getElement(loginpage.password).getAttribute("validationMessage"), "Please fill out this field.");
        Assert.assertTrue(loginpage.isVisible(loginpage.login_btn));

    }

    @Test(dataProvider = "invalidUserCredentials", dataProviderClass = DataSet.class)
    public void TestLoginWithInvalidCredentials(String email, String password, String error_msg,String validation_msg){
        loginpage.writeOnElement(loginpage.login_email,email);
        loginpage.writeOnElement(loginpage.password,password);
        loginpage.clickOnElement(loginpage.login_btn);

        if (email.isEmpty()){
            Assert.assertEquals(loginpage.getElement(loginpage.login_email).getAttribute("validationMessage"),validation_msg);
        }
        if (password.isEmpty()){
            Assert.assertEquals(loginpage.getElement(loginpage.password).getAttribute("validationMessage"),validation_msg);
        }
        if (loginpage.isVisible(loginpage.error_msg))
            Assert.assertEquals(loginpage.getElement(loginpage.error_msg).getText(),error_msg);

        Assert.assertTrue(loginpage.isVisible(loginpage.login_btn));
    }

}
