package seleniumAutomationDemo.demoSelenium;

import java.beans.Visibility;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import graphql.Assert;

public class eCommerce {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		String productName = "ZARA COAT 3";
		driver.get("https://rahulshettyacademy.com/client/");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("#userEmail")).sendKeys("narsi2024@gmail.com");
		driver.findElement(By.cssSelector("#userPassword")).sendKeys("7675066529");
		LandingPage landingPage = new LandingPage(driver);
		driver.findElement(By.cssSelector("input[value='Login']")).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		
		WebElement prod= products.stream().filter(product -> product.findElement(By.cssSelector("b")).getText().equals("productName")).findFirst().orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".#toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		driver.findElement(By.cssSelector("button[routerlink*='cart']")).click();
		
		List<WebElement> cartProducts= driver.findElements(By.cssSelector(".cart h3"));
		
		boolean Match = cartProducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase("productName"));
		Assert.assertTrue(Match);
		
		driver.findElement(By.xpath("//ul/li/button[@type='button']")).click();		
		
		
		
		driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("ind");
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("class='ta-results'"))));
		
		List<WebElement> countryList = (driver.findElements(By.xpath("//section/button")));
		
		for (WebElement option:countryList) 
		{
			if (option.getText().equalsIgnoreCase("india")) 
			{
				option.click();
				break;
			}
			
		}
		driver.findElement(By.cssSelector("a.btnn.action__submit.ng-star-inserted")).click();
		
		String conformMsg=driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(conformMsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}

}
