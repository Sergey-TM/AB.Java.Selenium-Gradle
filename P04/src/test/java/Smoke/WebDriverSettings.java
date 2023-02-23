package Smoke;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class WebDriverSettings {

        public WebDriver driver;
        public WebDriverWait wait;

        @BeforeTest
        public void setUp() {
            System.setProperty("webdriver.chrome.driver","C:\\Program Files\\DriversSelenium\\chromedriver.exe");
            driver = new ChromeDriver();
            wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        }

        @AfterTest
        public void close() {
            driver.close();
            driver.quit();
       }
}
