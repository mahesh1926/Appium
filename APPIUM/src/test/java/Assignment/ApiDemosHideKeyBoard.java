package Assignment;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class ApiDemosHideKeyBoard {
	public static AndroidDriver driver;
	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("deviceName","Galaxy A50");
		cap.setCapability("automationName","Appium");
		cap.setCapability("platformName","Android");
		cap.setCapability("platformVersion","11");
		cap.setCapability("appPackage","io.appium.android.apis");
		cap.setCapability("appActivity",".ApiDemos");
		cap.setCapability("noReset", true);
		
		URL url=new URL("http://localhost:4723/wd/hub");
		driver=new AndroidDriver(url,cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		driver.tap(1, 154, 1678, 500);
		driver.tap(1, 169, 897, 500);
		driver.tap(1, 246, 487, 500);
		driver.findElementById("io.appium.android.apis:id/check1").sendKeys("abcd");
		driver.tap(1, 54,702,500);
		driver.tap(1, 54, 943, 500);
		
		/*
		 * Hiding keyboard
		 */
		driver.hideKeyboard();
		
		driver.tap(1, 1005,1395, 500);
		driver.tap(1, 849, 1247, 500);
		
			}
	private static void tapOnElement(int x, int y) {
		driver.tap(1, x, y, 500);
	}

}
