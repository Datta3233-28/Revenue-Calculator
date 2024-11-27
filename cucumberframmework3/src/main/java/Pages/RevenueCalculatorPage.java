package Pages;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RevenueCalculatorPage {

	private WebDriver driver;


	public RevenueCalculatorPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath="//span[@data-index='0' and contains(@class, 'MuiSlider-thumb')]")
	private WebElement  revenueSliderElement ;

	@FindBy(xpath="//div[contains(@class, 'MuiInputBase-root')]//input[@type='number']")
	private WebElement  revenueSliderTextField ;

	@FindBy(xpath="//input[@type='checkbox']")
	private List <WebElement>  CPTcheckboxs ;

	@FindBy(xpath="(//p[contains(@class, 'MuiTypography-body1')])[4]")
	private WebElement  TotalRecurringReimbursementEle ;

	@FindBy(xpath="//p[@class='MuiTypography-root MuiTypography-body1 inter css-1s3unkt']")
	private List <WebElement> CPTids ;

	public String revenueCalculatorPageTitle() {
		return driver.getTitle();

	}

	public void scrollDowntotheSlider() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300);");
	}
	public boolean visibilityofrevenuecalculatorslider() {
		return revenueSliderTextField.isDisplayed();
	}
	public void adjustTheSlider(int x) throws Exception {
		Actions act = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		By revenueSliderElement = By.xpath("//span[@data-index='0' and contains(@class, 'MuiSlider-thumb')]");

		WebElement slider = wait.until(ExpectedConditions.visibilityOfElementLocated(revenueSliderElement));

		act.dragAndDropBy(slider,x, 0).perform();
		Thread.sleep(2000);

	}

	public int sliderUpdatedValue() {
		String slidercurrectvalue = revenueSliderTextField.getAttribute("value");
		return Integer.parseInt(slidercurrectvalue);
	}
	public void updatetheTextField(int y) throws InterruptedException {
		Thread.sleep(5000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		revenueSliderTextField.clear();
		Thread.sleep(5000);
		js1.executeScript("arguments[0].value ='"+y+"';", revenueSliderTextField);
		

	}
	public void selectcheckboxs(String a,String b,String c,String d) {
		List<String> targetCPTCodes = Arrays.asList(a,b,c,d);
		for (int i = 0; i < CPTids.size(); i++) {
			String cptText = CPTids.get(i).getText();
			if (targetCPTCodes.contains(cptText)) {
			
				CPTcheckboxs.get(i).click();
			}
		}
	}
	public boolean isCheckboxSelected(String a, String b, String c, String d) {

		List<String> targetCPTCodes = Arrays.asList(a, b, c, d);
		boolean allSelected = true;
		for (int i = 0; i < CPTids.size(); i++) {
			String cptText = CPTids.get(i).getText(); 

			if (targetCPTCodes.contains(cptText)) { 
				System.out.println("Checking CPT code: " + cptText);
				if (!CPTcheckboxs.get(i).isSelected()) {
					System.out.println("Checkbox for CPT code " + cptText + " is not selected.");
					allSelected = false; 
				} else {
					System.out.println("Checkbox for CPT code " + cptText + " is selected.");
				}
			}
		}

		return allSelected; 
	}
	public String retriveTotalReimbursement () {
		return TotalRecurringReimbursementEle.getText();
	}
}
