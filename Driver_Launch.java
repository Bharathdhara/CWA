package Basic;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Driver_Launch {
	
	public static WebDriver driver;
	
	public static String browser = "FF";
	
	
	
	public  static void Launch_browser() {
		
		if (browser.equals("GC")) {
			
			driver=new ChromeDriver();
		}
		
		else if (browser.equals("FF")) {
			
			driver=new FirefoxDriver();
		}
		else if (browser.equals("Edge")) {
			
			driver=new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.manage().deleteAllCookies();
		
	}
	
	
	
	public static void Close_window() throws Exception {
		
		Thread.sleep(3000);
		driver.quit();
	}
	

}
