package DriverMethods;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class keyCodeMethods {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("deviceName","Galaxy A50");
		cap.setCapability("automationName","Appium");
		cap.setCapability("platformName","Android");
		cap.setCapability("platformVersion","11");
		cap.setCapability("appPackage","com.sec.android.app.camera");
		cap.setCapability("appActivity",".Camera");
		cap.setCapability("noReset", true);
		
		URL url=new URL("http://localhost:4723/wd/hub");
		AndroidDriver driver=new AndroidDriver(url,cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		
		//switch to front cam
//		driver.findElementByAccessibilityId("Switch to front camera").click();
//		driver.pressKeyCode(AndroidKeyCode.KEYCODE_CAMERA);
		
		//Volume Functions
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_VOLUME_UP);
		Thread.sleep(500);
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_VOLUME_DOWN);
		Thread.sleep(500);
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_VOLUME_MUTE);
		

		//Brightnes action
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_BRIGHTNESS_UP);
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_BRIGHTNESS_DOWN);
	}

}
