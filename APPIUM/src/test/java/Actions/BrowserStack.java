package Actions;


import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.net.MalformedURLException;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
      
public class BrowserStack {

  public static void main(String[] args) throws MalformedURLException, InterruptedException {
    
      DesiredCapabilities caps = new DesiredCapabilities();
      
      // Set your access credentials
      caps.setCapability("browserstack.user", "mahesh_diQ68c");
      caps.setCapability("browserstack.key", "aC74zxmEpXAAEBh7npxw");
      
      // Set URL of the application under test
      caps.setCapability("app", "bs://a9dbb344cf2060d6152c497af085313cfaf0bb05");
      
      // Specify device and os_version for testing
      caps.setCapability("device", "Xiaomi Redmi Note 9");
      caps.setCapability("os_version", "10.0");
        
      // Set other BrowserStack capabilities
      caps.setCapability("project", "First Java Project");
      caps.setCapability("build", "Java Android");
      caps.setCapability("name", "first_test");
        
      
      // Initialise the remote Webdriver using BrowserStack remote URL
      // and desired capabilities defined above
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
            new URL("http://hub.browserstack.com/wd/hub"), caps);
        

      /* Write your Custom code here */
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.tap(1, 182, 1684, 500);
		driver.tap(1, 340, 1290, 500);
		WebElement src = driver.findElementById("io.appium.android.apis:id/drag_dot_1");
		WebElement dest = driver.findElementById("io.appium.android.apis:id/drag_dot_3");
		
		TouchAction ta=new TouchAction(driver);
		ta.longPress(src).waitAction(2000).moveTo(dest).release().perform();  
        
      // Invoke driver.quit() after the test is done to indicate that the test is completed.
      driver.quit();
    
    }
      
  
}
