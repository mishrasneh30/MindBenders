package TaskTest.TaskTest;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverClass {

	public static WebDriver driver;
	public static void launchDriver(String browserName, String url) {
		Path currentRelativePath = Paths.get("");
		String basePath = currentRelativePath.toAbsolutePath().toString();
		String testDataFile = basePath + File.separator + "Drivers" + File.separator;

		if(browserName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", testDataFile+"chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			
		}
		else if(browserName.equalsIgnoreCase("ff")){
			System.setProperty("webdriver.gekodriver.driver", "E:/UniTest/com.tartecosmetics/Lib/gekodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			
		}
		driver.navigate().to(url);
		driver.get(url);
	}
}
