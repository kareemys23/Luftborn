package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;

import com.github.javafaker.Faker;

public class PreTest {
	
	public static WebDriver ChromeDriverObject;
	public Faker fake=new Faker();
	public String NewEmail = "test" + fake.number().digits(5) + "@gmail.com";
	public String Phone = fake.number().digits(11);

@BeforeMethod
public void Open() throws InterruptedException, IOException {
		
		System.setProperty("webdriver.edge.driver","D:\\Testing\\Luftborn\\msedgedriver.exe");
		EdgeOptions options = new EdgeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriverObject = new EdgeDriver(options);
		Reporter.log("Edge browser is opened");
		
		Properties properties = new Properties();
		FileInputStream inputstream = new FileInputStream("D:\\Testing\\Luftborn\\Luftborn\\Properties\\testdata.properties");
		properties.load(inputstream);
		ChromeDriverObject.navigate().to(properties.getProperty("url"));
		ChromeDriverObject.manage().window().maximize();
		Reporter.log("Chrome browser is maximized");
	}
}
