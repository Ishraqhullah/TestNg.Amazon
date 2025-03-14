package In.Amazon;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkoutPage {
	static WebDriver driver;
	
	@Test(priority = 0)
	public void LaunchBrowser() {
		WebDriverManager.edgedriver().setup();
		EdgeOptions options = new EdgeOptions();
		options.addArguments("--start-maximized");
		//options.addArguments("--headless");
		options.addArguments("--disable-notification");
		driver = new EdgeDriver(options);
		String url = "https://www.amazon.in/";
		driver.get(url);
	}
	@Test(priority = 1)
	 public void Search_Bar() {
		 WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		 search.sendKeys("sg english willow",Keys.ENTER);
		 
	 }
	@Test(priority = 2)
	public void Select_Item() {
		WebElement savage = driver.findElement(By.xpath("//span[contains(text(),'SG Savage Strike English-Willow Cricket Bat, Short Handle')]"));
		savage.click();
	}
	@Test(priority = 3)
	public void Tab_Shift() {
		Set<String> handles = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList <String>(handles);
		driver.switchTo().window(tabs.get(1));
	}
	@Test(priority = 4)
public void Bat_Name() {
	WebElement name = driver.findElement(By.id("productTitle"));
		String Brand = name.getText();
		System.out.println(Brand);
	}

}
