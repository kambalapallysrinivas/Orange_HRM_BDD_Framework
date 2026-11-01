package stepdefination;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerExample {
	
	public static void main(String[]args) {
		System.setProperty("webdriver.chrome.driver","Drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://jqueryui.com/datepicker/");
		driver.switchTo().frame(0);
		driver.findElement(By.id("datepicker")).click();
		String date="4/September/2028";
		String [] d=date.split("/");
		String setDate=d[0];
		String setMonth=d[1];
		String setYear=d[2];
		
		while(driver.findElement(By.linkText("Next")).isEnabled()) {
			String month=driver.findElement(By.className("ui-datepicker-month")).getText();
			String year=driver.findElement(By.className("ui-datepicker-year")).getText();
			if(year.equalsIgnoreCase(setYear)&& month.equalsIgnoreCase(setMonth)) {
				WebElement table=driver.findElement(By.className("ui-datepicker-calendar"));
				List<WebElement> rows=table.findElements(By.tagName("tr"));
				for(int i=0;i<rows.size();i++) {
					List<WebElement>columns	=rows.get(i).findElements(By.tagName("td"));
					for(int j=0;j<columns.size();j++) {
						System.out.println(columns.get(j).getText());
						if(columns.get(j).getText().equalsIgnoreCase(setDate)){
							columns.get(j).click();
							break;
						}
					}
				}
				break;
			}
			driver.findElement(By.linkText("Next")).click();
			
		}
	}

}
