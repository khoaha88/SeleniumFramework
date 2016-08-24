package com.Library;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Browsers {
	public static void  selectBrowser (String browser){
		WebDriver driver;
		if (browser == "ch"){
			System.setProperty("webdriver.chrome.driver",".//references//chromedriver.exe"); 
			driver=new ChromeDriver();    // this line launch chrome browser
			driver.manage().window().maximize();
			driver.get("http://backend.gowow.mobi:6034/auth/login");
		}
		else if (browser == "ff"){
			System.setProperty("webdriver.gecko.driver",".//references//geckodriver.exe"); 
			 
			    final FirefoxProfile firefoxProfile = new FirefoxProfile();
			    firefoxProfile.setPreference("xpinstall.signatures.required", false);
			    driver = new FirefoxDriver(firefoxProfile);
			
			driver.get("http://vnexpress.net");
		}
		else if (browser == "ed"){
			System.setProperty("webdriver.edge.driver",".//references//MicrosoftWebDriver.exe"); 
			driver=new EdgeDriver();    // this line launch Edge browser
			driver.get("http://vnexpress.net");
		}
		
	}
}
