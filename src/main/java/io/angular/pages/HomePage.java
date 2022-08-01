package io.angular.pages;

import io.angular.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class HomePage extends Utility {
    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='Features']")
    WebElement featureButton;

    @CacheLookup
    @FindBy(xpath = "//h1[@id='features--benefits']")
    WebElement verifytext;

    @CacheLookup
    @FindBy(xpath = "//mat-toolbar-row[@class='mat-toolbar-row']")
    List<WebElement> topMenuList;

    public void clickOnfeatureButton() {
        clickOnElement(featureButton);
        log.info("Clicking on login link : " + featureButton.toString());
    }

    public String getFeatureAndBenefitsText() {
        String message = getTextFromElement(verifytext);
        log.info("Getting text from : " + verifytext.toString());
        return message;
    }

    public void clickOnMenuTab(String tab) {
        for (WebElement menu : topMenuList) {
            if (menu.getText().contains(tab)) {
                clickOnElement(menu);
                break;
            }
        }
    }

}
