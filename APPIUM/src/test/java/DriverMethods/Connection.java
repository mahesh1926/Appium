package DriverMethods;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class Connection {

	public static void main(String[] args) throws MalformedURLException {
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
		
		driver.openNotifications();
		
		
		System.out.println(driver.getConnection());
		 io.appium.java_client.android.Connection con = driver.getConnection();
		
		driver.setConnection(con.AIRPLANE);
		System.out.println(driver.getConnection());
		driver.setConnection(con.WIFI);
		
	}

}
