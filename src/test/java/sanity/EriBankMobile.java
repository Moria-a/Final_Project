package sanity;

import extensions.MobileActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.MobileFlows;

@Listeners(utilities.Listeners.class)
public class EriBankMobile extends CommonOps
{
    @Test(description = "Test 1: Login And Verify Title")
    @Description("This Test Login And Verify Title Name: EriBank")
    public static void t1_login()
    {
        MobileFlows.loginEriBank("company", "company");
        Verifications.verifyString(eriBankMain.txt_title.getText(),"EriBank");
    }

    @Test(description = "Test 2: Make Payment and Verify it")
    @Description("This Test Make Payment and Verify tha balance before and after")
    public static void t2_MakePayment()
    {
        double before = MobileActions.splitBalance(eriBankMain.txt_balance);
        MobileActions.tap(eriBankMain.btn_makePayment);
        double amount = -20;

        MobileFlows.makePayment("0558976542","Dan", String.valueOf(amount),"Italy");
        Verifications.verifyNum(before-amount,MobileActions.splitBalance(eriBankMain.txt_balance));
    }

    @Test(description = "Test 2: Add and Remove from Expense Report")
    @Description("This Test Add 2 expenses and Remove 1 from Expense List and Verify number of expenses")
    public static void t3_expenseReport()
    {
        MobileActions.tap(eriBankMain.btn_expenseReport);
        int sizeStart = eriBankexpense.list_expenses.size();

        MobileActions.tap(eriBankexpense.btn_add);
        MobileActions.tap(eriBankexpense.btn_add);

        MobileActions.tap(eriBankexpense.list_expenses.get(2));
        int sizeEnd = eriBankexpense.list_expenses.size();

        MobileActions.tap(eriBankexpense.btn_back);
        Verifications.verifyNum(sizeStart+1,sizeEnd);
    }
}
