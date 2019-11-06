package com.acorp.adap.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.openqa.selenium.WebDriver;

import com.acorp.adap.dto.User;

public class ExcelWriter {
	@SuppressWarnings("null")
	public static ArrayList<User> writeToXLS(int sheetNumber, ArrayList<User> users) throws IOException {
		 String filePath = BundleReader.getValue("xlspath");
		 File file = new File(filePath);
		 if(!file.exists()) {
		  System.out.println("Invalid Path , File Not Exist");
		 }
		 
		 FileInputStream fs =new FileInputStream(file);
		 HSSFWorkbook workBook = new HSSFWorkbook(fs);
		 HSSFSheet workSheet =  workBook.getSheetAt(sheetNumber);
		 Cell cell = null;
		 HSSFRow row = workSheet.getRow(2);
		 CellStyle style1 = workBook.createCellStyle();  
		 CellStyle style2 = workBook.createCellStyle();  
		 
		 for(int i=1;i<users.size();i++) {
		cell = workSheet.getRow(i).getCell(2);
		  System.out.println("Status: "+users.get(i).getStatus());
		   if(users.get(i).getStatus() != null) {
			   if(users.get(i).getStatus().equals("Pass") == true) {
				  //System.out.println(cell.setCellValue(users.get(i).getStatus()));
				 // String ss = users.get(i).getStatus();
				  cell.setCellValue(users.get(i).getStatus());
				  style1.setFillForegroundColor(IndexedColors.GREEN.getIndex());  
				  style1.setFillPattern(FillPatternType.SOLID_FOREGROUND);  
				   //style.setFillBackgroundColor(IndexedColors.GREEN.getIndex());
				   cell.setCellStyle(style1);  
			  }
			   else {
				   cell.setCellValue(users.get(i).getStatus());
				   style2.setFillForegroundColor(IndexedColors.RED.getIndex());  
				   style2.setFillPattern(FillPatternType.SOLID_FOREGROUND); 
				   //style.setFillBackgroundColor(IndexedColors.RED.getIndex());  
				   cell.setCellStyle(style2);  
				  }
		  }
		 }
		 
		 fs.close();
		 
		 FileOutputStream fo=new FileOutputStream(file);
		 workBook.write(fo);
		 fo.close();
		return users;
		 
		}
		}

