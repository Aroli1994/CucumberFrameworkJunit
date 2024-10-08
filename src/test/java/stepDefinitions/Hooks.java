package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.TestContextSetup;

public class Hooks {
	public TestContextSetup testContextSetpup;

	public Hooks(TestContextSetup testContextSetpup) {
		this.testContextSetpup = testContextSetpup;
	}

	@After
	public void AfterScenario() {
		testContextSetpup.testBase.webdriverManager().quit();
	}

	@AfterStep
	public void AddScreenshot(Scenario scenario) throws IOException {
		WebDriver driver = testContextSetpup.testBase.webdriverManager();
		if (scenario.isFailed()) {
			File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
			scenario.attach(fileContent, "image/png", "image");
		}
	}

}
