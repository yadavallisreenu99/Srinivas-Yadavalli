package stepDefinitions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	
	public WebDriver driver;
	
	
	public TestBase()
	
	{
		
			initialize();
		
	
	}
 
	public Properties getProperties() throws IOException
	{
		 Properties properties;
		String propertyFilePath= "Resources//Config.properties";
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}		
		return properties;
		
	}
	
	private void initialize() {
		
		try {
		
			System.setProperty("webdriver.chrome.driver", "/Users/sreenivasu.yadavalli/ChromeDriver/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		catch(Exception ie)
		{
			ie.printStackTrace();
		}
		
	}
	
	public WebDriver getDriver()
	{
		return driver;
	}
	
	public void destroyDriver()
	{
		driver.quit();
		//driver=null;
	}


	

}
