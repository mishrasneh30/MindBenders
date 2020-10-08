package TaskTest.TaskTest;

	import org.openqa.selenium.*;
	import org.openqa.selenium.NoSuchElementException;
	import org.openqa.selenium.support.ui.*;
//import org.testng.Assert;

	import java.util.*;
	import java.util.concurrent.TimeUnit;
	
	public class Default_Methods {
		
	    final int MAX_TIMEOUT = 120;
	    final int POLLING_TIME = 3;

	    /**
	     * Function name    : sendKeys | Input  : element,KeysToSend | Output  : Null
	     * Description      : To enter string value inside the web element
	     */
	    public void sendKeys(WebElement elem, String keysToSend, WebDriver driver) {
	        try {
	            waitForWebElementToLoad(elem, driver);
	            elem.clear();
	            elem.sendKeys(keysToSend);
	        } catch (Exception e) {
	            //Assert.fail("Can't able to send the values: " + e.getMessage());
	        }
	    }

	    /**
	     * Function name    : sendkeysByCharacter 
	     * Description      : To enter text by character
	     */
	    public void sendKeysByChar(String s, WebElement element) {
	        char[] ch = s.toCharArray();
	        for (char cha : ch) {

	        }
	    }

	    /**
	     * Function name    : isDisplayed
	     * Description      : To validate whether the web element is displayed or not in the web page
	     */
	    private Boolean isDisplayed(WebElement elm) {
	        boolean elementExist = true;
	        try {
	            elm.isDisplayed();
	        } catch (Exception e) {
	            System.err.println("Element not exist on screen :" + e);
	            elementExist = false;
	        }
	        return elementExist;
	    }


	    /**
	     * Function name    : waitVisible
	     * Description      : To command the driver to wait until the expected condition is met
	     */
	    public void waitVisible(WebElement elem,WebDriver driver) {
	        try {
	            WebDriverWait wait = new WebDriverWait(driver, 60);
	            wait.until(ExpectedConditions.visibilityOf(elem));
	        } catch (Exception e) {
	            //Assert.fail("Element not visible" + e.getMessage());
	        }
	    }

	    /**
	     * Function name    : waitForTextToBeAppearInElementValue 
	     * Description      : Wait till the expected text appear in the field
	     */
	    public void waitForTextToBeAppearInElementValue(WebElement element, String expectedText, WebDriver driver) {
	        WebDriverWait wait = new WebDriverWait(driver, 20);
	        wait.until(ExpectedConditions.textToBePresentInElementValue(element, expectedText));
	    }

	    /**
	     * Function name    : waitForTextToDisappear
	     * Description      : Wait till the expected text to be disappear in the field
	     */
	    public void waitForTextToDisappear(By textElement, String actualText, WebDriver driver) {
	        WebDriverWait wait = new WebDriverWait(driver, 60);
	        wait.until(ExpectedConditions.invisibilityOfElementWithText(textElement, actualText));
	    }

	    /**
	     * Function name    : getText 
	     * Description      : To fetch the text from the web element and return the same
	     */
	    public String getText(WebElement elem,WebDriver driver) {
	        try {
	            waitVisible(elem, driver);
	        } catch (Exception e) {
	            //Assert.fail("Unable to get text from element" + e.getMessage());
	        }
	        return elem.getText();
	    }

	    /**
	     * Function name    : assertContains
	     * Description      : To assert the actual web element contains expected text
	     */
	    public void assertContains(WebElement elem, String text, WebDriver driver) {
	        try {
	            waitVisible(elem, driver);
	            if (elem.getText().contains(text)) {
	                System.out.println(
	                        "Text is populated in the Element: " + text + " ||actual|| " + elem.getText());
	            } else {
	                //Assert.fail(elem.getText() + " text does not contain " + text);
	            }
	        } catch (Exception e) {
	            //Assert.fail("Error in accessing Text : " + e.getMessage());
	        }
	    }

	    /**
	     * Function name    : assertEquals
	     * Description      : To check text present in WebElement
	     */
	    public void assertEquals(WebElement elem, String text, WebDriver driver) {
	        try {
	            waitVisible(elem, driver);
	            if (elem.getText().equalsIgnoreCase(text)) {
	                System.out.println(
	                        "Text is populated in the Element: " + text + " ||actual|| " + elem.getText());
	            } else {
	                //Assert.fail(elem.getText() + " text does not contain " + text);
	            }
	        } catch (Exception e) {
	            //Assert.fail("Error in accessing Text : " + e.getMessage());
	        }
	    }


	    /**
	     * Function name    : execScripts_click
	     * Description      : To click WebElement using Javascript
	     */
	    public void execScripts_click(WebElement element, WebDriver driver) {
	        try {
	            JavascriptExecutor executor = (JavascriptExecutor) driver;
	            executor.executeScript("arguments[0].click();", element);
	        } catch (Exception e) {
	            //Assert.fail("Error in clicking a webelement using javascript : " + e.getMessage());
	        }
	    }

	    /**
	     * Function name    : click
	     * Description      : To click WebElement
	     */
	    public void click(WebElement element, WebDriver driver) {
	        try {
	            scrollToElement(element, driver);
	            WebElement el = (new WebDriverWait(driver, 60)).until(ExpectedConditions.elementToBeClickable(element));
	            el.click();
	        } catch (Exception e) {
	        	//Assert.fail("Error in clicking a webelement : " + e.getMessage());
	        }
	    }

	    /**
	     * Function name    : scrolling to the webelement
	     * Description      : scrolling till the WebElement using Javascript
	     */
	    public void scrollToElement(WebElement element, WebDriver driver) {
	        try {
	            JavascriptExecutor js = (JavascriptExecutor) driver;
	            js.executeScript("arguments[0].scrollIntoView();", element);
	        } catch (Exception e) {
	            System.err.println("Error in scrolling till the webelement using javascript : " + e.getMessage());
	        }
	    }

	    /**
	     * Function name    : Dropdown select by value
	     * Description      : Select element from dropdown using value
	     */
	    public void dropdownSelectByValue(WebElement elem, String value) {
	        try {
	            Select selection = new Select(elem);
	            selection.selectByValue(value);
	        } catch (Exception e) {
	            //Assert.fail("Error in selecting value in drop down: " + e.getMessage());
	        }
	    }

	    /**
	     *  Function name    : dropdownSelectByText
	     *  Description      : select the value form dropdown using visible text
	     */
	    public void dropdownSelectByText(WebElement elem, String value, WebDriver driver) {
	        try {
	            waitForWebElementToLoad(elem, driver);
	            Select selection = new Select(elem);
	            selection.selectByVisibleText(value);
	        } catch (Exception e) {
	            //Assert.fail("Error in selecting value in drop down: " + e.getMessage());
	        }
	    }

	    public WebElement waitForWebElementToLoad(WebElement ele, WebDriver driver) { // MAX 2 Min wait
	        Wait<WebDriver> wait = fluentWait(MAX_TIMEOUT, POLLING_TIME, driver);
	        return wait.until(ExpectedConditions.visibilityOf(ele));
	    }

	    public List<WebElement> waitForWebElementsToLoad(List<WebElement> ele, WebDriver driver) { // MAX 2 Min wait
	        WebDriverWait wait = new WebDriverWait(driver, 30);
	        return wait.until(ExpectedConditions.visibilityOfAllElements(ele));
	    }

	    public Wait<WebDriver> fluentWait(int timeoutTime, int pollingTime,WebDriver driver) {
	        return new FluentWait(driver).withTimeout(timeoutTime, TimeUnit.SECONDS)
	                .pollingEvery(pollingTime, TimeUnit.SECONDS).ignoring(NoSuchElementException.class)
	                .ignoring(StaleElementReferenceException.class);
	    }

	    public boolean isElementExist(WebElement elm) {
	        return isDisplayed(elm);
	    }

	    public Boolean isElementsExist(List<WebElement> elm) {
	        if (elm.size() == 0) {
	            return false;
	        } else {
	            return isDisplayed(elm.get(0));
	        }
	    }

	    public void sleep(int sec) {
	        try {
	            Thread.sleep(sec * 1000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }

	    public boolean isEnabled(WebElement ele, WebDriver driver) {

	        try {
	            WebElement element = (new WebDriverWait(driver, 60)).until(ExpectedConditions.elementToBeClickable(ele));
	            return element.isEnabled();
	        } catch (Exception e) {
	            return false;
	        }

	    }
	  
	    public void implicit_wait(int sec, WebDriver driver) {
	        driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
	    }
}