package sanity;

import extensions.UIactions;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlows;

@Listeners(utilities.Listeners.class)
public class OrangeWeb extends CommonOps {
    @Test(description = "Test 1: Login and Verify number of users")
    @Description("This Test Login and Get list of all users (from PIM) and verifies the number of users")
    public static void t1_verifyPimUsersList() {
        WebFlows.login();
        Verifications.verifyNum(WebFlows.initPimUsersList().size(), UIactions.splitNum(orangePim.txt_numOfUsers));
    }

    @Test(description = "Test 2: Add new user and get his ID")
    @Description("This Test add new user, get his ID and verifies by Search ID (and delete the user)")
    public static void t2_addPimUser()
    {
        UIactions.click(orangeLeftMenu.btn_pim);
        String name = "Mine", midName = "A", lastName = "Abc";
        String id = WebFlows.addUserGetID(name,midName,lastName);

        UIactions.click(orangeLeftMenu.btn_pim);
        WebFlows.searchUser(orangePim.txt_searchID,id);
        Verifications.verifyAddUser(orangePim.txt_numOfUsers);
    }


    @Test(description = "Test 3: Deleted the new user")
    @Description("This Test search and deleted the new user by his ID and verifies if records of this ID  is 0")
    public static void t3_deleteUser()
    {
        UIactions.click(orangeLeftMenu.btn_pim);
        String name = "Mine", midName = "B", lastName = "Abc";
        String id = WebFlows.addUserGetID(name,midName,lastName);

        Verifications.verifyDeleteUser(orangePim.txt_searchID,id);
    }

    @Test(description = "Test 4: Dashboard table")
    @Description("This Test verifies number of windows displayed in the table (using soft assertion)")
    public static void t4_Dashboard()
    {
        UIactions.click(orangeLeftMenu.btn_dashboard);
        Verifications.visibilityOfElements(orangeDashboard.list_dataTable);
    }

    @Test(description = "Test 5: Verifies Logo")
    @Description("This Test verifies Logo Image (using Sikuli tool)")
    public static void t5_verifyLogo()
    {
        Verifications.visualElement("OrangeHRMLogo");
    }

    @Test(description = "Test 6: Search users", dataProvider = "data-provider-users", dataProviderClass = utilities.ManageDDT.class)
    @Description("This Test Search users table (using Data Driven Test)")
    public static void t6_searchUser(String user, String exist)
    {
        UIactions.click(orangeLeftMenu.btn_pim);
        Verifications.searchAndVerify(orangePim.txt_searchName,user,UIactions.stringToBoolean(exist));
    }

}
