package com.acrop.adap.login;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.acorp.adap.dto.User;
import com.acorp.adap.util.BundleReader;
import com.acorp.adap.util.ScreenShotDemo;

public class UserIdPws {
	public static Boolean getCredential(String Userid, String Password) {
		  WebDriver driver;
		 System.setProperty(BundleReader.getValue("drivername"), BundleReader.getValue("driverpath"));
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get(BundleReader.getValue("url"));
		 Controls.userSelection("MSDH", driver);
		// Passing of Userid and Password on Login Page and Click on Login button  
		 Controls.textbox("txtLoginID", Userid, driver);
		 Controls.textbox("txtPassword", Password, driver);
		 Controls.onClick("btnSignIn", driver);
		 //Controls.programname("prog_name", driver);
	//	String text= driver.findElement(By.id("user-name")).getText();
	   // boolean val = text.startsWith("HELLO");
		
		
		boolean val = driver.getPageSource().contains("Mississippi State Department of Health");
		// driver.close(); 
		
		 
		 try {
		  Thread.sleep(5000);
		 } catch (InterruptedException e) {
		  // TODO Auto-generated catch block
		  e.printStackTrace();
		 }
		try {
				ScreenShotDemo.takeScreenShot(driver);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		 
		
		 //Controls.popup(getElementById("dvAttention").style.display="none", driver);
		 
		 return val;
}

}
