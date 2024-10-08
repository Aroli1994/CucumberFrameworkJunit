package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class LandingPageStepDefinition {
	public WebDriver driver;
	public String landingPageProductName;
	public String offerPageProductName;
	public TestContextSetup testContextSetup;
	public LandingPage landingPage;

	public LandingPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.landingPage = testContextSetup.pageObjectManager.getLandingPage();
	}

//Spring framework, EJB, Cucumber PicoContainer
	@Given("User is on Greenkart Landing page")
	public void user_is_on_greenkart_landing_page() {
		Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));
	}

	@When("^user searched with shortname (.+) and extracted actual name of product$")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
		landingPage.searchItem(shortName);
		Thread.sleep(3000);
		testContextSetup.landingPageProductName = landingPage.getProductName().split("-")[0].trim();
		System.out.println(testContextSetup.landingPageProductName + " is extracted from home page");
	}

	@When("Added {string} items of selected product to cart")
	public void added_items_of_selected_product_to_cart(String quantity) {
		landingPage.incrementQuantity(Integer.parseInt(quantity));
		landingPage.addToCartItem();
	}

}
