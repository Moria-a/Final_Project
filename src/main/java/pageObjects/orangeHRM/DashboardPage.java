package pageObjects.orangeHRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class DashboardPage
{
    @FindBy(how = How.CSS, using = "*[class='oxd-grid-3 orangehrm-dashboard-grid']>div")
    public List<WebElement> list_dataTable;

}
