package pageObjects.orangeHRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddNewUserPage
{
    @FindBy(how = How.NAME, using = "firstName")
    public WebElement txt_firstName;

    @FindBy(how = How.NAME,using = "middleName")
    public WebElement txt_middleName;

    @FindBy(how = How.NAME,using = "lastName")
    public WebElement txt_lastName;

    @FindBy(how = How.CSS,using = "div.oxd-grid-2.orangehrm-full-width-grid input") // div.oxd-grid-2.orangehrm-full-width-grid>div>div>div>input
    public WebElement txt_id;

    @FindBy(how = How.CSS,using = "button[type='submit']")
    public WebElement btn_saveEmployee;
}
