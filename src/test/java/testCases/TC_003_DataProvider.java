package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccount;
import testBase.BaseClassTest;
import utilities.DataProviders;

public class TC_003_DataProvider extends BaseClassTest{

	@Test(dataProvider="loginData",dataProviderClass=DataProviders.class)
	public void dastaProviderTest(String email, String pwd, String exp) 
	{
		logger.info("************** Start the tset*************");
		try {
		HomePage hp=new HomePage(driver);
		hp.clickmyAccout();
		hp.clickLogin();
		
		LoginPage lp= new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.setLogin();
		
		
		MyAccount macc= new MyAccount(driver);
		boolean massege= macc.gettheExistM();
		if (exp.equals("Valid")) {
			if (massege== true) {
				macc.setlogout();
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
			}
		}

		if (exp.equals("Invalid")) {
			if (massege == true) {
			
				macc.setlogout();
				Assert.assertTrue(false);
			} else {
				Assert.assertTrue(true);
			}
		}

	} catch (Exception e) {
		Assert.fail();
	}

	logger.info(" Finished TC_003_LoginDataDrivenTest");

}

}