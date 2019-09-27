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
import page.SignUpPage;


public class SignUp {
	
	WebDriver driver=null;
	WebDriverWait wait=null;
	static  private SignUpPage signup=null;
	@Given("^User Must Not be already Register with application$")
	public void user_Must_Not_be_already_Register_with_application() throws Throwable {
	   Assert.assertEquals(true, true); 
	}

	@Given("^user must be on SignUp Page$")
	public void user_must_be_on_SignUp_Page() throws Throwable {
		driver=RunBrowser.runBrowser("chrome", "http://10.232.237.143:443/TestMeApp/fetchcat.htm");
		wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Home")));
		signup=new SignUpPage(driver);
		signup.do_before_signup();
		Assert.assertEquals(driver.getTitle(), "Sign Up");
	}

	@When("^User enter the username \"([^\"]*)\"$")
	public void user_enter_the_username(String arg1) throws Throwable {
	    signup.enterUsername(arg1);
	    
	}

	@When("^User enter the first name \"([^\"]*)\" and last name \"([^\"]*)\"$")
	public void user_enter_the_first_name_and_last_name(String arg1, String arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	  signup.enterFirstNameLastName(arg1, arg2);
	}

	@When("^User enter the password \"([^\"]*)\" and confirm password \"([^\"]*)\"$")
	public void user_enter_the_password_and_confirm_password(String arg1, String arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    signup.enterPasswordAndConfirmPassword(arg1, arg2);
	}

	@When("^User choose the Gender as \"([^\"]*)\"$")
	public void user_choose_the_Gender_as(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   signup.enterGender(arg1);
	}

	@When("^User Enter the Email \"([^\"]*)\"$")
	public void user_Enter_the_Email(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    signup.enterEMail(arg1);
	}

	@When("^User Enter the Mobile Number \"([^\"]*)\"$")
	public void user_Enter_the_Mobile_Number(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	  signup.enterPhoneNumber(arg1);
	}

	@When("^User Choose the DOB from date picker \"([^\"]*)\"$")
	public void user_Choose_the_DOB_from_date_picker(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    signup.enterDOB(arg1);
	}

	@When("^User Enter the Address \"([^\"]*)\"$")
	public void user_Enter_the_Address(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		signup.enterAddress(arg1);
	}

	@When("^User Choose the Security Question \"([^\"]*)\"$")
	public void user_Choose_the_Security_Question(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete action
	}

	@When("^User Enter the Security Answer \"([^\"]*)\"$")
	public void user_Enter_the_Security_Answer(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		signup.enterSecurityAnswer(arg1);
	}

	@When("^User click on Register$")
	public void user_click_on_Register() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	  signup.clickRegisterButton();
	}

	@Then("^User must be navigate to Login Page$")
	public void user_must_be_navigate_to_Login_Page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	  Assert.assertEquals(driver.getTitle(), "Login");
	}

	@Then("^Message will be Displayed \"([^\"]*)\"$")
	public void message_will_be_Displayed(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(arg1, signup.getmessage());
	}
}
