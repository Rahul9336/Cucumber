package cucumber.caseStudy.testing.utilityClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class RunBrowser {
	static WebDriver rn=null;
	public static WebDriver runBrowser(String input,String url) {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\A08019DIRP_C2C.05.02\\Desktop\\Rahul_Testing\\Drivers\\chromedriver_win32\\chromedriver.exe");
		System.setProperty("webdriver.ie.driver","C:\\Users\\A08019DIRP_C2C.05.02\\Desktop\\Rahul_Testing\\Drivers\\IEDriverServer_Win32_3.14.0\\IEDriverServer.exe");
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\A08019DIRP_C2C.05.02\\Desktop\\Rahul_Testing\\Drivers\\geckodriver-v0.25.0-win32\\geckodriver.exe");
		
		if(input.equalsIgnoreCase("chrome")){
			rn=new ChromeDriver();
			
		}else if(input.equalsIgnoreCase("FireFox")){
			rn=new FirefoxDriver();
			
		}else if(input.equalsIgnoreCase("InternetExplorer") || input.equalsIgnoreCase("ie")){
			rn=new InternetExplorerDriver();
		}else{
			System.out.println("You missed Something Try Again");
		}
		rn.get(url);
		return rn;
	}
}
