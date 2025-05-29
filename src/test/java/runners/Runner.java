package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty",
                "junit:target/report/xml-report/cucumber.xml",
                "rerun:target/report/failed_scenarios.txt",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        features = "src/test/resources/features",
        glue = "stepDefs",
        tags = "@UI",
        dryRun = false //IF dryRun=true-JUST GIVE ME THE MISSING STEP DEFINITIONS

)
public class Runner {

}