package TaskTest.TaskTest;

import org.openqa.selenium.WebDriver;

public class LoginSteps {

	static LoginPage loginPage;
	
	public static void loginOnYesPls(WebDriver driver, String email, String pass) {
		loginPage=new LoginPage(driver);
		loginPage.typeEmail(driver, email);
		loginPage.typePassword(driver, pass);
		loginPage.clickOnLoginBtn(driver);
	}

}
