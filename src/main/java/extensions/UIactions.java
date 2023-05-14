package extensions;

import com.google.common.util.concurrent.Uninterruptibles;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utilities.CommonOps;
import workflows.WebFlows;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class UIactions extends CommonOps
{
    @Step("Click on Element")
    public static void click(WebElement elem)
    {
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.click();
    }

    @Step("Update Text Element")
    public static void updateText(WebElement elem, String text)
    {
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.sendKeys(text);
    }
    @Step("Update Text Element slow")
    public static void updateTextSlow(WebElement elem, String text)
    {
        wait.until(ExpectedConditions.visibilityOf(elem));
        for (char c : text.toCharArray())
        {
            Uninterruptibles.sleepUninterruptibly(100,TimeUnit.MILLISECONDS);
            elem.sendKeys((c+""));
        }
    }

    @Step("Send Key")
    public static void insertKey(WebElement elem, Keys k)
    {elem.sendKeys(k);}

    @Step("Delete User")
    public static void deleteUser()
    {
        wait.until(ExpectedConditions.visibilityOf(orangePim.btn_trash));
        UIactions.click(orangePim.btn_trash);
        UIactions.click(orangePim.btn_confirmDeleteUser);
    }

    @Step("Update DropDown Element")
    public static void updateDropDown(WebElement elem, String text)
    {
        wait.until(ExpectedConditions.visibilityOf(elem));
        Select dropDown = new Select(elem);
        dropDown.selectByVisibleText(text);
    }

    @Step("Update DropDown Element")
    public static void updateDropDown(List<WebElement> listElem, int i)
    {click(listElem.get(i));}

    @Step("Mouse Hover Element")
    public static void mouseHover(WebElement elem)
    {action.moveToElement(elem).click().build().perform();}

    @Step("Drag and Drop")
    public static void dragDrop(WebElement drag, WebElement drop)
    {action.dragAndDrop(drag,drop).build().perform();}

    @Step("Split Element and return string of [i] cell (By WebElement)")
    public static String split(WebElement elem, String splitStr, int i)
    {
        wait.until(ExpectedConditions.visibilityOf(elem));
        return elem.getText().split(splitStr)[i];
    }
    @Step("Split String and return string of [i] cell (By String)")
    public static String split(String str, String splitStr, int i)
    {return str.split(splitStr)[i];}

    @Step("Split Record line and return number of users")
    public static int splitNum(WebElement elem)
    {
        wait.until(ExpectedConditions.visibilityOf(elem));
        int num;
        String str = UIactions.split(elem," ",0);

        if (str.equals("No")) num = 0;
        else num = Integer.parseInt(str.replaceAll("[^0-9]", ""));//str.substring(1,str.length()-1));

        return num;
    }
    @Step("Get String and Return if True or False")
    public static boolean stringToBoolean(String str)
    {
        if (Boolean.parseBoolean(str))
            return true;
        else if (str.equalsIgnoreCase("false"))
            return false;
        else throw new RuntimeException("Invalid expected output in Data Driven Testing, Should be TRUE or FALSE");
    }




}
