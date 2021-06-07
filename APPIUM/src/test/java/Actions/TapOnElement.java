package Actions;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class TapOnElement {
	public static AndroidDriver driver;
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		/*
		 * Start the server
		 */
		AppiumDriverLocalService service=AppiumDriverLocalService.buildDefaultService();
		service.start();
		
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
		//driver.findElementByAccessibilityId("OS").click();
		
		MobileElement content=(MobileElement) driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Graphics\"]"));
         //driver.tap(1, content, 500);
        // driver.tap(1, 257, 882, 500);
         taponElement(content);
         taponCoOrdinate(257, 882);
         
         //STOP SERVER
         Thread.sleep(3000);
         service.stop();
	}
	


	
	/*
	 * generic Method
	 */
	private static void taponElement(MobileElement element) {
		driver.tap(1, element, 500);
	}
	
	private static void taponCoOrdinate(int x,int y) {
		driver.tap(1, x, y, 500);
	}

}
