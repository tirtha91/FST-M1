package testrunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
		publish = true,
        features = {"src/test/java/features"},
        monochrome = true,
        tags = "@activity9",
        plugin = { "pretty", "html:target/cucumber-reports.html", "json:target/cucumber-report.json",
        		   "rerun:target/rerun.txt"
        		 },
        glue = {"stepDefinitions"})

public class TestRunner extends AbstractTestNGCucumberTests{

}