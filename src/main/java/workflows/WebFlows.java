package workflows;

import com.google.common.util.concurrent.Uninterruptibles;
import extensions.DbActions;
import extensions.UIactions;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.CommonOps;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebFlows extends CommonOps
{
    @Step("Business Flow: Login")
    public static void login()
    {
        UIactions.updateText(orangeLogin.txt_username, UIactions.split(orangeLogin.str_username," ",2));
        UIactions.updateText(orangeLogin.txt_password, UIactions.split(orangeLogin.str_password," ",2));
        UIactions.click(orangeLogin.btn_login);
    }

    @Step("Business Flow: Login with Database")
    public static void loginDB()
    {
        String query = "SELECT Name, Password FROM People WHERE ID='1'";
        List<String> cred = DbActions.getCredentials(query);
        UIactions.updateText(orangeLogin.txt_username, cred.get(0));
        UIactions.updateText(orangeLogin.txt_password, cred.get(1));
        UIactions.click(orangeLogin.btn_login);
    }

    @Step("Business Flow: Get Users List")
    public static List<WebElement> initPimUsersList()
    {
        List<WebElement> users = new ArrayList<>();
        UIactions.click(orangeLeftMenu.btn_pim);
        users.addAll(orangePim.UsersList);

        if (orangePim.btn_pages.isDisplayed())
        {
            for (int i=1; i<orangePim.list_pageNumber.size()-1; i++)
            {
                UIactions.click(orangeMain.btn_next);
                users.addAll(users.size(),orangePim.UsersList);
            }
        }
        return users;
    }

    @Step("Business Flow: Create New User and Return the id")
    public static String addUserGetID(String firstName, String midName, String lastName)
    {
        UIactions.click(orangePim.btn_addUser);
        wait.until(ExpectedConditions.elementToBeClickable(orangeAddNewUser.btn_saveEmployee));
        UIactions.updateText(orangeAddNewUser.txt_firstName,firstName);
        UIactions.updateText(orangeAddNewUser.txt_middleName,midName);
        UIactions.updateText(orangeAddNewUser.txt_lastName,lastName);

        String id = orangeAddNewUser.txt_id.getAttribute("value");
        UIactions.click(orangeAddNewUser.btn_saveEmployee);
        return id;
    }

    @Step("Business Flow: Search User")
    public static void searchUser(WebElement elem, String text)
    {
        wait.until(ExpectedConditions.visibilityOf(elem));
        UIactions.updateText(elem,text);
        UIactions.click(orangePim.btn_search);
        Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);
    }

    @Step("Business Flow: Delete User")
    public static void deleteUser(WebElement elem, String user)
    {
        searchUser(elem,user);
        UIactions.deleteUser();
    }

    @Step("Business Flow: Click Popup")
    public static void popupClick()
    {
        wait.until(ExpectedConditions.elementToBeClickable(orangeMain.popup));
        UIactions.click(orangeMain.popup);
    }



}
