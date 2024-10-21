import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;

import java.net.URI;
import java.net.URL;


public class MobileTest {
	
	static AppiumDriver driver;
	
	public static void main(String[] args) {
		try {
			openApp();
		}catch(Exception exp) {
			System.out.println(exp.getCause());
			System.out.println(exp.getMessage());
			exp.printStackTrace();
		}
	}
	@BeforeClass
    public static void openApp() throws Exception {
        
    	DesiredCapabilities capabilities = new DesiredCapabilities();
    	
    	capabilities.setCapability("appium:deviceName", "Medium_Phone_API_34");
    	capabilities.setCapability("appium:platformName", "Android");
    	capabilities.setCapability("appium:automationName", "UiAutomator2");
    	capabilities.setCapability("appium:platformVersion", "14");
        capabilities.setCapability("appium:udid", "emulator-5554");
        
        capabilities.setCapability("appium:appPackage", "com.google.android.calculator");
    	capabilities.setCapability("appium:appActivity", "com.android.calculator2.Calculator");
            
            URL url = URI.create("http://127.0.0.1:4723").toURL();
            driver = new AppiumDriver(url, capabilities);
            
            System.out.println("Driver initialized: " + (driver != null)); // Check if driver is initialized
    }

    
	@Test
	public void CheckTheCalculatorTest() {
	
		driver.findElement(By.id("com.google.android.calculator:id/digit_2")).click();
		driver.findElement(By.id("com.google.android.calculator:id/op_add")).click();
		driver.findElement(By.id("com.google.android.calculator:id/digit_6")).click();
		driver.findElement(By.id("com.google.android.calculator:id/eq")).click();
		
		String result = driver.findElement(By.id("com.google.android.calculator:id/result")).getText();
        Assert.assertEquals(result, "8");
	}
	@Test
	public void CheckTheCalculatorTest1() {
		
		driver.findElement(By.id("com.google.android.calculator:id/digit_7")).click();
		driver.findElement(By.id("com.google.android.calculator:id/op_sub")).click();
		driver.findElement(By.id("com.google.android.calculator:id/digit_3")).click();
		driver.findElement(By.id("com.google.android.calculator:id/eq")).click();
		
		String result = driver.findElement(By.id("com.google.android.calculator:id/result")).getText();
        Assert.assertEquals(result, "4");
	}
	@Test
	public void CheckTheCalculatorTest2() {
		
		driver.findElement(By.id("com.google.android.calculator:id/digit_5")).click();
		driver.findElement(By.id("com.google.android.calculator:id/op_mul")).click();
		driver.findElement(By.id("com.google.android.calculator:id/digit_4")).click();
		driver.findElement(By.id("com.google.android.calculator:id/eq")).click();
		
		String result = driver.findElement(By.id("com.google.android.calculator:id/result")).getText();
        Assert.assertEquals(result, "20");
	}
	@Test
	public void CheckTheCalculatorTest3() {
		
		driver.findElement(By.id("com.google.android.calculator:id/digit_9")).click();
		driver.findElement(By.id("com.google.android.calculator:id/op_div")).click();
		driver.findElement(By.id("com.google.android.calculator:id/digit_3")).click();
		driver.findElement(By.id("com.google.android.calculator:id/eq")).click();
		
		String result = driver.findElement(By.id("com.google.android.calculator:id/result")).getText();
        Assert.assertEquals(result, "3");
	}
	
	@AfterClass
	static public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}