package com.webmail.keywords;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.webmail.keyword.base.Base;

public class MyKeywords {

	public WebDriver driver;
	public Properties pro;
	public  Sheet sheet;
	public Workbook book;
	//public Xls_Reader reader;

	public final String sheet_Path_Name = "C:/Users/pdesire/workspace/webmail/src/main/java/com/webmail/keywords/login.xlsx";

	public Base base;
	public WebElement element;
	public void ExecutionStarts(String SheetName){
		 String locatorName = null;
		 String locatorValue = null;
		 FileInputStream file = null;
		try {
			file = new FileInputStream(sheet_Path_Name);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		sheet = book.getSheet(SheetName);
		int k = 0;

       
		for (int i=0;i<sheet.getLastRowNum(); i++){
			 try{
			String locatorColValue = sheet.getRow(i+1).getCell(k+1).toString().trim();
			if(!locatorColValue.equals("NA")){
				locatorName = locatorColValue.split("=")[0]; //this for id/xpath
				locatorValue = locatorColValue.split("=")[1]; //this is for username/next/password 

			}
			String action = sheet.getRow(i+1).getCell(k+2).toString().trim();
			String value = sheet.getRow(i+1).getCell(k+3).toString().trim();

			switch (action) {
			case "openBrowser":
				base.int_prop();
				if(value.isEmpty() || value.equals("NA")){
					base.brow_int(pro.getProperty("browser"));
				}
				else{
					base.brow_int(value);
				}
				break;

			case "enterUrl":
				if(value.isEmpty() || value.equals("NA")){
					driver.get(pro.getProperty("url"));
				}
				else{
					driver.get(value);
				}
			case "quit":
				driver.quit();

			default:
				break;
			}

			switch (locatorName) {
			case "id":
				element = driver.findElement(By.id(locatorValue));
				if(action.equalsIgnoreCase("sendKeys")){
					element.clear();
					element.sendKeys(value);
				}else if(action.equalsIgnoreCase("click")){
					element.click();
				}
				locatorName = null;
				break;
			case "xapth":
				element = driver.findElement(By.xpath(locatorValue));
				if(action.equalsIgnoreCase("click")){
					element.click();
				}
				locatorName = null;
				break;
			default:
				break;
			}}
		
        catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        	

        	
		}
	}
}



	


