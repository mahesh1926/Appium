package DriverMethods;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class NotificationReminder {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("deviceName","Galaxy A50");
		cap.setCapability("automationName","Appium");
		cap.setCapability("platformName","Android");
		cap.setCapability("platformVersion","11");
		cap.setCapability("appPackage","com.bhanu.notificationreminders");
		cap.setCapability("appActivity",".MainDrawerActivity");
		
		URL url=new URL("http://localhost:4723/wd/hub");
		AndroidDriver driver=new AndroidDriver(url,cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"com.bhanu.notificationreminders:id/txtNewNoteTitle\"]")).sendKeys("abcd");
		driver.findElementById("com.bhanu.notificationreminders:id/btnNotify").click();
		//driver.closeApp();
		Thread.sleep(500);
		driver.openNotifications();
		driver.findElement(By.xpath("//android.widget.ImageView[@resource-id=\"android:id/right_icon\"]")).click();
		

	}

}
