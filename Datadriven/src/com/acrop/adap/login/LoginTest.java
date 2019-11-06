package com.acrop.adap.login;

import java.io.IOException;
import java.util.ArrayList;
import com.acorp.adap.dto.User;
import com.acorp.adap.util.ExcelReader;
//import com.acorp.adap.util.ScreenShotDemo;
import com.acorp.adap.util.ExcelWriter;


public class LoginTest {

public static void main(String[] args) throws InterruptedException {
 
   
	// TODO Auto-generated method stub
			//WebDriver driver = new ChromeDriver();
			//driver.findElement(By.id("")).sendKeys(String.valueOf(9999.20));
	 try {
		  int sheetNumber = 0;
		  ArrayList<User> users = ExcelReader.readXLS(sheetNumber);
		  System.out.println("After Read XLS "+users);
		  //for(int i = 1; i<users.size();i++)
		  for(int i = 1; i<users.size(); i++) {
		   Boolean val = UserIdPws.getCredential(users.get(i).getUserid(), users.get(i).getPassword());
		   
		   if(val)
		    {
		        System.out.println("Login Sucessfull");
		        users.get(i).setStatus("Pass");
		        
		    }
		    else
		    {
		        System.out.println("Login Failed");
		        users.get(i).setStatus("Fail");
		        
		    }
		  }  
		 System.out.println("Users are "+users);  // users.toString()
		 ArrayList<User> wusers = ExcelWriter.writeToXLS(sheetNumber, users);
		 
		 System.out.println("After Write XLS "+wusers);
		 } catch (IOException e) {
		  // TODO Auto-generated catch block
		  e.printStackTrace();
		 }
	   
		//Thread.sleep(5000);
		//driver.quit();
		}
}
