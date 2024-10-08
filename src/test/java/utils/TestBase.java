package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public WebDriver driver;
	public String testUrl;
	public String browserName;

	public WebDriver webdriverManager() {

		try {
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "//src//test//resources//global.properties");
			Properties prop = new Properties();
			prop.load(fis);
			testUrl = prop.getProperty("QAUrl");
			String browser_properties = prop.getProperty("browser");
			String browser_maven = System.getProperty("browser");
			// result = testCondition ? value1 : value2
			browserName = browser_maven != null ? browser_maven : browser_properties;

		} catch (IOException e) {
			e.printStackTrace();
		}

		if (driver == null) {
			if (browserName.equalsIgnoreCase("chrome")) {
				//WebDriverManager.chromedriver().setup();
				System.setProperty("webdriver.chrome.driver", "//Users//krishnabros//Documents//chromedriver//chromedriver129");
				driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			} else if (browserName.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}
			driver.get(testUrl);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		}
		return driver;
	}

}
