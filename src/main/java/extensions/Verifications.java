package extensions;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.sikuli.script.FindFailed;
import utilities.CommonOps;
import workflows.WebFlows;

import java.util.List;

import static org.testng.Assert.*;

public class Verifications extends CommonOps
{
    // General
    @Step("Verify Strings")
    public static void verifyString(String str, String expected)
    {
        assertEquals(str,expected);
    }

    @Step("Verify Int Numbers")
    public static void verifyNum(int num, int expected)
    {
        assertEquals(num, expected);
    }
    @Step("Verify Double Numbers")
    public static void verifyNum(double num, double expected)
    {
        assertEquals(num, expected);
    }

    // Sikuli
    @Step("Verify Visual Element")
    public static void visualElement(String imageName)
    {
        try
        {screen.find(getData("ImageRepo")+ imageName +".png");}
        catch (FindFailed e)
        {
            System.out.println("Error Compering Image File: "+e);
            fail("Error Compering Image File: "+e);
        }
    }

    // Web
    @Step("Verify if user exist")
    public static void existElement(List<WebElement> users)
    {
        wait.until(ExpectedConditions.visibilityOf(users.get(users.size()-1)));
        assertTrue(users.size() > 0);
    }
    @Step("Verify if user NOT exist")
    public static void notExistElement(List<WebElement> users)
    {
        assertFalse(users.size() > 0);
    }

    @Step("Verify current number of users is 1")
    public static void verifyAddUser(WebElement elem)
    {
        wait.until(ExpectedConditions.visibilityOf(elem));
        int num = UIactions.splitNum(elem);

        UIactions.deleteUser();
        WebFlows.popupClick();
        assertEquals(num,1);
    }

    @Step("Delete User and Verify current number of users is 0")
    public static void verifyDeleteUser(WebElement search, String id)
    {
        UIactions.click(orangeLeftMenu.btn_pim);
        WebFlows.searchUser(search,id);

        UIactions.deleteUser();
        WebFlows.popupClick();
        assertEquals(UIactions.splitNum(orangePim.txt_numOfUsers),0);
    }

    @Step("Business Flow: Search User and Verify if user exist")
    public static void searchAndVerify(WebElement elem, String text,boolean exists)
    {
        wait.until(ExpectedConditions.visibilityOf(elem));
        UIactions.updateTextSlow(elem,text);
        UIactions.click(orangePim.btn_search);

        if (exists) Verifications.existElement(orangePim.UsersList);
        else Verifications.notExistElement(orangePim.UsersList);
    }

    @Step("Verify Visibility of Elements (Soft Assertion)")
    public static void visibilityOfElements(List<WebElement> elems)
    {
        for (WebElement elem : elems)
        {softAssert.assertTrue(elem.isDisplayed(), elem.getText()+" NOT Displayed");}

        softAssert.assertAll("Some Elements were not displayed");
    }

    @Step("Verify Is Enabled Element")
    public static void verifyIsEnabled(WebElement elem)
    {
        wait.until(ExpectedConditions.visibilityOf(elem));
        assertTrue(elem.isEnabled());
    }


}
