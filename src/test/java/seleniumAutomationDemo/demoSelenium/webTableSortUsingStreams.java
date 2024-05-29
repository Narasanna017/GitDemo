package seleniumAutomationDemo.demoSelenium;
import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class webTableSortUsingStreams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		//click on the column
		driver.findElement(By.xpath("//tr/th[1]")).click();
		//Capture all web elements into list
		List<WebElement> elementsList= driver.findElements(By.xpath("/tr/td[1]"));
		//capture text of all web elements into new orginal list
		List<String> orginalList = elementsList.stream().map(s->s.getText()).collect(Collectors.toList());
		//sort on the original list
		List<String> sortedList = orginalList.stream().sorted().collect(Collectors.toList());
		//compare orginalList and sortedList
		 Assert.assertTrue(orginalList.equals(sortedList));
		//scan the name column with getText / with select Beans
		 List<String> price;
		 do {
			 List<WebElement> rows= driver.findElements(By.xpath("/tr/td[1]"));
		  price = rows.stream().filter(s->s.getText().contains("Rice")).map(s->getVegPrice(s)).collect(Collectors.toList());
		 price.forEach(a->System.out.println(a))
		 
		 if (price.size()<1) 
		 {
			driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
		 }
	} while (price.size()<1);
		 
	}
	private static   String getVegPrice(WebElement s) {
		String priceValue=s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return priceValue;
	}
}
