package com.acorp.adap.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

import com.acorp.adap.dto.User;

public class ExcelReader {
	
	public static ArrayList<User> readXLS(int sheetNumber) throws IOException {
		ArrayList<User> users = new ArrayList<>();
		String filePath = BundleReader.getValue("xlspath");
		File file = new File(filePath);
		if(!file.exists()) {
			System.out.println("Invalid Path , File Not Exist");
			return null;
		}
		FileInputStream fs = new FileInputStream(file);
		//XSSFWorkbook
		// xls
		@SuppressWarnings("resource")
		HSSFWorkbook workBook = new HSSFWorkbook(fs);
		HSSFSheet workSheet =  workBook.getSheetAt(sheetNumber);
		Iterator<Row> rows = workSheet.rowIterator();
		int cellCounter = 0;
		while(rows.hasNext()) {
			Row row = rows.next();
			User user = new User();
			Iterator<Cell> cells = row.cellIterator();
			cellCounter=1;
			while(cells.hasNext()) {
				Cell cell = cells.next();
				if(cell.getCellType()== CellType.STRING) {
					String value = cell.getStringCellValue();
					switch(cellCounter) {
					case 1:
						user.setUserid(value);
						break;
					case 2:
						user.setPassword(value);
						break;
					case 3:
						user.setStatus(value);
						break;
					}
					
				}
				else
					   if(cell.getCellType()==CellType.NUMERIC) {
					    double val = cell.getNumericCellValue();
					   
					    int value  = (int) val;
					    System.out.println("Val is "+value);
					    if(cellCounter==2) {
					     user.setPassword(String.valueOf(value));
					    }
					   }
				cellCounter++;
			} // Cell Loop ends
			users.add(user);
		} // Row Loop Endss
		return users;
	}

}
