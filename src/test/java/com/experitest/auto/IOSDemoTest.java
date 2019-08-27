package com.experitest.auto;

import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class IOSDemoTest extends BaseTest {
	protected IOSDriver<IOSElement> driver = null;

	@Before
	public void setUp() throws Exception {
		init("@os='ios'");
		// Init application / device capabilities
		dc.setCapability(MobileCapabilityType.APP, "cloud:com.experitest.ExperiBank");
		dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.ExperiBank");
		dc.setCapability("testName", "IOSDemoTest");
		driver = new IOSDriver<>(new URL(getProperty("url", cloudProperties) + "/wd/hub"), dc);
	}

	@Test
	public void test() {
		driver.rotate(ScreenOrientation.PORTRAIT);
		driver.findElement(By.xpath("//*[@id='usernameTextField']")).sendKeys("company");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//*[@id='passwordTextField']")).sendKeys("company");
		driver.findElement(By.xpath("//*[@id='loginButton']")).click();
		driver.findElement(By.xpath("//*[@id='makePaymentButton']")).click();
		driver.findElement(By.xpath("//*[@id='phoneTextField']")).sendKeys("0541234567");
		driver.findElement(By.xpath("//*[@id='nameTextField']")).sendKeys("Jon Snow");
		driver.findElement(By.xpath("//*[@id='amountTextField']")).sendKeys("50");
		driver.findElement(By.xpath("//*[@id='countryButton']")).click();
		driver.findElement(By.xpath("//*[@id='Switzerland']")).click();
		driver.findElement(By.xpath("//*[@id='sendPaymentButton']")).click();
		driver.findElement(By.xpath("//*[@id='Yes']")).click();

	}

	@After
	public void tearDown() {
		driver.quit();
	}

}
