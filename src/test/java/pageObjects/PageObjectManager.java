package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	public WebDriver driver;
	public LandingPage landingPage;
	public OfferPage offerPage;
	public CheckoutPage checkoutPage;	

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public LandingPage getLandingPage() {
		landingPage = new LandingPage(driver);
		return landingPage;
	}

	public OfferPage getOffersPage() {
		offerPage = new OfferPage(driver);
		return offerPage;
	}
	
	public CheckoutPage getCheckoutPage() {
		checkoutPage = new CheckoutPage(driver);
		return checkoutPage;
	}

}
