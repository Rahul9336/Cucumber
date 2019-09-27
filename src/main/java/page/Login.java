package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
	 WebDriver driver=null;
	 By username=new By.ByName("userName");
	 By password=new By.ByName("password");
	 By click=new By.ByXPath("//input[@name='Login']");
	public Login(WebDriver driver){
		this.driver=driver;
	}
	
	public  void Before_do_login(){
		driver.findElement(By.linkText("SignIn")).click();	
	}
	
	public void do_login(String username1,String password1){
		driver.findElement(username).sendKeys(username1);
		driver.findElement(password).sendKeys(password1);
		driver.findElement(click).click();
	}

}
