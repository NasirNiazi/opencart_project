package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	//DataProvider 1
	
	@DataProvider(name="loginData")
	
	public String [][]getdata() throws IOException
	{
		String path = ".\\testData\\Opencart_LoginData.xlsx";
		ExcelUtility xlutil= new ExcelUtility(path);
		int totlerow = xlutil.getRowCount("Sheet1");
		int totlecell= xlutil.getCellCount("Sheet1", 1);
		
	    String logindata[][]=new String [totlerow][totlecell];
	    for(int i=1;i<=totlerow;i++) 
	    {
	    for(int j=0;j<totlecell;j++) 
	    {
	    	logindata[i-1][j]=xlutil.getCellData("Sheet1", i, j);
	    }	
	    }
	    return logindata;
	}
	
	}
	
	//DataProvider 2
	
	//DataProvider 3
	
	//DataProvider 4

