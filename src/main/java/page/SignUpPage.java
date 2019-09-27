package page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage {
	WebDriver driver=null;
	public SignUpPage(WebDriver driver){
		this.driver=driver;
	}
	public void do_before_signup(){
		driver.findElement(By.linkText("SignUp")).click();
	}
	public void enterUsername(String username){
		driver.findElement(By.id("userName")).sendKeys(username);
	}
	public void enterFirstNameLastName(String firstname,String lastName){
		driver.findElement(By.name("firstName")).sendKeys(firstname);
		driver.findElement(By.name("lastName")).sendKeys(lastName);
	}
	public void enterPasswordAndConfirmPassword(String password,String confirmPassword){
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("confirmPassword")).sendKeys(confirmPassword);
	}
	public void enterGender(String gender){
		driver.findElement(By.xpath("//input[@type='radio' and @value="+gender+"]")).click();
	}
	public void enterEMail(String email){
		driver.findElement(By.id("emailAddress")).sendKeys(email);
	}
	public void enterPhoneNumber(String numberphn){
		driver.findElement(By.id("mobileNumber")).sendKeys(numberphn);
	}
	public void enterDOB(String dob){
		driver.findElement(By.xpath("//*[@class='ui-datepicker-trigger']")).click();
		Select sel = new Select(driver.findElement(By.className("ui-datepicker-year")));
		sel.selectByIndex(47);
		driver.findElement(By.xpath("/html/body/div/table/tbody/tr[3]/td[4]/a")).click();
	}
	public void enterAddress(String add){
		driver.findElement(By.id("address")).sendKeys(add);
	}
	public void enterSecurityAnswer(String answer){
		driver.findElement(By.id("answer")).sendKeys(answer);
	}
	public void clickRegisterButton(){
		driver.findElement(By.name("Submit")).click();
	}
	public String getmessage(){
		String message=null;
		List<WebElement> check = driver.findElements(By.xpath("//*[@id='errormsg']"));
		for (WebElement s : check) {
			if (!s.getText().isEmpty()) {
				message = s.getText();
			}
		}
		return message;
	}
}
