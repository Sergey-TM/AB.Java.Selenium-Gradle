package Settings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


import java.time.Duration;

public class WebDriverSettings {

        public WebDriver driver;
        public WebDriverWait wait;

        @BeforeClass
        public void setUp() {
            System.setProperty("webdriver.chrome.driver","C:\\Program Files\\DriversSelenium\\chromedriver.exe");
            driver = new ChromeDriver();
            wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        }

        @AfterClass
        public void close() {
            driver.close();
            driver.quit();
       }
}
