package Actions;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class DragAndDrop {

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
		AndroidDriver driver=new AndroidDriver(url,cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.tap(1, 182, 1684, 500);
		driver.tap(1, 340, 1290, 500);
		WebElement src = driver.findElementById("io.appium.android.apis:id/drag_dot_1");
		WebElement dest = driver.findElementById("io.appium.android.apis:id/drag_dot_3");
		
		TouchAction ta=new TouchAction(driver);
		ta.longPress(src).waitAction(2000).moveTo(dest).release().perform();
	
		

	}

}
