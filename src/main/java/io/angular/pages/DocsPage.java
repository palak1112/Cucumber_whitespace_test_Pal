package io.angular.pages;

import io.angular.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocsPage extends Utility {
    private static final Logger log = LogManager.getLogger(DocsPage.class.getName());

    public DocsPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='Docs']")
    WebElement docsButton;

    @CacheLookup
    @FindBy(xpath = "//h1[@id='introduction-to-the-angular-docs']")
    WebElement verifyIntroductiontotheAngularDocstext;

    public void clickOnDocsButton() {
        clickOnElement(docsButton);
        log.info("Clicking on login link : " + docsButton.toString());
    }
    public String getIntroductiontotheAngularDocsText() {
        String message = getTextFromElement(verifyIntroductiontotheAngularDocstext);
        log.info("Getting text from : " + verifyIntroductiontotheAngularDocstext.toString());
        return message;
    }
}
