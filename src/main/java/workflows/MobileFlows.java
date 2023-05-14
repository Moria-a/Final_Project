package workflows;

import extensions.MobileActions;
import io.qameta.allure.Step;
import utilities.CommonOps;

public class MobileFlows extends CommonOps
{
    @Step("Business Flow: Login")
    public static void loginEriBank(String name, String pass)
    {
        MobileActions.updateText(eriBankLogin.txt_userName, name);
        MobileActions.updateText(eriBankLogin.txt_password, pass);
        MobileActions.tap(eriBankLogin.btn_login);
    }

    @Step("Business Flow: Make Payment and Verify the balance before and after")
    public static void makePayment(String phone, String name, String amount, String country)
    {
        MobileActions.updateText(eriBankPayment.txt_phone, phone);
        MobileActions.updateText(eriBankPayment.txt_name, name);
        MobileActions.updateText(eriBankPayment.txt_amount, amount);
        MobileActions.updateText(eriBankPayment.txt_country, country);

        MobileActions.tap(eriBankPayment.btn_sendPayment);
        MobileActions.tap(eriBankPayment.btn_yesPayment);
    }

}
