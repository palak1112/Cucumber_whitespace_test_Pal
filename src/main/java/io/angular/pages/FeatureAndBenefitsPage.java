package io.angular.pages;

import io.angular.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class FeatureAndBenefitsPage extends Utility {
    private static final Logger log = LogManager.getLogger(FeatureAndBenefitsPage.class.getName());

    public FeatureAndBenefitsPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//div[contains(text(),'Cross Platform')]")
    WebElement verifyCrossPlatformtext;

    @CacheLookup
    @FindBy(xpath = "//div[contains(text(),'Speed and Performance')]")
    WebElement verifySpeedAndPerformancetext;

    @CacheLookup
    @FindBy(xpath = "//div[contains(text(),'Productivity')]")
    WebElement verifyProductivitytext;

    public String getAndverifyCrossPlatformtext() {
        String message = getTextFromElement(verifyCrossPlatformtext);
        log.info("Getting text from : " + verifyCrossPlatformtext.toString());
        return message;
    }

    public String getAndverifySpeedAndPerformancetext() {
        String message = getTextFromElement(verifySpeedAndPerformancetext);
        log.info("Getting text from : " +verifySpeedAndPerformancetext.toString());
        return message;
    }
    public String getAndverifyProductivitytext() {
        String message = getTextFromElement(verifyProductivitytext);
        log.info("Getting text from : " + verifyProductivitytext.toString());
        return message;
    }
}
