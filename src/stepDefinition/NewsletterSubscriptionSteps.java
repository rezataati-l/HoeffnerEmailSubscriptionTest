package stepDefinition;

import org.junit.Assert;

import cucumber.api.java.en.Given;		
import cucumber.api.java.en.Then;		
import cucumber.api.java.en.When;

import pages.LoginPage;

public class NewsletterSubscriptionSteps extends BaseClass{
			
	@Given("^A Hoeffner login page \\[https://www\\.hoeffner\\.de/login\\]$")
	public void a_Hoeffner_login_page_https_www_hoeffner_de_login() throws Throwable {
		// Nothing should be done here!
	}

	@When("^I open a page$")
	public void i_open_a_page() throws Throwable {
		LoginPage loginPage = new LoginPage(webDriver);
		loginPage.open_page();
		loginPage.close_cookie_popup_if_exists();
		Assert.assertEquals(loginPage.get_page_title(), "Höffner - Anmelden");
	}

	@Then("^I can see a newsletter subscription input$")
	public void i_can_see_a_newsletter_subscription_input() throws Throwable {
		Assert.assertTrue(new LoginPage(webDriver).is_newsletter_subscription_input_exists());
	}

	@When("^I enter my email in the input field$")
	public void i_enter_my_email_in_the_input_field() throws Throwable {
		new LoginPage(webDriver).fill_newsletter_subscription_email_input("linkmail001@protonmail.com");
	}

	@When("^I press Absenden button$")
	public void i_press_button() throws Throwable {
		new LoginPage(webDriver).click_newsletter_subscription_submit_button();
	}

	@Then("^I can see a confirmation message that my subscription is in progress$")
	public void i_can_see_a_confirmation_message_that_my_subscription_is_in_progress() throws Throwable {
		Assert.assertTrue(new LoginPage(webDriver).is_newsletter_subscription_confirmation_text_displayed());
	}
	
}
