package webstaurantstore.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebstaurantStoreBase {
	
	public static WebDriver driver;
	
public static void setupBrowser (String browserName){
		
		if(browserName.equals("chrome")){
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browserName.equals("ff")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		}
		
public static void initialization() {
		
		driver.get("https://www.webstaurantstore.com/");	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	}

}
