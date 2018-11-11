import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class TableGridTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\c-deepak.jindal\\Desktop\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.cricbuzz.com/live-cricket-scorecard/20310/aus-vs-rsa-3rd-odi-south-africa-tour-of-australia-2018");
		WebElement table = driver.findElement(By.xpath("(//div[@class='cb-col cb-col-100 cb-ltst-wgt-hdr'])[1]"));
		int count= table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).size();
		int sum=0;
		for(int i=0; i<count-2 ;i++)
		{
			table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).get(i).getText();
			String currentValueInString = table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).get(i).getText();
			int currentValueInInteger =  Integer.parseInt(currentValueInString);
			sum = sum + currentValueInInteger;
		}
		System.out.println("Runs scored by batsmen" +sum); //Total runs scored by all the batsmen combined
		String ExtraRuns = driver.findElement(By.xpath("//div[text()='Extras']/following-sibling::div[1]")).getText();
		int extraRunsInInteger = Integer.parseInt(ExtraRuns);
		System.out.println("Extra Runs are " + sum);
		int CalculatedTotal = sum + extraRunsInInteger;
		String actualTotalInSring = driver.findElement(By.xpath("//div[text()='Total']/following-sibling::div[1]")).getText() ;
		int actualTotalInInteger = Integer.parseInt(actualTotalInSring);
		System.out.println("Actual Total is " + actualTotalInInteger);
		if(CalculatedTotal==actualTotalInInteger)
		{
			System.out.println("Total is working fine");
		}

	}

}
