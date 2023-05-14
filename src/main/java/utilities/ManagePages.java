package utilities;

import org.openqa.selenium.support.PageFactory;
import pageObjects.calculator.NavigationPage;
import pageObjects.calculator.ProgrammerPage;
import pageObjects.orangeHRM.AddNewUserPage;
import pageObjects.orangeHRM.DashboardPage;
import pageObjects.orangeHRM.PimPage;

public class ManagePages extends Base
{
    public static void initOrange()
    {
        orangeLogin = PageFactory.initElements(driver, pageObjects.orangeHRM.LoginPage.class);
        orangeMain = PageFactory.initElements(driver,pageObjects.orangeHRM.MainPage.class);
        orangeLeftMenu = PageFactory.initElements(driver,pageObjects.orangeHRM.LeftMenuPage.class);
        orangePim = PageFactory.initElements(driver, PimPage.class);
        orangeAddNewUser = PageFactory.initElements(driver, AddNewUserPage.class);
        orangeDashboard = PageFactory.initElements(driver, DashboardPage.class);
    }

    public static void initEriBank()
    {
        eriBankLogin = new pageObjects.eriBank.LoginPage(mobileDriver);
        eriBankMain = new pageObjects.eriBank.MainPage(mobileDriver);
        eriBankPayment = new pageObjects.eriBank.MakePaymentPage(mobileDriver);
        eriBankexpense = new pageObjects.eriBank.ExpenseReportPage(mobileDriver);
    }

    public static void initTodo()
    {
        todoMain = PageFactory.initElements(driver,pageObjects.todo.MainPage.class);
        todoColor = PageFactory.initElements(driver,pageObjects.todo.ColorsPage.class);
        todoSideMenu = PageFactory.initElements(driver,pageObjects.todo.SideMenuPage.class);
    }

    public static void initCalculator()
    {
        calcMain = PageFactory.initElements(driver,pageObjects.calculator.MainPage.class);
        calcNavigation = PageFactory.initElements(driver, NavigationPage.class);
        calcProgram = PageFactory.initElements(driver, ProgrammerPage.class);
    }

}
