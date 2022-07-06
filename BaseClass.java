package org.prac;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	static Actions a;
	static Robot r;

	
		public static void LaunchBrowser(String browserName) {
					if (browserName.equals("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
			} else if (browserName.equals("Firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
			}
			else if (browserName.equals("edge")) {
				WebDriverManager.edgedriver().setup();
				driver=new EdgeDriver();	
			}	
			 
			}
			public static void launchUrl(String url) {
			driver.get(url);
			}
		public static void fillValue(WebElement e, String value)	{
			e.sendKeys(value);
	}
		public static void clickBtn(WebElement e)	{
			e.click();
	}
		public static void Drpdown(WebElement e, int number)	{
			Select s= new Select(e);
			s.selectByIndex(number);
			
		}
		public static void doubleclickBtn(WebElement e)	{
			a=new Actions(driver);
			a.doubleClick(e).perform();
	}
		public static void rightclickBtn(WebElement e)	{
			a.contextClick(e).perform();
	}	
		public static void downbtn() throws AWTException	{
			r=new Robot();
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
		}
public static void enterBtn() {
	r.keyPress(KeyEvent.VK_ENTER);
	r.keyRelease(KeyEvent.VK_ENTER);
}
public static void tabBtn() {
	r.keyPress(KeyEvent.VK_TAB);
	r.keyRelease(KeyEvent.VK_TAB);
}
public static void pasteBtn() {
	r.keyPress(KeyEvent.VK_CONTROL);
	r.keyPress(KeyEvent.VK_V);
	r.keyRelease(KeyEvent.VK_CONTROL);
	r.keyRelease(KeyEvent.VK_V);
}
public static void selectAll() {
	r.keyPress(KeyEvent.VK_CONTROL);
	r.keyPress(KeyEvent.VK_A);
	r.keyRelease(KeyEvent.VK_CONTROL);
	r.keyRelease(KeyEvent.VK_A);
}


		
		
		
}