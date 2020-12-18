
package PageObject;

import org.openqa.selenium.WebElement;

import base_class.*;;

public class LoginPage extends Test_class {

	public void Clickloginlink() {

		getlocator("login").click();
	}
	public String validateLoginScreen() {
		String LoggedInUser= getlocator("LogedInUser").getText();
		return LoggedInUser;
		
	}
	public void enterUserName(String Myusername) {
		WebElement username = getlocator("username");
		username.click();
		username.clear();
		username.sendKeys(Myusername);
	}

	public void enterPassword(String Mypassword) {
		WebElement password = getlocator("password");
		password.click();
		password.clear();
		password.sendKeys(Mypassword);
	}

	public void submitLogin() {
		getlocator("loginsubmit").click();

	}

}
