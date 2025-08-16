package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WindowHandling {

	public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
		
		// Launch the browser
		ChromeDriver driver1 = new ChromeDriver(options);
		
		// Load the url - get
		driver1.get("http://leaftaps.com/opentaps/control/main");
		
		// Maximize the browser
		driver1.manage().window().maximize();
		driver1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Enter username
        driver1.findElement(By.id("username")).sendKeys("demosalesmanager");

        // Enter password
        driver1.findElement(By.id("password")).sendKeys("crmsfa");

        // Click Login
        driver1.findElement(By.className("decorativeSubmit")).click();

        // Click CRM/SFA
        driver1.findElement(By.linkText("CRM/SFA")).click();

        // Click Contacts
        driver1.findElement(By.linkText("Contacts")).click();

        // Click Merge Contacts
        driver1.findElement(By.linkText("Merge Contacts")).click();

				// Click on the "From Contact" widget
		        driver1.findElement(By.xpath("//img[@alt='Lookup']")).click();

		        // Switch to new window
		        Set<String> allWindows = driver1.getWindowHandles();
		        List<String> windowList = new ArrayList<>(allWindows);
		        driver1.switchTo().window(windowList.get(1));

		        // Click the first resulting contact
		        driver1.findElement(By.xpath("(//a[@class='linktext'])[1]")).click();

		        // Switch back to parent window
		        driver1.switchTo().window(windowList.get(0));

		        // Click on the "To Contact" widget
		        driver1.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();

		        // Switch to new window again
		        allWindows = driver1.getWindowHandles();
		        windowList = new ArrayList<>(allWindows);
		        driver1.switchTo().window(windowList.get(1));

		        // Click the second resulting contact
		        driver1.findElement(By.xpath("(//a[@class='linktext'])[2]")).click();

		        // Switch back to parent window
		        driver1.switchTo().window(windowList.get(0));

		        // Click Merge button
		        driver1.findElement(By.className("buttonDangerous")).click();

		        // Accept the alert
		        Alert alert = driver1.switchTo().alert();
		        alert.accept();

		        // Verify the title of the page
		        String title = driver1.getTitle();
		        if (title.contains("View Contact")) {
		            System.out.println("Merge Successful - Title Verified: " + title);
		        } else {
		            System.out.println("Merge Failed - Title is: " + title);
		        }

		        // Close browser
		        driver1.quit();
		    }
		}
				