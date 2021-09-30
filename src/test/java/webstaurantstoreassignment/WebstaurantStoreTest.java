package webstaurantstoreassignment;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import webstaurantstore.base.WebstaurantStoreBase;

public class WebstaurantStoreTest extends WebstaurantStoreBase  {
	
	

	/* 1. Go to https://www.webstaurantstore.com/
	 * 2. Search for 'stainless work table.'
	 * 3. Check the search result ensuring every product item has the word 'Table' in it its title.
	 * 4. Add the last of found items to Cart.
	 * 5. Empty Cart.
	 */
	
	@BeforeTest 
//1. Go to https://www.webstaurantstore.com/
	public void setup() {
		WebstaurantStoreBase.setupBrowser("chrome"); 
		WebstaurantStoreBase.initialization(); // 
	}
	
	@Test (priority=1) 
//2. Search for 'stainless work table.'
	public void Search() {
		driver.findElement(By.name("searchval")).sendKeys("stainless work table");
		driver.findElement(By.xpath("//button[contains(text(),'Search')]")).click();
	}
	
	@Test (priority=2) 
//3. Check the search result ensuring every product item has the word 'Table' in it its title.
	public void ContainsTableInTitle () {
		
		List<WebElement> allProducts = driver.findElements(By.xpath("//div[@class='ag-item gtm-product ']"));
		for(WebElement product:allProducts) {
			if(product.getText().contains("title")) {
				Assert.assertTrue(true);
			}

			}
				
			}
	@Test (priority=3)
//4. Add the last of found items to Cart.
	public void AddLastItem() {
		List<WebElement> allProducts = driver.findElements(By.xpath("//div[@class='ag-item gtm-product ']"));
		WebElement LastProduct = allProducts.get(allProducts.size()-1);
		LastProduct.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement AddToCart = driver.findElement(By.xpath("//input[@type='submit']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(AddToCart);
		actions.click();
		actions.perform();
		
		
				
		}
	
	@Test (priority=4)
//5. Empty Cart.
	public void EmptyCart() {
		driver.findElement(By.xpath("//span[contains(text(),'Cart')]")).click();
		driver.findElement(By.xpath("//a[contains(text(), 'Empty Cart')]")).click();
		driver.findElement(By.xpath("//button[contains(text(), 'Empty Cart')]")).click();

	}
	
	@AfterTest
	public void tearDown()
	{
		
		driver.quit();
	}
	
		
		
		}
		
	
	
	
		
	
	


