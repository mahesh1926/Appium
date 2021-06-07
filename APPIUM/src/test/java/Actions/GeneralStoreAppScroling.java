package Actions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class GeneralStoreAppScroling {

	public static void main(String[] args) throws IOException, ParseException {
		
		FileReader reader=new FileReader(".\\AppCredential\\jsondata.json");
		 JSONParser parser=new JSONParser();
		Object object = parser.parse(reader);
		JSONObject jsonobject=(JSONObject)object;
		
		 
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("deviceName",jsonobject.get("deviceName"));
		cap.setCapability("automationName",jsonobject.get("automationname"));
		cap.setCapability("platformName",jsonobject.get("platformname"));
		cap.setCapability("platformVersion",jsonobject.get("platformversion"));
		cap.setCapability("appPackage",jsonobject.get("apppackage"));
		cap.setCapability("appActivity",jsonobject.get("appactivity"));
		
		URL url=new URL("http://localhost:4723/wd/hub");
		AndroidDriver driver=new AndroidDriver(url,cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementById("com.androidsample.generalstore:id/spinnerCountry").click();
		scrollToElement(driver, "text", "India");
		driver.findElement(By.xpath("//android.widget.TextView[@text\r\n"
				+ "='India']")).click();
		driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("mahesh");
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		
		}
	public static void scrollToElement(AndroidDriver driver,String an,String av)
	 {
	  driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("+an+"(\""+av+"\"))");
	 }
}
