package stepdefination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.*;

public class AdminLogin {
public static WebDriver driver;
	@Given("I open browser and enter url as {string}")
	public void i_open_browser_and_enter_url_as(String url) {
	    System.setProperty("webdriver.chrome.driver", "Drivers//chromedriver.exe");
	    driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	    driver.get(url);
	}
	@Then("I see Admin Login page with page title as {string}")
	public void i_should_see_admin_login_page_with_page_title_as(String expTitle) {
	  String actTitle=driver.getTitle();
	  Assert.assertEquals(actTitle, expTitle);
	}
	@When("I enter username as {string}")
	public void i_enter_username_as(String username) {
	    driver.findElement(By.id("txtUsername")).sendKeys(username);
	}
	@When("I enter password as {string}")
	public void i_enter_password_as(String password) {
		 driver.findElement(By.id("txtPassword")).sendKeys(password);
	}
	@When("I click on login button")
	public void i_click_on_login_button() {
	   driver.findElement(By.id("btnLogin")).click();
	}
	@Then("I  see admin dashboard with {string} Module link")
	public void i_should_see_admin_dashboard_with_module_link(String link) {
	    boolean isPresent=driver.findElement(By.linkText(link)).isDisplayed();
	    Assert.assertTrue(isPresent);
	}
	@When("I click on logout button")
	public void i_click_on_logout_button() {
	    driver.findElement(By.id("welcome")).click();
	    driver.findElement(By.linkText("Logout")).click();
	}
	
}
