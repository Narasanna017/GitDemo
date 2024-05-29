package seleniumAutomationDemo.demoSelenium;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class chromeOptions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
	
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://expired.badssl.com");
		driver.getTitle();
	}

}
