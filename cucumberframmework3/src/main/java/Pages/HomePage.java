package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[text()='Revenue Calculator']")
	private WebElement revenueCalculatorLink;

	public RevenueCalculatorPage navigateToRevenueCalculatorPage() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    
	    wait.until(ExpectedConditions.elementToBeClickable(revenueCalculatorLink));
	    

	    revenueCalculatorLink.click();
	    
	    // Return the next page object
	    return new RevenueCalculatorPage(driver);
	}
}
