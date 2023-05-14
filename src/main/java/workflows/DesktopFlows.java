package workflows;

import extensions.UIactions;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import utilities.CommonOps;

public class DesktopFlows extends CommonOps
{
    @Step("Multiply X Y")
    public static void multiply(int x, int y)
    {
        clickNum(x);
        UIactions.click(calcMain.btn_multiply);
        clickNum(y);
        UIactions.click(calcMain.btn_equals);
    }

    @Step("Read the Result and return String")
    public static String getResult(WebElement elem, int i)
    {
        String num = "";
        int lng = elem.getText().split(" ").length;
        while (i< lng)
            num = num+ UIactions.split(elem.getText()," ",i++);
        return num;
    }

    @Step("Open Navigation and Choose Type of Calculator")
    public static void calcType(WebElement type)
    {
        UIactions.click(calcMain.btn_openNavigation);
        UIactions.click(type);
    }

    @Step("Click on number by int")
    public static void clickNum(int x)
    {
        for (char i : Integer.toString(x).toCharArray())
        {
            switch (i)
            {
                case '0':
                    UIactions.click(calcMain.btn_zero);
                    break;
                case '1':
                    UIactions.click(calcMain.btn_one);
                    break;
                case '2':
                    UIactions.click(calcMain.btn_two);
                    break;
                case '3':
                    UIactions.click(calcMain.btn_three);
                    break;
                case '4':
                    UIactions.click(calcMain.btn_four);
                    break;
                case '5':
                    UIactions.click(calcMain.btn_five);
                    break;
                case '6':
                    UIactions.click(calcMain.btn_six);
                    break;
                case '7':
                    UIactions.click(calcMain.btn_seven);
                    break;
                case '8':
                    UIactions.click(calcMain.btn_eight);
                    break;
                case '9':
                    UIactions.click(calcMain.btn_nine);
                    break;
                default:
                    throw new RuntimeException("Invalid Number");
            }
        }
    }

}
