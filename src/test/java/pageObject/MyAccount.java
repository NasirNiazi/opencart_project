package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccount extends BasePage {

	public MyAccount (WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//h2[text()='My Account']")
	WebElement myAccount;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement logoutbutton;
	
	
	
	public boolean gettheExistM() 
	{
		try {
		return (myAccount.isDisplayed());
		}catch(Exception e) 
		{
			return (false);
		}
		
		
			}
	public void setlogout() 
	{
		logoutbutton.click();
	}
		
	}

