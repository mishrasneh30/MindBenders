package TaskTest.TaskTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class SeleniumMethods {

	private WebElement getWebElement(WebDriver driver, String elementValue) {
		//driver= setupobj.getdriver();
		WebElement webElement = null;
		if(elementValue.startsWith("id")) {
			webElement= driver.findElement(By.id(elementValue));
		}
		else if(elementValue.startsWith("classname")) {
			webElement= driver.findElement(By.className(elementValue));
		}
		else if(elementValue.startsWith("tagname")) {
			webElement= driver.findElement(By.tagName(elementValue));
		}
		else if(elementValue.startsWith("css")) {
			webElement=  driver.findElement(By.cssSelector(elementValue));
		}
		else if(elementValue.startsWith("xpath") || elementValue.startsWith("//")) {
			webElement= driver.findElement(By.xpath(elementValue));
		}
		else {
			Assert.fail();
		}
		return webElement;
	}
	
	public void ClickToElement(WebDriver driver, String elementValue) {
		try {
			getWebElement(driver, elementValue).click();
		}
		catch(Exception e) {
			Assert.fail();
		}
	}
	
	
	public void PassKeyToElement(WebDriver driver, String elementValue, String key) {
		try {
			getWebElement(driver, elementValue).sendKeys(key);
		}
		catch(Exception e) {
			Assert.fail();
		}
	}
}
