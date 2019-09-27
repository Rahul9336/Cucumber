package cucumber.caseStudy.testing;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\A08019DIRP_C2C.05.02\\workspace\\caseStudy.testing\\resources\\Search.feature"
,tags="@Positive",plugin = { "pretty", "html:target/cucumber-reports" })
public class TestRunnerClass {

}
