package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.DriverSetup;

import static utilities.DriverSetup.getDriver;

public class LoginPage extends BasePage {

    public String url = "https://automationexercise.com/login";

    public By password = By.xpath("//input[@placeholder='Password']");
    public By login_email = By.xpath("//input[@data-qa='login-email']");
    public By login_btn = By.xpath("//button[normalize-space()='Login']");

    public By error_msg = By.xpath("//p[normalize-space()='Your email or password is incorrect!']");

    public String user_email = "";
    public String user_password = "1234";

//    public void loadLoginPage(){
//        loadPage(url);
//    }


}
