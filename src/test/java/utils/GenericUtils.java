package utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class GenericUtils {
	public WebDriver driver;

	public GenericUtils(WebDriver driver) {
		this.driver = driver;
	}

	public void switchWindowToChild() {
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iterator = windows.iterator();
		String parentWindow = driver.getWindowHandle();
		String childWindow = null;
		// String parentWindow = iterator.next();
		// String childWindow = iterator.next();
		while (iterator.hasNext()) {
			childWindow = iterator.next();
			if (!(childWindow.equalsIgnoreCase(parentWindow))) {
				driver.switchTo().window(childWindow);
			}
		}

	}

}
