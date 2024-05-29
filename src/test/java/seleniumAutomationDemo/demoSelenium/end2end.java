package seleniumAutomationDemo.demoSelenium;
import java.lang.foreign.Linker.Option;
import java.text.BreakIterator;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import dev.failsafe.internal.util.Assert;

public class end2end {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.cssSelector("input#autosuggest")).sendKeys("Ind");
		Thread.sleep(3000);
		/* List<WebElement> options = (List<WebElement>) driver.findElement(By.cssSelector("li[class='ui-menu-item'] a"));
		
		for(WebElement option : options)
		{
			if(option.getText().equalsIgnoreCase("india"));
		}
			option.click();
			Break(); */
		
			
		List<WebElement> options =driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));

		for(WebElement option :options)

		{

		if(option.getText().equalsIgnoreCase("India"))

		{

		option.click();

		break;

		}

		}
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		
		driver.findElement(By.xpath("//a[@value='MAA']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='DEL']")).click();
		
		driver.findElement(By.cssSelector("a.ui-state-default.ui-state-highlight.ui-state-hover")).click();
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5"))
		{
			System.out.println("it's disabled");
			//Assert.isTrue(expression, errorMessageFormat, args)
		}
		else 
		{
			//Assert.assertTrue(false);
			System.out.println("It's enabled");


		}

	}

}
