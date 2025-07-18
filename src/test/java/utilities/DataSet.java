package utilities;

import org.testng.annotations.DataProvider;

public class DataSet {
    @DataProvider(name = "invalidUserCredentials")
    public static Object invalidCredentials(){
        Object[][] data = {
                {"yeoti4396@2mail.com","1234a", "Your email or password is incorrect!",""},
                {"yeoti4396@2mail.com","1234a", "Your email or password is incorrect!",""},
                {"yeoti4396@2mail.co","1234", "Your email or password is incorrect!",""},
                {"","", "","Please fill out this field."},
                {"yepoti4396@2mik.com","","","Please fill out this field."}
        };
        return data;
    }
}
