package io.angular;

import com.cucumber.listener.Reporter;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.angular.propertyreader.PropertyReader;
import io.angular.utility.Utility;

import java.io.IOException;


public class Hooks extends Utility  {


    @Before//use for give the browser which one we are use browser
    public void setUp(){
        selectBrowser(PropertyReader.getInstance().getProperty("browser"));
    }

    @After // use for to take the sceenshot while testcases is failed
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            String screenShotPath = Utility.getScreenshot(driver, scenario.getName().replace(" ", "_"));
            try {
                Reporter.addScreenCaptureFromPath(screenShotPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        closeBrowser(); // for close the browser
    }
}
