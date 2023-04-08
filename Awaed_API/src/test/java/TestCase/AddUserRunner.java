package TestCase;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


public class AddUserRunner {

    @CucumberOptions
            (glue = {"src/test/java/AddUserStepsDefs"},
                    features = {"src/test/java/"},
                    plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
                    monochrome = true)

    public class AddUser  extends AbstractTestNGCucumberTests {
    }

}

