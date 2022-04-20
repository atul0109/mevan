package com.selenium.salesforce2.xcx;

import java.io.FileInputStream;
import java.util.Properties;

import javax.management.ObjectName;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Keywords {
	WebDriver driver;
	FileInputStream fis;
	Properties prop;
	
	public void open() {
		System.setProperty("webdriver.chrome.driver", "D://Selenium//chromedriver.exe");
		driver =new ChromeDriver();
		try {
			fis = new FileInputStream("D:\\Java Programmes PSA\\salesforce\\src\\main\\java\\com\\salesforce\\base\\ObjectReposetory.properties");
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void url(String httpUrl) {
		driver.get(httpUrl);
	}

	public void input(String testdata, String object) {
		driver.findElement(By.xpath(prop.getProperty(object))).sendKeys(testdata);
	}

	public void click(String object) {
      driver.findElement(By.xpath (prop.getProperty(object))).click();		
	}

	public void closebrowser() {
		driver.close();
	}
}
