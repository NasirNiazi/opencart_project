package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage
{
public HomePage (WebDriver driver) 
{
	super(driver);
	}

    //Elements
    @FindBy(xpath="//span[text()='My Account']")
    WebElement linkMyAccount;
    
    @FindBy(linkText="Register")
    WebElement linkRegister;
    
    @FindBy(xpath="//a[text()='Login']")
    WebElement loginButton;
    
    //Actions
    public void clickmyAccout() 
    {
    	linkMyAccount.click();
    }
    public void clickToRegster() 
    {
    	linkRegister.click();
    }
    public void clickLogin() 
    {
    	loginButton.click();
    }
}
