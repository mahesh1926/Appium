package Actions;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class SwipeAction {
	static AndroidDriver driver;	
 public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("deviceName","Galaxy A50");
		cap.setCapability("automationName","Appium");
		cap.setCapability("platformName","Android");
		cap.setCapability("platformVersion","11");
		cap.setCapability("appPackage","jp.rallwell.siriuth.touchscreentest");
		cap.setCapability("appActivity",".TouchScreenTestActivity");
		
		URL url=new URL("http://localhost:4723/wd/hub");
		 driver=new AndroidDriver(url,cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//swipeAction
//		driver.swipe(490, 201, 490, 1580, 500);
//		driver.swipe(80, 910, 1009, 910, 500);
		
		//getsizemethod
		Dimension size = driver.manage().window().getSize();
		int Ht=size.getHeight();
		int wd=size.getWidth();
		System.out.println("height of phone is"+Ht);
		System.out.println("Width of phone is"+wd);
		
		driver.swipe(100, 700, 800, 700, 500);
		driver.swipe(800, 700, 800, 1500, 500);
		driver.swipe(800, 1500, 100, 1500, 500);
		driver.swipe(100, 1500, 100, 700, 500);
		
		driver.swipe(100, 700, 800, 1500, 500);
		driver.swipe(800, 700, 100, 1500, 500);
		
		driver.swipe((int)(wd*0.1), (int)(Ht*0.2), (int)(wd*0.1),(int)(Ht*0.2), 500);
//		
//		//swipe Action Horizontally
//		driver.swipe(100, Ht/2, 900, Ht/2, 5000);
//		
//		//swipeaction Vertically
//		driver.swipe(wd/2, 150, wd/2, 1500, 5000);
		
}
      
	
	

}
