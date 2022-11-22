package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObject.AccountRegestration;
import pageObject.HomePage;
import testBase.BaseClassTest;

public class TC_001AccountRegistrationRunner extends BaseClassTest{


	@Test(groups={"Regression","Master"})
	void test_account_registration() 
	{
		logger.info("Starting tc_AccountRegistration Test");
		try {
		HomePage ph=new HomePage(driver);
		ph.clickmyAccout();
		logger.info("Click on My Account link");
		
		ph.clickToRegster();
		logger.info("Click on Register link");
		
		AccountRegestration reg=new AccountRegestration(driver);
		logger.info("Provide Customer Data");
		
		reg.setFirstName(randomString().toUpperCase());
		reg.setLastName(randomString().toUpperCase());
		reg.setEmail(randomString()+"@gmail.com");
		reg.setPhoneNumber(randomNum());
		String password= randomStringAndNumber();
		reg.setPassword(password);
		reg.setconformpwd(password);
		reg.setSubscribe();
		reg.setPrivacy();
		
		reg.setContunue();
		logger.info("Click on Continue!!!!!!");
		
		String massege=reg.setMassege();
		logger.info("Validatu=ing Expected Massage!");
		
		Assert.assertEquals(massege, "Your Account Has Been Created!","Not getting expected massege");
		}
		catch (Exception e) 
		{
			logger.info("Test Failed");
			Assert.fail();		
			}
		logger.info("Fanished logging test TC_001AccountRegistrationRunner");
	}
	

}
