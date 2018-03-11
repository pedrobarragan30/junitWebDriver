package homeworks;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WordReferenceParent {
	
	protected WebDriver driver;

	public void setUp(String urlToOpen, String browserToUse) {
		switch(browserToUse) {
		case "chrome":
			System.out.println("Arranca el browser " + browserToUse + " y navega a la pagina: " + urlToOpen);
			//System.setProperty("webdriver.chrome.driver", "C:\\test_automation\\drivers\\chromedriver.exe");

			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-infobars");
			options.addArguments("-disable-notifications");
			options.addArguments("--start-maximized");

			driver = new ChromeDriver(options);
		   break;
		case "firefox":
			System.out.println("Arranca el browser " + browserToUse + " y navega a la pagina: " + urlToOpen);
			//System.setProperty("webdriver.gecko.driver", "C:\\test_automation\\drivers\\geckodriver.exe");
			
			driver = new FirefoxDriver();
			break;
		case "edge":
			System.out.println("Arranca el browser " + browserToUse + " y navega a la pagina: " + urlToOpen);
			//System.setProperty("webdriver.edge.driver, "C:\\test_automation\\drivers\\geckodriver.exe");
			
			driver = new EdgeDriver();
			break;
		//case "IE":
		//	System.out.println("Arranca el browser " + browserToUse + " y navega a la pagina: " + urlToOpen);
			//System.setProperty("webdriver.ie.driver", "C:\\test_automation\\drivers\\geckodriver.exe");
		//	
		//	driver = new InternetExplorerDriver();
		//	break;
		default:
			System.out.println("The Browser " + browserToUse + " is NOT supported");
		}
		
		driver.get(urlToOpen);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	
	public void wrreverse() {
		WebElement tab = driver.findElement(By.partialLinkText("WR Reverse"));
		
		tab.click();
	}

	public void seeAlso(int numberOfElementToSearch) {
		WebElement linksTable = driver.findElement(By.id("link"));
		List <WebElement> totalTerms = linksTable.findElements(By.xpath("//*[@id='link']/ul/li"));
		
		
		assertTrue(numberOfElementToSearch <= totalTerms.size());
		WebElement link = totalTerms.get(numberOfElementToSearch-1).findElement(By.tagName("a"));
		link.click();
	}

	public void search(String searchTerm) {
		WebElement searchField = driver.findElement(By.className("ac-input"));
		WebElement submitButton = driver.findElement(By.className("submit-button"));
		
		searchField.clear();
		searchField.sendKeys(searchTerm);
		submitButton.click();		
	}
	
	public void searchInternal(String searchTerm) {
		WebElement searchField = driver.findElement(By.id("si"));
				
		searchField.clear();
		searchField.sendKeys(searchTerm);
		
		WebElement submitButton = new WebDriverWait(driver,15).until(ExpectedConditions.visibilityOfElementLocated(By.id("searchBtn")));
		submitButton = new WebDriverWait(driver,15).until(ExpectedConditions.elementToBeClickable(By.id("searchBtn")));
		submitButton.click();		
	}	
	
	@After
	public void tearDown() {
		driver.quit();
	}
}