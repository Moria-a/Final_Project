package pageObjects.todo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class MainPage
{
    @FindBy(how = How.CSS, using = "input[placeholder='Create a task']")
    public WebElement txt_create;

    @FindBy(how = How.CLASS_NAME, using = "taskWrapper_2u8dN")
    public List<WebElement> txt_taskList;

    @FindBy(how = How.CLASS_NAME, using = "destroy_19w1q")
    public List<WebElement> btn_deleteTask;

    @FindBy(how = How.CSS,using = ".handle.dragIcon_1L0_R")
    public List<WebElement> btn_dragIcon;

    @FindBy(how = How.CSS,using = ".draggableList_DX-a1>.taskWrapper_2u8dN")
    public List<WebElement> btn_dropPoint;


}


