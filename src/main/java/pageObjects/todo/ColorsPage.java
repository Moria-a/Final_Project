package pageObjects.todo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class ColorsPage
{
    @FindBy(how = How.CLASS_NAME, using = "topWrapper_2caNE")
    public WebElement btn_selectColor;

    @FindBy(how = How.CSS, using = ".wrapper_3Kpfj.vertical_di1oV.tagList_2NRe0>.tag_21fhY")
    public List<WebElement> list_colors;

}
