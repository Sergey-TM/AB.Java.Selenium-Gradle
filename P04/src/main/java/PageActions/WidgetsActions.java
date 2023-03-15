package PageActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class WidgetsActions  {

//Locators
    @FindBy(xpath = "//input[@type='range']")
    private WebElement slider;

    @FindBy(xpath = "//input[@id='sliderValue']")
    private WebElement sliderValue;


//Methods
    private WebDriver driver;
    private WebDriverWait wait;
    public WidgetsActions (WebDriver driver){
        this.driver=driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public void open(){
        driver.navigate().to("https://demoqa.com/slider");
        driver.manage().window().maximize();
    }
    public void  moveSlider() {
        Actions action = new Actions(driver);
        action.dragAndDropBy(slider, 30, 255).perform();
    }
    public String getsliderValue(){
        return sliderValue.getAttribute("value");
    }
}
