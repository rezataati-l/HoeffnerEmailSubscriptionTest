package stepDefinition;

import org.junit.Assert;
import cucumber.api.java.en.Given;		
import cucumber.api.java.en.Then;		
import cucumber.api.java.en.When;
import pages.LoginPage;
import pages.ProtonMailHomePage;
import pages.ProtonMailInbox;
import pages.ProtonMailLoginPage;
import pages.RegistrationPage;

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
	
	@Then("^I receive an email asking to confirm my email$")
	public void i_receive_an_email_asking_to_confirm_my_email() throws Throwable {
		ProtonMailHomePage protonMailLoginPage = new ProtonMailHomePage(webDriver);
		protonMailLoginPage.open_page();
		protonMailLoginPage.click_login_button();
		new ProtonMailLoginPage(webDriver).login();
	}

	@When("^I open the email$")
	public void i_open_the_email() throws Throwable {
		new ProtonMailInbox(webDriver).click_first_mail();
	}

	@Then("^there is a link to finish registration process$")
	public void there_is_a_link_to_finish_registration_process() throws Throwable {
		Assert.assertTrue(new ProtonMailInbox(webDriver).is_complete_registration_button_displayed());
	}
	
	@When("^I click Jetzt Anmeldung abschlieBen$")
	public void i_click_Jetzt_Anmeldung_abschlie_en() throws Throwable {
		new ProtonMailInbox(webDriver).click_complete_registration_button();
	}

	@Then("^I am redirected to page confirming subscription \\[https://www\\.hoeffner\\.de/nl-anmeldung\\]$")
	public void i_am_redirected_to_page_confirming_subscription_https_www_hoeffner_de_nl_anmeldung() throws Throwable {
		RegistrationPage registrationPage = new RegistrationPage(webDriver);
		Assert.assertEquals(registrationPage.get_page_title(), "Bestätigung Newsletter-Anmeldung | Möbel Höffner");
	    Assert.assertTrue(registrationPage.is_registration_acknowledgment_message_displayed());	    
	}
	
}
