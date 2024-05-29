package seleniumAutomationDemo.demoSelenium;
import java.time.Duration;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ekartVegtables {

	
		public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		WebDriverWait w = new WebDriverWait(driver, 5);
		
		String[] itemsNeeded = {"Brocolli","Cauliflower","Beetroot"};
		
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		int j=0;
		for (int i = 0; i < products.size(); i++) 
		{
		
		
			String[] name = products.get(i).getText().split("-");
			String formattedNameString = name[0].trim();
			//System.out.println(formattedNameString);
			
		
		List itemsNeededList = Arrays.asList(itemsNeeded);
		
		if(itemsNeededList.contains(formattedNameString))

		{
			j++;
			
			driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
		
		if(j==itemsNeeded.length) 
		{		
			break;
		}
		}
		}
		
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.cssSelector("div[class='cart-preview active'] button[type='button']")).click()
;		
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[class='promoCode']")).sendKeys("rahulshettyacadamy");
		driver.findElement(By.cssSelector("button[class='promoBtn']")).click();
		
		//WebDriverWait w = new WebDriverWait(driver, null);
		
		
	}

}
