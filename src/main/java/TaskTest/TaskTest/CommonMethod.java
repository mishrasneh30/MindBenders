package TaskTest.TaskTest;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

//Ignore for this now
public class CommonMethod {

	public void sendkeys(RemoteWebDriver driver, String value, String type, String locator) {
		if(type.equalsIgnoreCase("id")) {
		    driver.findElement(By.id(locator)).sendKeys(value);
		}
		else if(type.equalsIgnoreCase("Name")) {
			driver.findElement(By.name(locator)).sendKeys(value);
		}
		else if(type.equalsIgnoreCase("classname")) {
			driver.findElement(By.className(locator)).sendKeys(value);
		}
		else if(type.equalsIgnoreCase("cssSelector")) {
			driver.findElement(By.cssSelector(locator)).sendKeys(value);
		}
		else if(type.equalsIgnoreCase("xpath")) {
			driver.findElement(By.xpath(locator)).sendKeys(value);
		}
	}
	
	public void click(RemoteWebDriver driver, String type, String locator) {
		if(type.equalsIgnoreCase("id")) {
		    driver.findElement(By.id(locator)).click();
		}
		else if(type.equalsIgnoreCase("Name")) {
			driver.findElement(By.name(locator)).click();
	
		}
		else if(type.equalsIgnoreCase("classname")) {
			driver.findElement(By.className(locator)).click();
		}
		else if(type.equalsIgnoreCase("cssSelector")) {
			driver.findElement(By.cssSelector(locator)).click();
		}
		else if(type.equalsIgnoreCase("xpath")) {
			driver.findElement(By.xpath(locator)).click();
		}
	}
}
