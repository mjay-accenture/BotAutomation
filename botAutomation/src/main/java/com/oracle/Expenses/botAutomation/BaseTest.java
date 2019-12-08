package com.oracle.Expenses.botAutomation;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseTest {
	
	public static RequestSpecification httprequest;
	public static Response response;
	public static WebDriver driver;
	public Logger logger;
	

	@BeforeClass
	public void setup()
	{
		logger=Logger.getLogger("BOT Automation Rest API");
		PropertyConfigurator.configure("Log4j.properties");
		logger.setLevel(Level.DEBUG);
	}
	
	public BaseTest() {
		
		
		
		
		 /* try (InputStream input = new FileInputStream("config.properties")) {

			  
			  
	            Properties prop = new Properties();

	            // load a properties file
	            prop.load(input);

	            // get the property value and print it out
	            System.out.println(prop.getProperty("username"));
	            System.out.println(prop.getProperty("password"));
	            
	          
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
*/
}
	
}
