package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class DriverSetup {
    private static String browser_name = System.getProperty("browser","Chrome");
    private static final ThreadLocal<WebDriver> LOCAL_DRIVER = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return LOCAL_DRIVER.get();
    }

    public static void setDriver(WebDriver driver) {
        DriverSetup.LOCAL_DRIVER.set(driver);
    }


    @BeforeMethod
    public void openBrowser(){

        WebDriver driver = getBrowser(browser_name);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().minimize();
        setDriver(driver);
    }

    @AfterMethod
    public void closeBrowser(){
        getDriver().quit();
    }

    public WebDriver getBrowser(String name){
        if (name.equalsIgnoreCase("firefox")){
            return new FirefoxDriver();
        }
        else if (name.equalsIgnoreCase("chrome")){
            return new ChromeDriver();
        }
        else if (name.equalsIgnoreCase("edge")){
            return new EdgeDriver();
        }
        else{
            throw new RuntimeException("Browser is not currently available with the name "+name);
        }
    }


    public WebElement setImplicitWait(By locator, int seconds){
        WebDriver driver = getBrowser(browser_name);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }
}
