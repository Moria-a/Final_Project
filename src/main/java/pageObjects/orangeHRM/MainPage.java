package pageObjects.orangeHRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage
{
    @FindBy(how = How.CSS, using = ".oxd-text.oxd-text--h6.oxd-topbar-header-breadcrumb-module")
    public WebElement headText;

    @FindBy(how = How.CSS, using = ".oxd-icon.bi-chevron-right")//.oxd-pagination-page-item.oxd-pagination-page-item--previous-next")
    public WebElement btn_next;

    @FindBy(how = How.CSS, using = ".oxd-toast-close.oxd-toast-close--info")
    public WebElement popup;

}
