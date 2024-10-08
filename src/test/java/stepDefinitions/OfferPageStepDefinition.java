package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Then;
import pageObjects.LandingPage;
import pageObjects.OfferPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class OfferPageStepDefinition {
	public WebDriver driver;
	public String landingPageProductName;
	public String offerPageProductName;
	public TestContextSetup testContextSetup;
	public PageObjectManager pageObjectManager;
	public LandingPage landingPage;
	public OfferPage offerPage;
	
//Single responsibility principle(SRP)
//loosely coupled
//Factory design pattern
	public OfferPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.offerPage = testContextSetup.pageObjectManager.getOffersPage();
		this.landingPage = testContextSetup.pageObjectManager.getLandingPage();
	}

	@Then("^user searched for (.+) shortname in offers page$")
	public void user_searched_for_shortname_in_offers_page(String shortName) {
		landingPage.selectTopDealsPage();
		testContextSetup.genericUtils.switchWindowToChild();
		offerPage.searchItem(shortName);
		offerPageProductName = offerPage.getProductName();
		System.out.println(offerPageProductName + " is extracted from landing page");
	}

	@Then("validate product name in offers page matches with landing page")
	public void validate_product_name_in_offers_page_matches_with_landing_page() {
		Assert.assertEquals(offerPageProductName, testContextSetup.landingPageProductName);
	}

}
