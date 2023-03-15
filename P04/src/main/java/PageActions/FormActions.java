package PageActions;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;


public class FormActions  {

    @FindBy(xpath = "//input[@id='firstName']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@id='lastName']")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@id='userEmail']")
    private WebElement emailField;

    @FindBy(xpath = "//label[@for='gender-radio-1']")
    private WebElement genderRadioBtn;

    @FindBy(xpath = "//input[@id='userNumber']")
    private WebElement mobileField;

    @FindBy(xpath = "//div[@id='state']")
    private WebElement stateField;

    @FindBy(xpath = "//button[@id='submit']")
    private WebElement submitBtn;

    @FindBy(xpath = "//div[@id='example-modal-sizes-title-lg']")
    private WebElement modalTitle;

    @FindBy(xpath = "//div[@class='table-responsive']")
    public WebElement TableElement;

    //public String[] formData = {"First name", "Last name", "First name Last name","qa@i.ua","Male","1112223334" };
    public Map<String, String> formData = new HashMap<>(){{
        put("1stName","First name");
        put("2stName","Last name");
        put("12_Name","First name Last name");
        put("email","qa@i.ua");
        put("gender","Male");
        put("ph_number","1112223334");
    }};



    private WebDriver driver;
    private WebDriverWait wait;
    public FormActions (WebDriver driver){
        this.driver=driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void open(){
        driver.navigate().to("https://demoqa.com/automation-practice-form");
        driver.manage().window().setSize(new Dimension(760,960));
    }


    public void firstNameFieldSK() {
        firstNameField.sendKeys(formData.get("1stName"));}
    public void lastNameFieldSK() {
        lastNameField.sendKeys(formData.get("2stName"));
    }
    public void emailFieldSK() {
        emailField.sendKeys(formData.get("email"));
    }
    public void genderRadioBtnClick() {genderRadioBtn.click();}
    public void mobileFieldSK() {
        mobileField.sendKeys(formData.get("ph_number"));
    }
    //public void stateFieldclick() { stateField.click();}
    public void submitBtnClick() { submitBtn.click();}
    public String getModalTitle() {  return modalTitle.getText(); }

    public void scrollPage(){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();",submitBtn);
     }
}


