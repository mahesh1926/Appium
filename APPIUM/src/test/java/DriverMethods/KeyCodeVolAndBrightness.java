package DriverMethods;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class KeyCodeVolAndBrightness {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("deviceName","Galaxy A50");
		cap.setCapability("automationName","Appium");
		cap.setCapability("platformName","Android");
		cap.setCapability("platformVersion","11");
		cap.setCapability("appPackage","com.davemorrissey.labs.subscaleview.sample");
		cap.setCapability("appActivity",".MainActivity");
		
		URL url=new URL("http://localhost:4723/wd/hub");
		AndroidDriver driver=new AndroidDriver(url,cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
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
