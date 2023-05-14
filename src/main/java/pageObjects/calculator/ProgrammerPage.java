package pageObjects.calculator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProgrammerPage
{
    @FindBy(how = How.XPATH,using = "//*[@AutomationId='hexButton']")
    public WebElement result_hex;

    @FindBy(how = How.XPATH,using = "//*[@AutomationId='decimalButton']")
    public WebElement result_dec;

    @FindBy(how = How.XPATH,using = "//*[@AutomationId='binaryButton']")
    public WebElement result_binary;


}
