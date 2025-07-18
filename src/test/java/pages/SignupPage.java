package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.DriverSetup;

import static utilities.DriverSetup.getDriver;

public class SignupPage extends BasePage {
    public By name = By.xpath("//input[@placeholder='Name']");
    public By password = By.xpath("//input[@placeholder='Password']");
    public By signup_email = By.xpath("//input[@data-qa='signup-email']");
    public By login_email = By.xpath("//input[@data-qa='login-email']");
    public String url = "https://automationexercise.com/login";
    public By signup_btn = By.xpath("//button[normalize-space()='Signup']");
    public By login_btn = By.xpath("//button[normalize-space()='Login']");

    public void loadSignupPage(){
        loadPage(url);
    }

//    writteOnElement(By.xpath("//input[@data-qa='login-email']"));
//    email.writeOnElement("//input[@data-qa='login-email']","Bangladesh")
}
