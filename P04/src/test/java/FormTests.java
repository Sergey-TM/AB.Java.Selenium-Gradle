import PageActions.FormActions;
import PageActions.TabsActions;
import PageActions.TableActions;
import Settings.WebDriverSettings;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;


public class FormTests extends WebDriverSettings {
    @Test
    public void test1() throws InterruptedException {
        //pageFactory
        FormActions formActions = PageFactory.initElements(driver, FormActions.class);
        TabsActions tabsActions = PageFactory.initElements(driver, TabsActions.class);
        //open Page
        formActions.open();
        //fill form with valid data
        formActions.firstNameFieldSK();
        formActions.lastNameFieldSK();
        formActions.emailFieldSK();
        formActions.genderRadioBtnClick();
        formActions.mobileFieldSK();
        //scroll the page
        formActions.scrollPage();
        //submit form
        formActions.submitBtnClick();
        //switch to modal
        tabsActions.switchtolastTab();
        //verify modal title
        Thread.sleep(2000);
        Assert.assertEquals(formActions.getModalTitle(), "Thanks for submitting the form");
        //verify modal data
        TableActions tableActions = new TableActions(formActions.TableElement, driver);
        Assert.assertEquals(tableActions.getValueFromCell(1,2), formActions.formData[2]);
        Assert.assertEquals(tableActions.getValueFromCell(2,2), formActions.formData[3]);
        Assert.assertEquals(tableActions.getValueFromCell(3,2), formActions.formData[4]);
        Assert.assertEquals(tableActions.getValueFromCell(4,2), formActions.formData[5]);
    }
}
