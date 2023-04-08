package Pages;

import Utilities.DriverSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends DriverSetup {

    public WebElement Login_Button(){

        return  driver.findElement(By.id("ctl00_CPHContainer_btnLoginn"));
    }

     public WebElement UsernameTextArea(){

        return driver.findElement(By.id("ctl00_CPHContainer_txtUserLogin"));
}

    public WebElement PasswordTextArea(){

        return driver.findElement(By.id("ctl00_CPHContainer_txtPassword"));
    }

    public WebElement LoginErrorMessage(){
        return driver.findElement(By.id("ctl00_CPHContainer_lblOutput"));
    }
}
