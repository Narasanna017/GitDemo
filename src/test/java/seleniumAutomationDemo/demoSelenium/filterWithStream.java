package seleniumAutomationDemo.demoSelenium;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class filterWithStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//input[@id='search-field']")).sendKeys("Rice");
		List<WebElement> veggies=driver.findElements(By.xpath("//tr/td[1]"));
		List<WebElement> filteredList=veggies.stream().filter(s->s.getText().contains("Rice")).collect(Collectors.toList());
		Assert.assertEquals(veggies.size(),filteredList.size());;
		System.out.println(filteredList);
		driver.quit();
	}

}
