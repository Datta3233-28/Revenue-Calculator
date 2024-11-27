package utils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {
	WebDriver driver;
    public ElementUtils(WebDriver driver) {
    	
    	this.driver=driver;
	}
	
	public void clickOnElement(WebElement element, long durationInSecond) {
		
		WebElement webElement= wailForElement(element,durationInSecond);
		 webElement.click();
	}
		
	public void typeTextIntoElement(WebElement element,String textToBeTyped, long durationInSecond) {
	
		WebElement webElement=wailForElement(element,durationInSecond);
		
		webElement.click();
		webElement.clear();
		webElement.sendKeys(textToBeTyped);
}
	public WebElement wailForElement(WebElement element, long durationInSecond) {
		WebElement webElement=null;
		try {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(durationInSecond));
		webElement= wait.until(ExpectedConditions.elementToBeClickable(element));
		}catch(Throwable e) {
			e.printStackTrace();
		}
		return webElement;
	}
	public void selectOptionInDropdown(WebElement element,String dropdownOption, long durationInSecond) {
		WebElement webElement= wailForElement(element,durationInSecond);
		Select select=new Select(webElement);
		select.selectByVisibleText(dropdownOption);
			
	}
	public void acceptAlert(long durationInseconds) {
		Alert alert = waitForAltert(durationInseconds);
		alert.accept();
	}
	public void dismissAlert(long durationInseconds) {
		Alert alert = waitForAltert(durationInseconds);
		alert.dismiss();
	}
	
	
	public Alert waitForAltert(long durationInseconds) {
		Alert alert=null;
	
	try {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(durationInseconds));
		alert = wait.until(ExpectedConditions.alertIsPresent());
	}catch(Throwable e) {
		e.printStackTrace();
	}
	
	return alert;
	}
	public void mousHoverAndClick(WebElement element, long durationInseconds) {
		WebElement webElement=waitForVisibilityOfElement(element,durationInseconds);
		Actions actions=new Actions(driver);
		actions.moveToElement(webElement).click().build().perform();
	}
	public WebElement waitForVisibilityOfElement(WebElement element, long durationInseconds) {
		WebElement webElement=null;
		try {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(durationInseconds));
	   webElement=wait.until(ExpectedConditions.visibilityOf(element));
	}catch(Throwable e) {
		e.printStackTrace();
	}
		return webElement;
}
	public void javaScriptClick(WebElement element, long durationInseconds) {
		WebElement webElement=waitForVisibilityOfElement(element,durationInseconds);
		JavascriptExecutor jse = ((JavascriptExecutor)driver);
		jse.executeScript("arguments[0].click();", webElement);
	
	}
	public void javaScriptType(WebElement element, long durationInseconds,String textToBeType) {
		WebElement webElement=waitForVisibilityOfElement(element,durationInseconds);
		JavascriptExecutor jse = ((JavascriptExecutor)driver);
		jse.executeScript("arguments[0].value='"+textToBeType+"'", webElement);
	
	}
	
	public String getTextFromElement(WebElement element, long durationInseconds) {
		WebElement webElement= wailForElement(element,durationInseconds);
		return webElement.getText();
	}
		
	public boolean displayStatusOfElement(WebElement element, long durationInseconds) {
		try {
		WebElement webElement=waitForVisibilityOfElement(element,durationInseconds);
		return webElement.isDisplayed();
	}catch(Throwable e) {
		return false;
	}
		
	}
	}	
	
	
