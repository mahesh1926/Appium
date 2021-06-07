package Actions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;


import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class parallelexecution {
	@Test
	@Parameters({"deviceName","platformVersion","UDID","port"})
	public void parallelTest(String deviceName,String platformVersion,String UDID,String port ) throws IOException, ParseException, InterruptedException {
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("deviceName",deviceName);
		cap.setCapability("automationName","Appium");
		cap.setCapability("platformName",platformVersion);
		cap.setCapability("platformVersion","11");
		cap.setCapability("UDID",  UDID);
		cap.setCapability("appPackage","com.androidsample.generalstore");
		cap.setCapability("appActivity",".SplashActivity");
		
		URL url=new URL("http://localhost:"+port+"/wd/hub");
		AndroidDriver driver=new AndroidDriver(url,cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementById("com.androidsample.generalstore:id/spinnerCountry").click();
		scrollToElement(driver, "text", "India");
		driver.findElement(By.xpath("//android.widget.TextView[@text\r\n"
				+ "='India']")).click();
		driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("user1");
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		driver.findElementById("com.androidsample.generalstore:id/productAddCart").click();
		driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
		driver.findElementById("com.androidsample.generalstore:id/btnProceed").click();
		Thread.sleep(3000);
		Set<String> apps = driver.getContextHandles();
		for(String app:apps)
		{
			System.out.println(app);
		}
		driver.context("WEBVIEW_com.androidsample.generalstore");
		Thread.sleep(3000);
		driver.findElementByXPath("//input[@name='q']").sendKeys("appium");
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_ENTER);
		
	} 
		
		
		public static void scrollToElement(AndroidDriver driver,String an,String av)
	 {
	  driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("+an+"(\""+av+"\"))");
	 }
}
