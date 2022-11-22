package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegestration extends BasePage{
	
	
public AccountRegestration (WebDriver driver)
{
	super(driver);

  }

  By tex_firstName= By.id("input-firstname");
  By tex_lastName = By.id("input-lastname");
  By tex_email=  By.id("input-email");
  By tex_phoneNumber=By.id("input-telephone");
  By tex_pasword= By.id("input-password");
  By tex_conformPassword=By.id("input-confirm");
  By tex_subscribe=By.xpath("//input[@value='0']");
  By tex_privacy = By.xpath("//input[@type='checkbox']");
  By tex_continue=By.xpath("//input[@value='Continue']");
  @FindBy(xpath="//h1[text()='Your Account Has Been Created!']")
  WebElement gettitleMassege;
  
  
  public void setFirstName(String name) 
  {
	  driver.findElement(tex_firstName).sendKeys(name);
	  
  }
  public void setLastName(String lastName) 
  {
	  driver.findElement(tex_lastName).sendKeys(lastName);
  }
  public void setEmail(String email) 
  {
	  driver.findElement(tex_email).sendKeys(email);
  }
  public void setPhoneNumber(String phone)
  {
	  driver.findElement(tex_phoneNumber).sendKeys(phone);
  }
  public void setPassword(String password) 
  {
	  driver.findElement(tex_pasword).sendKeys(password);
  }
  public void setconformpwd(String pwd) 
  {
	  driver.findElement(tex_conformPassword).sendKeys(pwd);
  }
  public void setSubscribe() 
  {
	  driver.findElement(tex_subscribe).click();
  }
  public void setPrivacy() 
  {
	  driver.findElement(tex_privacy).click();
  }
  public void setContunue() 
  {
	  driver.findElement(tex_continue).click();
  }
  public String  setMassege() {
	  try {
	 return (gettitleMassege.getText());
  }
	catch(Exception e) {
		return(e.getMessage());
	}
	  }
}
