package cucumber.caseStudy.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.caseStudy.testing.utilityClass.RunBrowser;
import junit.framework.Assert;
import page.Login;

public class TestMeLogin {
	WebDriver driver = null;
	WebDriverWait wait = null;
	static private Login login = null;
	@Given("^User must be on Login Page$")
	public void user_must_be_on_Login_Page() throws Throwable {
		driver=RunBrowser.runBrowser("chrome", "http://10.232.237.143:443/TestMeApp/fetchcat.htm");
		wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Home")));
		login=new Login(driver);
		login.Before_do_login();
		Assert.assertEquals(driver.getTitle(), "Login");
	}

	@When("^User enter the Username \"([^\"]*)\" and Password \"([^\"]*)\"$")
	public void user_enter_the_Username_lalitha_and_Password_Password(String arg1,String arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   //login.do_login("lalitha", "Password123");
		login.do_login(arg1, arg2);
	}

	@Then("^User Must Land on Home Page with Sigout Link is Enabled$")
	public void user_Must_Land_on_Home_Page_with_Sigout_Link_is_Enabled() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    Assert.assertEquals(driver.getTitle(), "Home");
	    Assert.assertEquals(true, driver.findElement(By.linkText("SignOut")).isEnabled());
	    driver.close();
	}
}
