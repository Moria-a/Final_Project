package pageObjects.orangeHRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LeftMenuPage
{
    @FindBy(how = How.CSS,using = ".oxd-icon-button.oxd-main-menu-button")
    public WebElement btn_arrow;
    // Test Xpath List
    @FindBy(how = How.XPATH, using = "//li[@class='oxd-main-menu-item-wrapper'][1]")
    public WebElement btn_admin;
//    @FindBy(how = How.CSS, using = "li.oxd-main-menu-item-wrapper") //:nth-of-type(1)")
//    public WebElement btn_admin;

    @FindBy(how = How.CSS, using = "li.oxd-main-menu-item-wrapper:nth-of-type(2)")
    public WebElement btn_pim;

    @FindBy(how = How.CSS, using = "li.oxd-main-menu-item-wrapper:nth-of-type(3)")
    public WebElement btn_leave;

    @FindBy(how = How.CSS, using = "li.oxd-main-menu-item-wrapper:nth-of-type(4)")
    public WebElement btn_time;

    @FindBy(how = How.CSS, using = "li.oxd-main-menu-item-wrapper:nth-of-type(5)")
    public WebElement btn_recruitment;

    @FindBy(how = How.CSS, using = "li.oxd-main-menu-item-wrapper:nth-of-type(6)")
    public WebElement btn_myInfo;

    @FindBy(how = How.CSS, using = "li.oxd-main-menu-item-wrapper:nth-of-type(7)")
    public WebElement btn_performance;

    @FindBy(how = How.CSS, using = "li.oxd-main-menu-item-wrapper:nth-of-type(8)")
    public WebElement btn_dashboard;

    @FindBy(how = How.CSS, using = "li.oxd-main-menu-item-wrapper:nth-of-type(9)")
    public WebElement btn_directory;

    @FindBy(how = How.CSS, using = "li.oxd-main-menu-item-wrapper:nth-of-type(10)")
    public WebElement btn_maintenance;

    @FindBy(how = How.CSS, using = "li.oxd-main-menu-item-wrapper:last-child") // 11
    public WebElement btn_buzz;

}
