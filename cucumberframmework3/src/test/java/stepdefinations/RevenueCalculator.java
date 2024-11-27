package stepdefinations;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import Pages.HomePage;
import Pages.RevenueCalculatorPage;
import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class RevenueCalculator {
	 WebDriver driver;
	 RevenueCalculatorPage rc;
	HomePage homePage;
	@Given("User is on the FitPeo Homepage")
	public void user_is_on_fitpeo_homepage() {
		driver = DriverFactory.getDriver(); 
	}


	@And("User clicks on the Revenue Calculator tab")
	public void User_clicks_on_the_Revenue_Calculator_tab() throws Exception{
		driver = DriverFactory.getDriver(); 
		homePage= new HomePage(driver);
		rc = new RevenueCalculatorPage(driver);
		rc=homePage.navigateToRevenueCalculatorPage();

	}

	@Then("User should be redirected to the Revenue Calculator page")
	public void user_should_be_redirected_to_Revenue_Calculator_page() {
		String actualPageTitle=rc.revenueCalculatorPageTitle();
		System.out.println(actualPageTitle);
		Assert.assertEquals(actualPageTitle,"Remote Patient Monitoring (RPM) - fitpeo.com");
	}

	@When("User scroll down the page until the revenue calculator slider is visible")
	public void User_scroll_down_the_page_until_the_revenue_calculator_slider_is_visible() {
		rc.scrollDowntotheSlider();
	}

	@Then("User should see the revenue calculator slider")
	public void User_should_see_the_revenue_calculator_slider() {
		boolean isSliderVisible = rc.visibilityofrevenuecalculatorslider();
		Assert.assertTrue(isSliderVisible);
	}

	@When("User adjusts the slider to set its value to {int}")
	public void user_adjusts_slider_to_value(int value) throws Exception {
		rc.adjustTheSlider(value);
	}

	@Then("User should see the bottom text field value updated to {int}")
	public void user_should_see_text_field_updated_to_value(int value) {
		int sliderCurrectvalue = rc.sliderUpdatedValue();
		Assert.assertEquals(sliderCurrectvalue, value);
	}

	@When("User enters the value {int} in the text field")
	public void user_enters_value_in_text_field(int value) throws Exception {
		rc.updatetheTextField(value);
	}

	@Then("The slider should update to reflect the value {int}")
	public void slider_should_update_to_reflect_text_field_value(int value) {
		int actualUpdatedValue = rc.sliderUpdatedValue();
		Assert.assertEquals(value, actualUpdatedValue);
	}

	@When("User selects the checkboxes for {string}, {string}, {string}, and {string}")
	public void user_selects_cpt_checkboxes(String code1, String code2, String code3, String code4) {
		rc.selectcheckboxs(code1, code2, code3, code4);
	}


	@Then("User should select the checkboxes {string}, {string}, {string}, and {string}")
	public void user_should_select_checkboxes(String a, String b, String c, String d) {
		boolean checkboxesSelected = rc.isCheckboxSelected(a, b, c, d);
		Assert.assertTrue("Checkboxes for the given CPT codes should be selected", checkboxesSelected);
	}

	@When("User sets the slider to value {int}")
	public void user_sets_slider_to_value(int value) throws InterruptedException {
		rc.updatetheTextField(value);
	}


	@Then("The total recurring reimbursement should be validated")
	public void total_recurring_reimbursement_should_be_validated() {
		String actualRevenueAmount = rc.retriveTotalReimbursement();
		System.out.println("Total Revenue"+actualRevenueAmount);
	}

	@Then("The total recurring reimbursement should be match with {string} value")
	public void total_recurring_reimbursement_should_match_with_amount(String expected_amount) {
		String actualrevenuevalue = rc.retriveTotalReimbursement();
		System.out.println(actualrevenuevalue);
		Assert.assertEquals(expected_amount,actualrevenuevalue);
	}

}


