package TaskTest.TaskTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import  TaskTest.TaskTest.Default_Methods;

public class LoginPage extends Default_Methods {

	
	public LoginPage(WebDriver driver) {		 
		PageFactory.initElements(driver, this);		
	}

	@FindBy(how = How.ID, using = "User_Name")
	private WebElement emailTextElement;
	
	@FindBy(how = How.ID, using = "Password")
	private WebElement passwordTextElement;
	
	@FindBy(how = How.ID, using = "Login_Button")
	private WebElement LoginBtnElement;
	
	public void typeEmail(WebDriver driver,String email) {
		sendKeys(emailTextElement, email, driver);
	}
	
	public void typePassword(WebDriver driver,String pass) {
		sendKeys(passwordTextElement, pass, driver);
	}
	
	public void clickOnLoginBtn(WebDriver driver) {
		click(LoginBtnElement, driver);
	}
}
