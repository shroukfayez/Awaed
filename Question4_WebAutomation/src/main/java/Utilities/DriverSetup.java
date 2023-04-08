package Utilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class DriverSetup {

    public static WebDriver driver;
@BeforeTest
    public  void driverInitiate() {
        String ChromePath = System.getProperty("user.dir") + "/src/main/java/Drivers/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",ChromePath);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-site-isolation-trials");
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver= new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }
    @AfterTest
    public void afterTest(){
    driver.quit();
    }

}