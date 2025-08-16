package week4.day2;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
public class AlertInteraction {

	public static void main(String[] args) {
		 // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Load the URL
        driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");

        // Maximize the browser
        driver.manage().window().maximize();

        // Add implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Switch to the frame containing the button
        driver.switchTo().frame("iframeResult");

        // Click the "Try It" button
        driver.findElement(By.xpath("//button[text()='Try it']")).click();

        // Switch to the alert
        Alert promptAlert = driver.switchTo().alert();

        // Send input text to the prompt
        String name = "Sindhuja";
        promptAlert.sendKeys(name);

        // Click OK in the alert
        promptAlert.accept(); 

        // Verify the displayed text after clicking OK
        String resultText = driver.findElement(By.id("demo")).getText();

        if (resultText.contains(name)) {
            System.out.println("✅ OK clicked successfully. Text: " + resultText);
        } else {
            System.out.println("❌ Verification failed. Text: " + resultText);
        }

        // Close the browser
        //driver.quit();
    }

	}


