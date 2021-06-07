package DriverMethods;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class ZoomInZoomOut {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("deviceName","Galaxy A50");
		cap.setCapability("automationName","Appium");
		cap.setCapability("platformName","Android");
		cap.setCapability("platformVersion","11");
		cap.setCapability("appPackage","com.davemorrissey.labs.subscaleview.sample");
		cap.setCapability("appActivity",".MainActivity");
		cap.setCapability("noReset", true);
		
		URL url=new URL("http://localhost:4723/wd/hub");
		AndroidDriver driver=new AndroidDriver(url,cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElementById("com.davemorrissey.labs.subscaleview.sample:id/imageDisplay").click();
		WebElement image = driver.findElementById("com.davemorrissey.labs.subscaleview.sample:id/imageView");
		
		
		driver.zoom(image);
		Thread.sleep(500);
		
		driver.pinch(image);
		

	}

}
