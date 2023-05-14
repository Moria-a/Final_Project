package pageObjects.todo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class SideMenuPage
{
    @FindBy(how = How.CLASS_NAME, using = "toggleVisibilityPanel_hNPyc")
    public WebElement btn_openMenu;

    @FindBy(how = How.CSS, using = ".toggleVisibilityPanel_hNPyc.isVisible_1VByM")
    public WebElement btn_closeMenu;

    @FindBy(how = How.CLASS_NAME, using = "remainingTasks_1ijI7")
    public WebElement txt_remainTasks;

    @FindBy(how = How.CSS, using = ".wrapper_3Kpfj.tagsWrapper_jJPK->.tag_21fhY")
    public List<WebElement> list_colors;

    @FindBy(how = How.CSS, using = ".wrapper_3Kpfj.tagsWrapper_jJPK->.tag_21fhY.selected_2pgdj")
    public List<WebElement> list_selectedColors;


}
