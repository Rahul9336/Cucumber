package cucumber.caseStudy.testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.caseStudy.testing.utilityClass.RunBrowser;
import junit.framework.Assert;
import page.Login;

public class Search {
	WebDriver driver = null;
	WebDriverWait wait = null;
	static private Login login = null;
	static Actions act=null;
	@Given("^User Must Login with TestMe$")
	public void user_Must_Login_with_TestMe() throws Throwable {
		driver=RunBrowser.runBrowser("chrome", "http://10.232.237.143:443/TestMeApp/fetchcat.htm");
		wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Home")));
		act=new Actions(driver);
		login=new Login(driver);
		login.Before_do_login();
		login.do_login("lalitha", "Password123");
	}

	@When("^User Click on Search Box$")
	public void user_Click_on_Search_Box() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 
		act.moveToElement(driver.findElement(By.name("products"))).click().build().perform();
	}

	@When("^User Enter the four letter \"([^\"]*)\"$")
	public void user_Enter_the_four_letter(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.name("products")).sendKeys(arg1);
	}

	@When("^User click  on the dropdown suggestion \"([^\"]*)\"$")
	public void user_click_on_the_dropdown_suggestion(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.name("products")).sendKeys(Keys.ARROW_DOWN);
	}

	@When("^Click on link Find Details$")
	public void click_on_link_Find_Details() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    driver.findElement(By.xpath("//input[@value='FIND DETAILS']")).click();
	}

	@When("^User click on \"([^\"]*)\" button$")
	public void user_click_on_button(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		act.moveToElement(driver.findElement(By.linkText(arg1))).click().build().perform();
	}

	@When("^Cart Value is Updated and Visible$")
	public void cart_Value_is_Updated_and_Visible() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String check=null;
		int cartValue=-1;
		check = driver.findElement(By.partialLinkText("Cart")).getText();
		for (int i = 0; i < check.length(); i++) {
			if (check.charAt(i) == '1') {
				cartValue = Character.getNumericValue(check.charAt(i));
			}
		}
		if (cartValue > 0) {
			
			Assert.assertEquals("Passed", "Passed");
		} else
			Assert.assertEquals("Passed", "Failed");
	}

	@When("^User click on Cart Button$")
	public void user_click_on_Cart_Button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.partialLinkText("Cart")).click();
	}

	@Then("^User Must be on CheckOut page and Proceed with Payment gateway$")
	public void user_Must_be_on_CheckOut_page_and_Proceed_with_Payment_gateway() throws Throwable {
		driver.findElement(By.partialLinkText("Checkout")).click();
		// wait = new WebDriverWait(driver, 20);
		// wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("\\input[@value='Proceed
		// to Pay']")));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@value='Proceed to Pay']")).click();
		;
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// List<WebElement> bankName=driver.findElements(By.name("radio1"));
		driver.findElement(By.xpath("//label[contains(text(),'HDFC Bank')]")).click();
		;
		driver.findElement(By.id("btn")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.name("username")).sendKeys("123457");
		driver.findElement(By.name("password")).sendKeys("Pass@457");
		driver.findElement(By.xpath("//input[@value='LOGIN']")).click();
		driver.findElement(By.name("transpwd")).sendKeys("Trans@457");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.className("panel-title"));
		Assert.assertEquals(driver.getTitle(), "Order Details");
		driver.close();
	}

	@When("^Application does not show any Suggestion$")
	public void application_does_not_show_any_Suggestion() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    Assert.assertEquals("0", driver.findElement(By.id("itemscount")).getText());
	}

	@Then("^User Must be on Same page and  Test Terminated$")
	public void user_Must_be_on_Same_page_and_Test_Terminated() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    Assert.assertEquals(driver.getTitle(), "Home");
	    driver.close();
	}

	@When("^User Click on Seach Box$")
	public void user_Click_on_Seach_Box() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		act.moveToElement(driver.findElement(By.name("products"))).click().build().perform();
	}

	@When("^User Try to Move to CheckOut page$")
	public void user_Try_to_Move_to_CheckOut_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		try{
		Assert.assertEquals(false,driver.findElement(By.partialLinkText("Cart")).isEnabled());}
		catch(NoSuchElementException exp){
			Assert.assertEquals(true, true);
		}finally{
			System.out.println("User Try to Make Wrong Action");
		}
	}

	@Then("^User Does not get Checkout Page and Test Terminated$")
	public void user_Does_not_get_Checkout_Page_and_Test_Terminated() throws Throwable {
		Assert.assertEquals("View Cart", driver.getTitle());
		driver.close();
	}
}
