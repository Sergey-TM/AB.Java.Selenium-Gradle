import PageActions.WidgetsActions;
import Settings.WebDriverSettings;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;

public class WidgetsTests extends WebDriverSettings {
    @Test
    public void test3() throws InterruptedException {
        //pageFactory
        WidgetsActions widgetsActions = PageFactory.initElements(driver, WidgetsActions.class);
        //open Page
        widgetsActions.open();
        //sleep 3sec
        Thread.sleep(3000);
        //move slider
        widgetsActions.moveSlider();
        //verify selected value
        Assert.assertEquals(widgetsActions.getsliderValue(), "56");
    }
}


