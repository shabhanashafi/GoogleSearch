package StepDefinitions;
import Pages.GoogleSearchPage;
import com.factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import static com.factory.DriverFactory.getDriver;

public class googleSearchSteps {
    private GoogleSearchPage googleSearchPage = new GoogleSearchPage(getDriver());

    private WebDriver driver;

    public googleSearchSteps(){
        driver = DriverFactory.getDriver();
    }

    @Given("user open the Google website")
    public void user_open_the_google_website() {
        driver.get("http://www.google.com");
    }

    @When("user enters search phrase in the search bar and submit search")
    public void user_enters_search_phrase_in_the_search_bar_and_submit_search() {
        String searchPhrase = ApplicationHooks.getProps().getProperty("searchPhrase");
        googleSearchPage.enterSearchPhraseAndSubmit(searchPhrase);

    }
    @Then("user should see search results")
    public void user_should_see_search_results() {
        Assert.assertTrue("Unable to fetch the results",googleSearchPage.isSearchResultsDisplayed());
    }
    @Then("user clicks on first nonad result")
    public void user_clicks_on_first_nonad_result() {
        googleSearchPage.clickFirstNonAdResult();
    }
    @Then("user should see the page with the initial search phrase")
    public void user_should_see_the_page_with_the_initial_search_phrase() {
        Assert.assertTrue("User clicked on 1st nonAd result",googleSearchPage.isfirstNonAdResultTextAsExpected());
    }


}
