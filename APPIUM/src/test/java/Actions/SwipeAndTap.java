package Actions;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class SwipeAndTap {

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
		
		//driver.findElementById("com.android.permissioncontroller:id/continue_button").click();
		//driver.findElementById("android:id/button1").click();
		driver.findElementByAccessibilityId("Text").click();
		driver.findElementByAccessibilityId("9. Switch").click();

	}

}
