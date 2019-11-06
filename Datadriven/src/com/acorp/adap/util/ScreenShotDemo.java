package com.acorp.adap.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public interface ScreenShotDemo {
 public static void takeScreenShot(WebDriver driver) throws Exception{
	 TakesScreenshot scrShot =((TakesScreenshot)driver);
	 File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
	// Date date = new Date();
	 //String path ="/Users/amit/Documents/testsc/a"+date.getTime()+".jpg";
	String path = "D:\\Neetu\\Result\\Test"+System.currentTimeMillis()+".jpg";
	 File DestFile=new File(path);
	 FileInputStream fi = new FileInputStream(SrcFile);
	 FileOutputStream fo = new FileOutputStream(DestFile);
	 fo.write(fi.readAllBytes());
	 fi.close();
	 fo.close();
	 MailSender.sendMail(path);
	 System.out.println("Done");
	 
	 
	 
 }
}
