package pageObjects.calculator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class NavigationPage
{
    @FindBy(how = How.XPATH,using = "//*[@AutomationId='Standard']")
    public WebElement btn_standard;

    @FindBy(how = How.XPATH,using = "//*[@AutomationId='Programmer']")
    public WebElement btn_programmer;

}
