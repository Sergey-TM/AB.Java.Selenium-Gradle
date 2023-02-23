import PageActions.TabsActions;
import Settings.WebDriverSettings;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.Assert;


public class TabsTest extends WebDriverSettings {
    @Test
    public void test2() throws InterruptedException {
        //pageFactory
        TabsActions tabsActions = PageFactory.initElements(driver, TabsActions.class);
        //open Page
        tabsActions.open();
        // remember first tab
        String maintab = tabsActions.get1stTab();
        //click on button
        tabsActions.clickOnNewtabBtn();
        //switch to new tab
        tabsActions.switchtolastTab();
        //verify text
        Assert.assertEquals(tabsActions.getLastTabtext(), "This is a sample page");
        //switch to 1st tab
        tabsActions.switchTo(maintab);
        //System.out.println(driver.getTitle());
        //verify 1st tab title
        Assert.assertEquals(tabsActions.getT(),"DEMOQA");
    }
}






