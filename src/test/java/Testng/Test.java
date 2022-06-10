package Testng;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {
	public static void main(String[] args) throws InterruptedException,IndexOutOfBoundsException, IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://spring-petclinic-community.herokuapp.com/owners/9/pets/new");
		Properties prop=new Properties();
		FileInputStream file=new FileInputStream("C:/Users/a778837/eclipse-workspace/practice/src/test/resources/properties/Data.properties");
		prop.load(file);
		driver.findElement(By.id("name")).sendKeys(prop.getProperty("Name"));
		driver.findElement(By.id("birthDate")).sendKeys(prop.getProperty("DOB"));
		WebElement element=driver.findElement(By.xpath("//*[@id='type']"));
		Select select =new Select(element);
		select.getOptions();
		select.selectByVisibleText("snake");
		driver.findElement(By.xpath("//*[@class='btn btn-default']")).click();
		 
	}
}



