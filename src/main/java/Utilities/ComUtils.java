package Utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class ComUtils extends TestBase{

	public static void Waitfor(WebElement e, int i) {
		
		WebDriverWait wb = new WebDriverWait (driver,Duration.ofSeconds(i));
		wb.until(ExpectedConditions.visibilityOf(e));
		
	}
	
	public static void ScrollUntil(WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", e);
	}
	
	public static void Full_Page_Scroll_Up() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,0);");
	}
	
	public static String captureScreenshotBase64() {
		TakesScreenshot ts = (TakesScreenshot) driver;
		String src = ts.getScreenshotAs(OutputType.BASE64);
		return src;
	}
	
	public static String captureScreenshot(String Filelane) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./Screenshot/"+Filelane);
		
		try {
			FileUtils.copyFile(src, destFile);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return destFile.getAbsolutePath();
	}
	
	public static void FluentWaitforElement(WebElement e, int i) {
		Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(i)) // Maximum wait time
                .pollingEvery(Duration.ofSeconds(2)) // Polling interval
                .ignoring(ElementClickInterceptedException.class, NoSuchElementException.class);
				 
	}
}
