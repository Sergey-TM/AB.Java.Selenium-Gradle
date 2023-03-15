package PageActions;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class TabsActions  {

    @FindBy(xpath = "//button[@id='tabButton']")
    private WebElement newtabBtn;

    @FindBy(xpath = "//h1[@id='sampleHeading']")
    private WebElement newtabtext;



    private WebDriver driver;
    private WebDriverWait wait;
    public TabsActions (WebDriver driver){
        this.driver=driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void open(){
        driver.navigate().to("https://demoqa.com/browser-windows");
        driver.manage().window().maximize();
    }

    public void switchTo(String tab){
        driver.switchTo().window(tab);
    }

    public String getT(){
        return driver.getTitle();
    }

    public void clickOnNewtabBtn(){
        newtabBtn.click();
    }

    public String getLastTabtext(){
        waitUntilElementClickable(newtabtext);
        return newtabtext.getText();
    }


    public void switchtolastTab(){
        for(String tab : driver.getWindowHandles()) {
            driver.switchTo().window(tab);
        }}

    public String get1stTab(){
        return driver.getWindowHandle();
    }



    public void waitUntilElementClickable(WebElement element) throws Error{
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }
        catch(NoSuchElementException e){
            throw new Error("Element not loaded yet");
        }
    }
}
