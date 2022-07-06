package org.prac;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.Timer;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParentClass {
	public static final Timer TimeUnit = null;
	public static WebDriver driver;
	public static Actions a;
	public static Robot r;
	public static Alert a1;
	public static TakesScreenshot tk;
	public static JavascriptExecutor js;
	public static Select s;
	public static void launchBrowser() {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	}
	public static void loadUrl(String url) {
	driver.get(url);
	}
	public static void maximize() {
	driver.manage().window().maximize();
	}
	public static void pageTitle() {
	    String title = driver.getTitle();
	    System.out.println(title);
	}
	public static void pageUrl() {
	String currentUrl = driver.getCurrentUrl();
	System.out.println(currentUrl);
	}
	public static void fill(WebElement element,String userText) {
	element.sendKeys(userText);
	}
	public static void btnClick(WebElement element) {
	element.click();
	}
	public static String toGetAttribute(WebElement element) {
	String value = element.getAttribute("value");
	return value;

	}

	public static void toQuit() {
	driver.quit();
	}
	public static void toPerformMoveToElement(WebElement element) {
	a=new Actions(driver);
	a.moveToElement(element).perform();
	}
	public static void toPerformDragAndDrop(WebElement src ,WebElement dest) {
	a.dragAndDrop(src, dest).perform();
	}
	public static void toPerformDoubleClick(WebElement element) {
	a.doubleClick(element).perform();
	}
	public static void toPerformRightClick(WebElement element) {
	a.contextClick(element).perform();
	}
	public static void toPerformKeyUp(WebElement element,String key) {
	a.keyUp(element, key).build().perform();
	}
	public static void toPerformKeyDown(WebElement element,String key) {
	a.keyDown(element, key).build().perform();
	}
	public static void toPerformTab() throws AWTException {
	r=new Robot();
	r.keyPress(KeyEvent.VK_TAB);
	r.keyRelease(KeyEvent.VK_TAB);
	}
	public static void toPerformEnter() {
	r.keyPress(KeyEvent.VK_ENTER);
	r.keyRelease(KeyEvent.VK_ENTER);
	}
	public  static void toPerformKeyboardUp() {
	r.keyPress(KeyEvent.VK_UP);
	r.keyRelease(KeyEvent.VK_UP);
	}
	public static void toPerformKeyboardDown() {
	r.keyPress(KeyEvent.VK_DOWN);
	        r.keyRelease(KeyEvent.VK_DOWN);
	}
	public static void toPerformShift() {
	r.keyPress(KeyEvent.VK_SHIFT);
	r.keyRelease(KeyEvent.VK_SHIFT);
	}
	public static void toPerformCapsLock() {
	r.keyPress(KeyEvent.VK_CAPS_LOCK);
	r.keyRelease(KeyEvent.VK_CAPS_LOCK);
	}
	public static void toPerformAccept() {
	a1=driver.switchTo().alert();
	a1.accept();
	}
	public static void toPerformDismiss() {
	a1.dismiss();
	}
	public static void toPerformAlertSendkeys(String userText) {
	a1.sendKeys(userText);
	}
	public static void toPerformAlertGetText() {
	String text = a1.getText();
	System.out.println(text);
	}
	public static void takesScreenShot(String path) throws IOException{
	tk=(TakesScreenshot)driver;
	File src = tk.getScreenshotAs(OutputType.FILE);
	File dest = new File(path);
	FileUtils.copyFile(src, dest);
	}
	public static void toDebug(long millisec) throws InterruptedException {
	Thread.sleep(millisec);
	}
	public static void toScrollDown(WebElement pageDown) {
	js=(JavascriptExecutor)driver;
	js.executeAsyncScript("arguments[0].scrollIntoView(false)", pageDown);
	}
	public static void toScrollUp(WebElement pageUp) {
	js=(JavascriptExecutor)driver;
	js.executeAsyncScript("arguments[0].scrollIntoView(true)", pageUp);
	}
	public static void toGetSendkeys(WebElement userText) {
	js=(JavascriptExecutor)driver;
	js.executeAsyncScript("arguments[0].setAttribute('value','user Text')", userText);
	}
	public static void toGetAttributeValue(WebElement attribute) {
	js=(JavascriptExecutor)driver;
	js.executeAsyncScript("return arguments[0].getAttribute('value')", attribute);
	}
	public static void toGetClick(WebElement clk) {
	js.executeScript("arguments[0].click()",clk);
	}
	public static void toPerformFrameIndex(WebElement index) {
	driver.switchTo().frame(index);
	}
	public static void toPerformFrameNameorId(WebElement nameOrId) {
	   driver.switchTo().frame(nameOrId);
	}
	public static void toPerformFrameWebElement(WebElement frameElement) {
	driver.switchTo().frame(frameElement);
	}
	public static void toGetParentWindowId() {
	String parentId = driver.getWindowHandle();
	}
	public static void toGetAllWindowId() {
	Set<String> allWindowId = driver.getWindowHandles();
	}
	public static void toSwitchWindow(String name) {
	driver.switchTo().window(name);
	}
	public static void toPerformSelectByIndex(WebElement element,int index) {
	s=new Select(element);
	s.selectByIndex(index);
	}
	public static void toPerformSelectByVisibleText(String text) {
	s.selectByVisibleText(text);
	}
	public static void toPerformSelectByValue(String value) {
	s.selectByValue(value);
	}
	public static void toPerformIsMultiple() {
	boolean b = s.isMultiple();
	if (b==true) {
	System.out.println("Multiple options can be selected");
	} else {
	System.out.println("Multiple options cannot be selected");
	}
	}
	public static void toPerformOptions() {
	List<WebElement> options = s.getOptions();
	}
	public static void toPerformAllSelectedOptions() {
	List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
	}
	public static void toPerformFirstSelectedOption() {
	WebElement firstSelectedOption = s.getFirstSelectedOption();
	}
	public static void toPerformDeselectByIndex(int index) {
	s.deselectByIndex(index);
	}
	public static void toPerformDeselectByVisibleText(String text) {
	s.deselectByVisibleText(text);
	}
	public static void toPerformDeselectByValue(String value) {
	s.deselectByValue(value);
	}
	public static void toPerformDeselectAll() {
	s.deselectAll();
	}
	public static void toPerformImplicitWaits(long time) {
	driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	public static String excelRead(String path,int rowNo,int cellNo) throws IOException {
	File f=new File(path);
	FileInputStream fin=new FileInputStream(f);
	Workbook book =new XSSFWorkbook(fin);
	Sheet sh = book.getSheet("Sheet1");
	Row r = sh.getRow(rowNo);
	Cell c = r.getCell(cellNo);
	int cellType = c.getCellType();
	String value;
	if (cellType==1) {
	value = c.getStringCellValue();
	}
	else if (DateUtil.isCellDateFormatted(c)) {
	Date d = c.getDateCellValue();
	System.out.println(d);
	SimpleDateFormat sim=new SimpleDateFormat("dd-MMM-yyyy");
	value = sim.format(d);
	}
	else {
	double dd = c.getNumericCellValue();
	long l=(long)dd;
	   value = String.valueOf(l);
	}
	return value;
	}
	public static void toWriteInExcel(String path,int rowno,int cellno,String sheetname,String value) throws IOException {
	File f=new File(path);
	Workbook book=new XSSFWorkbook();
	Sheet sh = book.createSheet(sheetname);
	Row r = sh.createRow(rowno);
	Cell c = r.createCell(cellno);

	c.setCellValue(value);
	FileOutputStream fon=new FileOutputStream(f);
	book.write(fon);

	}
	public static void toAddCellInExcel(String path,String sheetname, int rowno,int cellno,String value) throws IOException {
	File f=new File(path);
	FileInputStream fin=new FileInputStream(f);
	Workbook book=new XSSFWorkbook(fin);
	Sheet sh = book.getSheet(sheetname);
	Row r = sh.getRow(rowno);
	Cell c = r.createCell(cellno);
	c.setCellValue(value);
	FileOutputStream fo=new FileOutputStream(f);
	book.write(fo);


	}
	public static void toAddRowInExcel(String path,String sheetname,int rowno,int cellno,String value) throws IOException {
	File f=new File(path);
	FileInputStream fin=new FileInputStream(f);
	Workbook book=new XSSFWorkbook(fin);
	Sheet sh = book.getSheet(sheetname);
	Row r = sh.createRow(rowno);
	Cell c = r.createCell(cellno);
	c.setCellValue(value);
	FileOutputStream fo=new FileOutputStream(f);
	book.write(fo);


	}
	public static void toUpdateExcel(String path,String sheetname,int rowno,int cellno,String value1,String value2) throws IOException {
	File f=new File(path);
	FileInputStream fin=new FileInputStream(f);
	Workbook book=new XSSFWorkbook(fin);
	Sheet SH = book.getSheet(sheetname);
	Row r = SH.getRow(rowno);
	Cell c = r.getCell(cellno);
	String value = c.getStringCellValue();
	if (value.contains(value)) {
	c.setCellValue(value1);
	}
	else {
	c.setCellValue(value2);
	}
	FileOutputStream fo=new FileOutputStream(f);
	book.write(fo);

	}
}
