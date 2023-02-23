package PageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class TableActions {

    private WebElement tableElement;
    private WebDriverWait wait;
    private WebDriver driver;

    public TableActions(WebElement tableElement, WebDriver driver){
        this.tableElement = tableElement;
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public List<WebElement> getRows(){
        List<WebElement> rows = tableElement.findElements(By.xpath(".//tr"));
        rows.remove(0);
        return rows;
    }

    public List<WebElement> getHeadings(){
        WebElement headingRow = tableElement.findElement(By.xpath(".//tr[1]"));
        List<WebElement> headingcolumns = headingRow.findElements(By.xpath("./th"));
        return headingcolumns;
    }

    public List<List<WebElement>> getRowsWithcolumns(){
        List<WebElement> rows = getRows();
        List<List<WebElement>> rowsWithColumns = new ArrayList<List<WebElement>>();
        for (WebElement row : rows){
            List<WebElement> rowWithColumns = row.findElements(By.xpath(".//td"));
            rowsWithColumns.add(rowWithColumns);
        }
        return rowsWithColumns;
    }

    public String getValueFromCell(int rowNumber, int columnNumber){
        List<List<WebElement>> rowWithColumns = getRowsWithcolumns();
        WebElement cell = rowWithColumns.get(rowNumber - 1).get(columnNumber - 1);
        return cell.getText();
    }

}
