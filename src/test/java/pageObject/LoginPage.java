package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	public LoginPage(WebDriver driver ) {
		super(driver);
		}

	@FindBy(id="input-email")
	WebElement email;
	
	@FindBy(id="input-password")
	WebElement password;
	
	@FindBy(css="input[value='Login']")
	WebElement login;
	
	
	
	public void setEmail(String em) 
	{
		email.sendKeys(em);
	}
	public void setPassword(String pwd) 
	{
		password.sendKeys(pwd);
	}
	public void setLogin() 
	{
		login.click();
	}
	
}
