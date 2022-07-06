package org.prac;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class insta extends BaseClass {
public static void main(String[] args) throws InterruptedException {
	LaunchBrowser("chrome");
	launchUrl("https://www.instagram.com/");
	Thread.sleep(5000);
	WebElement username = driver.findElement(By.name("username"));
	fillValue(username, "nishanthrambo");
	WebElement password = driver.findElement(By.name("password"));
	fillValue(password, "Rambo@123");
	WebElement login = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div[3]/button"));
	login.click();
}
}
