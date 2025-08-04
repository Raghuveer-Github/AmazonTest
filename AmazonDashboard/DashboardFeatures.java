package AmazonDashboard;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import GenericLibrary.BaseClass;

public class DashboardFeatures extends BaseClass {
			
	@Test
	public void dashbordTest() throws Throwable{

		driver.findElement(By.xpath("//a[text()='Mobiles']")).click();

		WebElement samsungGalaxyS24 = driver.findElement(By.xpath("//*[@id='acsProductBlockV2-2']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", samsungGalaxyS24);
		samsungGalaxyS24.click();
		

	}

}
