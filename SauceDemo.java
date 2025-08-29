package test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SauceDemo {

	public static void main(String[] args) throws IOException {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("guest");
		
		ChromeDriver driver=new ChromeDriver(option);
		
		driver.get("https://www.saucedemo.com/v1/");
		driver.manage().window().maximize();
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		
				driver.findElement(By.id("login-button")).click();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		 WebElement productname = driver.findElement(By.className("inventory_item_name"));
		
		 String text=productname.getText();
		System.out.println("product details :"+text);
		String price=driver.findElement(By.className("inventory_item_price")).getText();
		String productprice=price.replace("$", "");
		System.out.println("product price :"+productprice);
		driver.findElement(By.xpath("//button[contains(@class,'btn')]")).click();
	 driver.findElement(By.xpath("//span[@class='fa-layers-counter shopping_cart_badge']")).click();
	String iconprice=driver.findElement(By.className("inventory_item_price")).getText();
	System.out.println("iconprice :"+iconprice);
	if(productprice.equals(iconprice)) {
		System.out.println("It matches the product price in inventory:"+iconprice);
	}
	else {
		System.out.println("It doesn't matches the product price in inventory:"+iconprice);
	}
		driver.findElement(By.xpath("//a[text()='CHECKOUT']")).click();
		driver.findElement(By.id("first-name")).sendKeys("Eren");
		driver.findElement(By.id("last-name")).sendKeys("Yeager");
		driver.findElement(By.id("postal-code")).sendKeys("40/2 ,puthu road,peravurani,Thanjavur");
		driver.findElement(By.xpath("//input[@value='CONTINUE']")).click();
		   List <Double> ele =new ArrayList<Double>();
		List<WebElement> list = driver.findElements(By.className("inventory_item_price"));
		 for(int i=0;i<list.size();i++) {
			  String secondLprice = list.get(i).getText();
			  secondLprice=secondLprice.trim().replaceAll("$","");
			  System.out.println(secondLprice);
		 }
		 Collections.sort(ele);
		 if (ele.size() >= 2) {
			    double secondLargest = ele.get(ele.size() - 2);
			    System.out.println("Second largest price = $" + secondLargest);
			} else {
			    System.out.println(" " + ele);
			}
		 
		 
		 
			  
		
		
		
		
		
		
		driver.findElement(By.xpath("//a[contains(@href,'complete.html')]")).click();
		 
		
		
		
		
		
		
		
		File source =driver.getScreenshotAs(OutputType.FILE);
		   File destination = new File("./Screenshots/saucecode.png");
		   FileUtils.copyFile(source, destination);
		   driver.quit();
		  

		
		
		
		
	}

}
