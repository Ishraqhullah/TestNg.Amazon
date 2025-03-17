package In.Amazon;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

public class EnglishWillowBat {
	static WebDriver driver;
	static WebElement search;
	
	@DataProvider(name="Data")
	public Object[][] DP(){
		return new Object[][] {{"sg cricket bat"}};
	}
	@BeforeSuite(groups="Avoid")
	public void BS() {
		
	}
	@BeforeTest(groups="Avoid")
	public void BT() {
		
	}
	@AfterTest(groups="Avoid")
	public void AT() {
		
	}
	@AfterSuite(groups="Avoid")
	public void AS() {
		
	}
	
	@BeforeClass(groups="run")
	public void LaunchBrowser() {
    	WebDriverManager.edgedriver().setup();
    	EdgeOptions options = new EdgeOptions();
    		
		options.addArguments("--start-maximized");
		options.addArguments("--headless");
		options.addArguments("--disable-notification");
		
		driver = new EdgeDriver(options);
		String url = "https://www.amazon.in/";
		driver.get(url);
	}
	
	@Test(priority = 0, dataProvider= "Data", groups="run")
	public void Search_Bar(String Inputvalue) {
		WebElement search = driver.findElement(By.xpath("//input[contains(@type,'text')]"));
		search.sendKeys(Inputvalue, Keys.ENTER);

	}

	@Test(priority = 1, groups="run")
	public void Select_Item() {
		WebElement savage = driver.findElement(
				By.xpath("//span[contains(text(),'SG Savage Strike English-Willow Cricket Bat, Short Handle')]"));
		savage.click();
	}

	@Test(priority = 2, groups="run")
	public void Tab_Shift() {
		Set<String> handles = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<String>(handles);
		driver.switchTo().window(tabs.get(1));
	}

	@Test(priority = 3, groups="run")
	public void Bat_Name() {
		WebElement name = driver.findElement(By.id("productTitle"));
		String Brand = name.getText();
		System.out.println(Brand);
	}

	@Test(priority = 4, groups="run")
	public void SG_Bat() {

		try {
			TakesScreenshot tk = (TakesScreenshot) driver;
			File src = tk.getScreenshotAs(OutputType.FILE);
			File desc = new File(
					"C:\\Users\\Ishraq\\eclipse-workspace\\Amazon.TestNG\\src\\test\\resources\\SG BAt.png");
			FileUtils.copyFile(src, desc);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	@Test(priority = 5, groups="run")
	public void Product_Price() {
		WebElement price = driver.findElement(By.xpath("//div[contains(@class,'a-section a-spacing-none aok-align')]"));
		String text1 = price.getText();
		System.out.println(text1);
	}

	@Parameters({"Ishraq"})
	@BeforeMethod
	public void Start(String value) {
		System.out.println(value);
	}

	@AfterMethod
	public void End() {
		System.out.println("End");
	}

	@AfterClass(groups="run")
	public void closeBrowser() {
		driver.quit();
	}

}
