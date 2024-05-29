package seleniumAutomationDemo.demoSelenium;
import javax.swing.plaf.synth.SynthOptionPaneUI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.service.DriverFinder;

public class Locators {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("narasannagoud");
		driver.findElement(By.name("inputPassword")).sendKeys("rahulshetty");
		driver.findElement(By.cssSelector("input#chkboxTwo")).click();
		driver.findElement(By.cssSelector("button.submit.signInBtn")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//p[@class='error']")).getText());
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("narsii");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("narsii017@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("9876543210");
		driver.findElement(By.cssSelector("div button:nth-child(2)")).click();
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());

		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
	}

}
