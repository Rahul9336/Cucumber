package cucumber.caseStudy.testing;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(strict = false,features="C:\\Users\\A08019DIRP_C2C.05.02\\workspace\\caseStudy.testing\\resources\\Search.feature"
,plugin = { "pretty", "html:target/site/cucumber-pretty","json:target/cucumber.json" },tags="@Positive")
public class TestRunnerClass {

}
