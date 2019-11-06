package com.acrop.adap.login;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Controls {

public static void userSelection(String value, WebDriver driver) {
	WebElement val = driver.findElement(By.linkText(value));
	val.click();
}

public static void programname(String value, WebDriver driver) {
	WebElement val = driver.findElement(By.className(value));
	if (val !=null) {
		val.click();
	}
	
}

public static void popup(String value, WebDriver driver) {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	//js.executeScript("document.getElementById('dvAttention').style.display='none'");
	js.executeScript("document.value");
}

public static void dropDown(String id, String value, WebDriver driver){
 
 WebElement val = driver.findElement(By.id(id));
 Select select = new Select(val);
 select.selectByVisibleText(value);
}

public static void textbox(String id, String value, WebDriver driver) {
 WebElement val = driver.findElement(By.id(id));
 System.out.println("String "+value);
 val.sendKeys(""+value);
}


public static void onClick(String id,  WebDriver driver) {
 WebElement val = driver.findElement(By.id(id));
 val.click();
}
}