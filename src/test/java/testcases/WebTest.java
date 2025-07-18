package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.DriverSetup;

//import static utilities.DriverSetup.getDriver;

public class WebTest extends DriverSetup{

    @Test
    public void testPageTitle(){
//        driver.get("https://facebook.com");
        getDriver().get("https://facebook.com");
        Assert.assertEquals(getDriver().getTitle(),"Facebook – log in or sign up");
        System.out.println(getDriver().getCurrentUrl());
    }


}
