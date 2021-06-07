package Actions;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class launchWebApp {
	public static AndroidDriver driver;
	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("deviceName","Galaxy A50");
		cap.setCapability("automationName","Appium");
		cap.setCapability("platformName","Android");
		cap.setCapability("platformVersion","11");
		
		/*
		 * launching browser
		 */
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		
		URL url=new URL("http://localhost:4723/wd/hub");
		 driver=new AndroidDriver(url,cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		/*
		 * Launching FB
		 */
		driver.get("https://facebook.com");
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("ansbdh");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("asdfg");
		driver.findElement(By.xpath("//button[@type='button']")).click();

	}

}
