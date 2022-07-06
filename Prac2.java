package org.prac;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Prac2 extends BaseClass {
	public static void main(String[] args) throws InterruptedException {
		LaunchBrowser("chrome");
		launchUrl("https://adactinhotelapp.com/");
		driver.manage().window().maximize();
		WebElement username = driver.findElement(By.id("username"));
		fillValue(username, "nishanthrambo");
		WebElement password = driver.findElement(By.id("password"));
		fillValue(password, "Rambo@2022");
		WebElement login = driver.findElement(By.id("login"));
		clickBtn(login);
		WebElement location = driver.findElement(By.id("location"));
		Drpdown(location, 1);
		WebElement hotel = driver.findElement(By.id("hotels"));
		Drpdown(hotel, 2);
		WebElement roomtype = driver.findElement(By.id("room_type"));
		Drpdown(roomtype, 4);
		WebElement roomcnt = driver.findElement(By.id("room_nos"));
		Drpdown(roomcnt, 10);
		Thread.sleep(3000);

		WebElement date = driver.findElement(By.id("datepick_in"));
		date.clear();
		fillValue(date, "30/05/2022");
		WebElement dateOut = driver.findElement(By.id("datepick_out"));
		dateOut.clear();
		fillValue(dateOut, "31/05/2022");
		WebElement roomcap = driver.findElement(By.id("adult_room"));
		Drpdown(roomcap, 1);
		WebElement childroom = driver.findElement(By.id("child_room"));
		Drpdown(childroom, 1);
		WebElement searchBtn = driver.findElement(By.id("Submit"));
		clickBtn(searchBtn);
	}

}
