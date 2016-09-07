package com.Testsuites;

import com.Library.*;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.asserts.*;
import org.testng.*;

/*
 * Verify Login form
 */
public class Login {
	public WebDriver driver;
	@BeforeMethod
	public void init(){		
		System.setProperty("webdriver.chrome.driver",".//references//chromedriver.exe"); 
		driver=new ChromeDriver();    // this line launch chrome browser
//		driver.get("http://backend.gowow.mobi:6034/auth/login");
		driver.get("http://phptravels.net/");
	}
	/*
	 * Verify data when Home page loaded
	 */
	@Test(priority =0)
	public void FirstLoad(){
		try{		
			WebElement txtMenuHome = driver.findElement(By.xpath(".//*[@id='top']/div[1]/div/div/div[2]/ul/li[1]/a"));			
			org.testng.Assert.assertEquals(txtMenuHome.getText(), "Home");
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
	}
	
	@Test(priority =1)
	public void Login(){
		/*
		 * DECLARATION
		 */
		String txtMenuAccount = ".//*[@id='top']/div[1]/div/div/div[2]/ul/li[9]/a";
		String txtMenuLogin = ".//*[@id='top']/div[1]/div/div/div[2]/ul/li[9]/ul/li[1]/a";
		String txtLoginURL = "http://phptravels.net/login";
		String inputEmail = ".//*[@id='loginfrm']/div/div[3]/div/div[1]/input";
		String txtEmail = "user@phptravels.com";
		String inputPassword = ".//*[@id='loginfrm']/div/div[3]/div/div[2]/input";
		String txtPassword = "demouser";
		String btnLogin = ".//*[@id='loginfrm']/div/div[5]/div/div/div[1]/button";
		
		/*
		 * ACTIONS
		 */
		//Select [Account] menu
		WebElement eMenuAccountClick = driver.findElement(By.xpath(txtMenuAccount));
		eMenuAccountClick.click();	
		//Select [Login]
		WebElement eMenuLoginClick = driver.findElement(By.xpath(txtMenuLogin));
		eMenuLoginClick.click();	
		//Verify Login URL
		String URL = driver.getCurrentUrl();
		org.testng.Assert.assertEquals(URL, txtLoginURL);
		//Enter Email to login
		WebElement eEmail = driver.findElement(By.xpath(inputEmail));
		eEmail.sendKeys(new String[] {txtEmail});	
		//Enter Password to login
		WebElement ePassword = driver.findElement(By.xpath(inputPassword));
		ePassword.sendKeys(new String[] {txtPassword});	
		//Click on [Login] button
		WebElement eLogin = driver.findElement(By.xpath(btnLogin));
		eLogin.click();	
	}
	@AfterMethod
	public void afterMethod(){
		driver.quit();
	}
	
}
