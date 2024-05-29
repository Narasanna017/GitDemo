package seleniumAutomationDemo.demoSelenium;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class actions {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		driver.findElement(By.cssSelector(".blinkingText")).click();
		Set<String> Windows = driver.getWindowHandles();
		Iterator<String> it = Windows.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
		
		String emailId = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
		System.out.println(emailId);
		driver.switchTo().window(parentId);
		driver.findElement(By.id("username")).sendKeys(emailId);
		driver.findElement(By.id("password")).sendKeys("learning");
		
		driver.findElement(By.cssSelector("input[value='user']")).click();
		//System.out.println(driver.switchTo().alert().getText());
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("button#okayBtn")).click();
		driver.findElement(By.cssSelector("select[class='form-control'] option[value='teach']")).click();
		driver.findElement(By.cssSelector("input#terms")).click();
		driver.findElement(By.id("signInBtn")).click();
		
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert.alert-danger")));
		System.out.println(driver.findElement(By.cssSelector(".alert.alert-danger")).getText());
		System.out.println(driver.findElement(By.cssSelector(".text-center.text-white")).getText());
		String credentialString = driver.findElement(By.cssSelector(".text-center.text-white")).getText().split("and")[1].trim();
		System.out.println(credentialString);
	}

}
