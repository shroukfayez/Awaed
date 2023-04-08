package TestCases;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

public class LoginPageRunner {


    @CucumberOptions
            (glue = {"src/test/java/TestCases/LoginFunctionStepsDefs"},
                    features = {"/src/test/java/TestCases"},
                    plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
                    monochrome = true)

    public class Login  extends AbstractTestNGCucumberTests {
    }

}
