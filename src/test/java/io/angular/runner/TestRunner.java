package io.angular.runner;

import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

//we need to write outside the class on top of the class
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/resources/featurefile",//read the data from feaure file
        glue = "io/angular",// glue help to locate the step defination file
        plugin = {"pretty", "html:target/cucumber-report/cucumber.html",
                "com.cucumber.listener.ExtentCucumberFormatter:target/Extent_Reports/report.html"
        }, //to generate report of pass or failed scenario
        tags = {"@training_0,@training_01,@training_02,@training_1"} //tags to give for the grouping like regression ,sanity
)
public class TestRunner {

        @AfterClass
        public static void setUp() { //to add the information regarding Report
                String projectPath = System.getProperty("user.dir");
                String reportConfigPath = projectPath + "/src/test/java/resources/extentreport/extent-config.xml";
                Reporter.loadXMLConfig(reportConfigPath);
                Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
                Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
                Reporter.setSystemInfo("Machine", "Windows 10" + "64 Bit");
                Reporter.setSystemInfo("Selenium", "3.141.59");
                Reporter.setSystemInfo("Maven", "3.5.9");
                Reporter.setSystemInfo("Java Version", "1.8.0_151");
        }

}
