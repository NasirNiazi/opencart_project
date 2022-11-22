package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;  //loggin
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.*;


public class BaseClassTest {
	public static WebDriver driver;
	public Logger logger;  //for logging
	public ResourceBundle rb;
	@BeforeClass(groups={"Sanity","Regression","Master"})
	@Parameters ("browser")
	public  void setup(String br)
	{ 
	rb=ResourceBundle.getBundle("config"); // load config propertiees file
	logger=LogManager.getLogger(this.getClass());
    if(br.equals("chrome")) 
    {
    	 driver=new ChromeDriver();
    }else if(br.equals("edge")) 
    {
    	 driver=new EdgeDriver();
    	 
    }else 
    {
    	 driver=new FirefoxDriver();
     }
     
     driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	//driver.get("http://tek-school.com/retail/");
	driver.get(rb.getString("appURL"));
	driver.manage().window().maximize();
		
	}
	@AfterClass(groups= {"Master","Sanity","Regression"})
	 void tearDown () 
	{
		driver.quit();
	}
	
	public String randomString() 
	{
		String random=RandomStringUtils.randomAlphabetic(4);
		return (random);
	}
	public String randomNum() {
		String number=RandomStringUtils.randomNumeric(5);
		return (number);
	}
	public String randomStringAndNumber() {
		String str=RandomStringUtils.randomAlphabetic(4);
		String num= RandomStringUtils.randomNumeric(5);
		return (str+"@"+num);
	}
	public String captureScreen(String tname )throws IOException{
//		SimpleDateFormat df = new SimpleDateFormat("yyyymmddhhmmss");
//		Date dt = new Date();
//		String timestam=df.format(dt);	
		
		String timeStamp=new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
		
		TakesScreenshot takeScreenShot=(TakesScreenshot)driver;
		File source=takeScreenShot.getScreenshotAs(OutputType.FILE);
		
		String destanition=System.getProperty("user.dir")+"//screenShots//"+tname+"_"+timeStamp+".png";
		try {
			FileUtils.copyFile(source, new File (destanition));
		
		}catch (Exception e) {
			
			e.getMessage();
		}
		return destanition;
	}
	

}
