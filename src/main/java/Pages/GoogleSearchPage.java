package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GoogleSearchPage {
    private WebDriver driver;
    private By searchBar = By.name("q");
    private By searchedResults = By.id("result-stats");

    private By pageHeader = By.cssSelector("[class='c-hero__title']");


    String firstNonAdResultText="";

    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
    }
    public void enterSearchPhraseAndSubmit(String searchPhrase) {
        WebElement searchBox = driver.findElement(searchBar);
        searchBox.sendKeys(searchPhrase);
        searchBox.submit();
    }

    public boolean isSearchResultsDisplayed() {
        return driver.findElement(searchedResults).isDisplayed();
    }

    public void clickFirstNonAdResult() {
        // Identify all the links on the web page
        List<WebElement> links = driver.findElements(By.tagName("a"));

        // Iterate through all the links and check their href attributes
        for (WebElement link : links) {
            String href = link.getAttribute("href");
            String jsname = link.getAttribute("jsname");


            if ((href != null) && jsname != null) {
                // Check if the href attribute contains any of the sponsored keywords
                if (href.contains("ad") || href.contains("sponsored") || href.contains("promoted") || href.contains("advertisement") || href.contains("paid") || href.contains("native")) {
                    System.out.println("Sponsored link: " + href);
                } else if (jsname.equals("UWckNb") && href.contains("https://www.london.ac.uk/courses/professional-accountancy")) {
                    link.click();
                    break;
                }
            }
        }
    }
    public boolean isfirstNonAdResultTextAsExpected() {
        return driver.findElement(pageHeader).isDisplayed();
    }


}
