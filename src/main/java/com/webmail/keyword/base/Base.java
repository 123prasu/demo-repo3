package com.webmail.keyword.base;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Base {

	public WebDriver driver;
	public Properties pro;

	public WebDriver brow_int(String browserName){
		if(browserName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver","D:/chromedriver_win32/webdriverchrome/chromedriver.exe");
			if(pro.getProperty("headless").equals("yes")){
				//headless mode
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless");
				driver = new ChromeDriver(options);
			}else{
				driver = new ChromeDriver();

			}}
		return driver;
	}
	public Properties int_prop(){
		//pro = new Properties();
		try {
			FileInputStream ip = new FileInputStream("C:/Users/pdesire/workspace/webmail/src/main/java/"
					+ "com/webmail/keyword/config/config.properties");
			pro.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pro;
		/*test project*/
	}

}
