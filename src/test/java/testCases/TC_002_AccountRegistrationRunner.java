package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccount;
import testBase.BaseClassTest;

public class TC_002_AccountRegistrationRunner extends BaseClassTest{
	@Test(groups= {"sanity","Master"})
	public void tc_002_Login() 
	{
		try {
			logger.info("trat Testitng TC_002_AccountRegistrationRunner ");
		HomePage ph= new HomePage(driver);
		ph.clickmyAccout();
		ph.clickLogin();
		
		LoginPage pg=new LoginPage(driver);
		pg.setEmail(rb.getString("email"));
		pg.setPassword(rb.getString("password"));
		pg.setLogin();
		
		MyAccount macc=new MyAccount(driver);
		boolean target=macc.gettheExistM();
		Assert.assertEquals(target, true,"involid login data");
		}catch(Exception e) 
		{
			Assert.fail();
		}
		logger.info("Fanished Testing TC_002_AccountRegistrationRunner ");
	}

}
