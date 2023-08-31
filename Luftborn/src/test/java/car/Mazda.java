package car;

import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import base.PreTest;

public class Mazda extends PreTest{
	@Test
	public void search() throws InterruptedException, IOException {
		
		//Entering valid data
		// Load the properties file
		Properties properties = new Properties();
		FileInputStream inputstream = new FileInputStream("D:\\\\Testing\\\\Luftborn\\\\Luftborn\\\\Properties\\\\testdata.properties");
		properties.load(inputstream);
		Reporter.log("Data is loaded from properties file.");

		// Retrieve the values from the properties file
		String Car = properties.getProperty("car");

		// Find the form fields using their XPaths and add values
		Thread.sleep(5000);
		WebElement Search_field = ChromeDriverObject.findElement(By.xpath("//*[@placeholder=\"Search for anything\"]"));
		Search_field.sendKeys(Car);
	
		// Click on search button
		Thread.sleep(5000);
		WebElement search_btn = ChromeDriverObject.findElement(By.xpath("//*[@value=\"Search\"]"));
		search_btn.click();
		
		// Validate search result
		String actualString = ChromeDriverObject.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/div/div[2]/div[1]/div[1]/h1/span[2]")).getText();
		assertTrue(actualString.contains(Car));
		System.out.println(actualString);
		
		// Logging the number of obtained in search results
		String car_num = ChromeDriverObject.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/div/div[2]/div[1]/div[1]/h1/span[1]")).getText();
		Reporter.log("Number of shown cars: " + car_num);
		System.out.println("Number of shown cars: " + car_num);
		
		// Choosing manual transmission
		Thread.sleep(5000);
		WebElement manual_btn = ChromeDriverObject.findElement(By.xpath("//*[@id=\"x-refine__group_1__0\"]/ul/li[1]/div/a/div/span"));
		manual_btn.click();
		
		// Logging the number of obtained in search results after filtering
		String manual_num = ChromeDriverObject.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/div/div[2]/div[1]/div[1]/h1/span[1]")).getText();
		Reporter.log("Number of shown cars after filter: " + manual_num);
		System.out.println("Number of shown cars after filter: " + manual_num);
		
		ChromeDriverObject.quit();
}
	}