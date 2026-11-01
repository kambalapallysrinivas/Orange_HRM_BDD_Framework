package testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features={"Features/AdminLogin.feature"},glue="stepdefination",dryRun = false,monochrome = false,tags = "",plugin={"pretty","html:target/report.html"})
public class TestRunner extends AbstractTestNGCucumberTests{

}
