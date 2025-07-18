package pages;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.ByteArrayInputStream;

import static utilities.DriverSetup.getDriver;

public class BasePage {
    public WebElement getElement(By locator){
        return getDriver().findElement(locator);
    }

    public void loadPage(String url){
        getDriver().get(url);
    }

    public void clickOnElement(By locator){
        getElement(locator).click();
    }

    public void writeOnElement(By locator, String text){
        getElement(locator).sendKeys(text);
    }

    public String getAttributeValue(By locator, String attributeName){
        return getElement(locator).getAttribute(attributeName);
    }

    public Boolean isVisible(By locator){
        try{
            return getElement(locator).isDisplayed();
        }catch(Exception e){
            return false;
        }

    }

    public String getElementText(By locator){
        return getElement(locator).getText();
    }

    public void addScreenshot(String name){
        Allure.addAttachment(name, new ByteArrayInputStream(((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES)));


    }
}
