package pageObjects.orangeHRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class PimPage
{
    @FindBy (how = How.CSS, using = ".orangehrm-horizontal-padding.orangehrm-vertical-padding>span.oxd-text.oxd-text--span")
    public WebElement txt_numOfUsers;
    @FindBy (how = How.CSS, using = ".oxd-table-body>*")
    public List<WebElement> UsersList;
//    @FindBy (how = How.CLASS_NAME, using = "oxd-table-card")
//    public List<WebElement> table;//UsersList;

    @FindBy (how = How.CLASS_NAME, using = "orangehrm-bottom-container")
    public WebElement btn_pages;
    @FindBy (how = How.CSS, using = ".oxd-pagination__ul>li>button")
    public List<WebElement> list_pageNumber;

    @FindBy (how = How.CSS, using = ".oxd-icon.bi-plus.oxd-button-icon")//"button.oxd-button.oxd-button--medium.oxd-button--secondary")
    public WebElement btn_addUser;

    @FindBy(how = How.CSS, using = "input[placeholder='Type for hints...']")
    public WebElement txt_searchName;
    @FindBy(how = How.CSS, using = ".oxd-input-group.oxd-input-field-bottom-space>div>.oxd-input.oxd-input--active")
    public WebElement txt_searchID;
    @FindBy(how = How.CSS, using = "button[type='submit']")
    public WebElement btn_search;

    @FindBy(how = How.CSS, using = ".oxd-icon.bi-trash")
    public WebElement btn_trash;
    @FindBy(how = How.CSS, using = "[class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']") // .oxd-button.oxd-button--medium.oxd-button--label-danger.orangehrm-button-margin
    public WebElement btn_confirmDeleteUser;

    @FindBy(how = How.CSS, using = ".oxd-table-row.oxd-table-row--with-border.oxd-table-row--clickable:nth-child(2)")
    public WebElement txt_id;

}
