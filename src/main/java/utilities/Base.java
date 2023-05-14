package utilities;

import io.appium.java_client.AppiumDriver;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.asserts.SoftAssert;
import pageObjects.calculator.NavigationPage;
import pageObjects.calculator.ProgrammerPage;
import pageObjects.orangeHRM.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Base
{
    // General
    protected static WebDriverWait wait;
    protected static Actions action;
    protected static SoftAssert softAssert;
    protected static Screen screen;
    protected static String platform;

    // Web
    protected static WebDriver driver;

    // Mobile
    protected static AppiumDriver mobileDriver;
    protected static DesiredCapabilities dc = new DesiredCapabilities();

    // Rest API
    protected static RequestSpecification httpRequest;
    protected static Response response;
    protected static JSONObject params = new JSONObject();
    protected static JsonPath jp;

    // Database
    protected static Connection con;
    protected static Statement stmt;
    protected static ResultSet rs;

    // Page Objects - Web
    protected static LoginPage orangeLogin;
    protected static MainPage orangeMain;
    protected static LeftMenuPage orangeLeftMenu;
    protected static PimPage orangePim;
    protected static AddNewUserPage orangeAddNewUser;
    protected static DashboardPage orangeDashboard;

    // Page Objects - Mobile
    protected static pageObjects.eriBank.LoginPage eriBankLogin;
    protected static pageObjects.eriBank.MainPage eriBankMain;
    protected static pageObjects.eriBank.MakePaymentPage eriBankPayment;
    protected static pageObjects.eriBank.ExpenseReportPage eriBankexpense;

    // Page Objects - Electron
    protected static pageObjects.todo.MainPage todoMain;
    protected static pageObjects.todo.ColorsPage todoColor;
    protected static pageObjects.todo.SideMenuPage todoSideMenu;

    // Page Objects - Desktop
    protected static pageObjects.calculator.MainPage calcMain;
    protected static NavigationPage calcNavigation;
    protected static ProgrammerPage calcProgram;


}
