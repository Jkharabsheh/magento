package mytestcases;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Signup extends parameters {

	WebDriver driver = new ChromeDriver();

	@BeforeTest
	public void Mysetup() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}

	@Test(priority = 1)
	public void MyFirstTest() throws InterruptedException {

		driver.get("https://magento.softwaretestingboard.com/");
		driver.findElement(By.linkText("Create an Account")).click();

		// find the elements
		WebElement FirstName = driver.findElement(By.id("firstname"));
		WebElement lastName = driver.findElement(By.id("lastname"));
		WebElement Email = driver.findElement(By.id("email_address"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement Confirmpassword = driver.findElement(By.id("password-confirmation"));

		WebElement CreateAccountButtonElement = driver.findElement(By.cssSelector("button[title='Create an Account']"));

		// interact with the elements
		FirstName.sendKeys(Firstnames[randomindex]);
		lastName.sendKeys(lastnames[randomindex]);
		Email.sendKeys(Emailid);
		password.sendKeys(CommonPassword);
		Confirmpassword.sendKeys(CommonPassword);

		CreateAccountButtonElement.click();
		Thread.sleep(2000); // u just needed this line I believe
		String WelomeMsg = driver.findElement(By.xpath("//li[@class='greet welcome']")).getText();
		System.out.println(WelomeMsg);
		assertEquals(WelomeMsg.contains("Welcome"), true);
		Thread.sleep(3000);
	}

	@Test(priority = 2)
	public void logoutprocess() throws InterruptedException {

		driver.get("https://magento.softwaretestingboard.com/customer/account/logout/");
		Thread.sleep(2000);
		assertEquals(driver.getCurrentUrl().contains("logoutSuccess"), true);
	}

	@Test(priority = 3)
	public void loginprocess() throws InterruptedException {
		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.id("email")).sendKeys(Emailid);
		driver.findElement(By.id("pass")).sendKeys(CommonPassword);

		driver.findElement(By.id("send2")).click();
		Thread.sleep(3000);

		String WelomeMsg = (driver.findElement(By.cssSelector(".greet.welcome")).getText());
		assertEquals(WelomeMsg.contains("Welcome"), true);
	}

	@Test(priority = 4 , enabled= false )
	public void addOneRandomItem() throws InterruptedException {
		driver.get("https://magento.softwaretestingboard.com/");

		WebElement ItemsContainer = driver.findElement(By.cssSelector(".product-items.widget-product-grid"));
		int numberofitems = ItemsContainer.findElements(By.tagName("li")).size();
		// System.out.println(numberofitems);
		int randomItemToSelect = rand.nextInt(4);
		ItemsContainer.findElements(By.tagName("li")).get(randomItemToSelect).click();
		WebElement sizesContainer = driver.findElement(By.cssSelector(".swatch-attribute.size"));
		int theSizes = (sizesContainer.findElements(By.className("swatch-option")).size());
		sizesContainer.findElements(By.className("swatch-option")).get(rand.nextInt(theSizes)).click();

		Thread.sleep(2000);
		WebElement colorsContainer = driver.findElement(By.cssSelector(".swatch-attribute.color"));
		int thecolors = colorsContainer.findElements(By.className("swatch-option")).size();
		colorsContainer.findElements(By.className("swatch-option")).get(rand.nextInt(thecolors)).click();

		Thread.sleep(2000);
		driver.findElement(By.id("product-addtocart-button")).click();

		Thread.sleep(3000);

		String ActualMsg = driver.findElement(By.cssSelector(".page.messages")).getText();
		System.out.println(ActualMsg);
		assertEquals(ActualMsg.contains("You added"), true);

	}

}
