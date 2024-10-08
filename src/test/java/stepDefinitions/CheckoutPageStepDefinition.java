package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Then;
import pageObjects.CheckoutPage;
import utils.TestContextSetup;

public class CheckoutPageStepDefinition {
	public WebDriver driver;
	public String landingPageProductName;
	public String offerPageProductName;
	public CheckoutPage checkOutPage;

	TestContextSetup testContextSetup;

	public CheckoutPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.checkOutPage = testContextSetup.pageObjectManager.getCheckoutPage();
	}

	@Then("verify user has ability to enter promo code and place the order")
	public void verify_user_has_ability_to_enter_promo_code_and_place_the_order() {
		Assert.assertTrue(checkOutPage.verifyPromoBtn());
		Assert.assertTrue(checkOutPage.verifyPlaceOrderBtn());
	}
	
	@Then("^User proceeds to checkout and validate the (.+) items in checkout page$")
	public void user_proceeds_to_checkout_and_validate_the_tom_items_in_checkout_page(String shortName) {
		checkOutPage.checkoutItems();
	}

}
