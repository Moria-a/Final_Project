package utilities;

import extensions.UIactions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.windows.WindowsDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import org.w3c.dom.Document;
import workflows.DesktopFlows;
import workflows.ElectronFlows;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class CommonOps extends Base
{
     /******************************************************************
      getData Method Description: Get Data from xml configuration file
      Parameter: String
      Return: String
     *******************************************************************/
    public static String getData (String nodeName)
    {
        File fXmlFile;
        DocumentBuilderFactory dbFactory;
        DocumentBuilder dBuilder;
        Document doc = null;
        try
        {
            fXmlFile = new File("./Configuration/DataConfig.xml");
            dbFactory = DocumentBuilderFactory.newInstance();
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
        }
        catch(Exception e)
        {System.out.println("Exception in reading XML file: " + e);}
        finally
        {return doc.getElementsByTagName(nodeName).item(0).getTextContent();}
    }

    @BeforeClass
    @Parameters({"PlatformName"})
    public void startSession(String platformName)
    {
        platform = platformName;
        if (platform.equalsIgnoreCase("web"))
        {
            initBrowser(getData("BrowserName"));
            ManageDB.openConnection(getData("DbURL"),getData("DbUserName"),getData("DbPassword"));
        }
        else if (platform.equalsIgnoreCase("mobile"))
            initMobile();
        else if (platform.equalsIgnoreCase("api"))
            initAPI();
        else if (platform.equalsIgnoreCase("electron"))
            initElectron();
        else if (platform.equalsIgnoreCase("desktop"))
            initDesktop();

        else throw new RuntimeException("Invalid platform name");

        softAssert = new SoftAssert();
        screen = new Screen();
    }

    /*******************************************************************************************
     Before Method Description: If not API: Start Recording
                                If Desktop: Choose Standard Calculation Option and Clear field
     Parameter: Method
     *******************************************************************************************/
    @BeforeMethod
    public void beforeMethod(Method method)
    {
        if (!platform.equalsIgnoreCase("api"))
        {
            try {MonteScreenRecorder.startRecord(method.getName());}
            catch (Exception e) {throw new RuntimeException(e);}
        }
        if (platform.equalsIgnoreCase("desktop"))
        {
            DesktopFlows.calcType(calcNavigation.btn_standard);
            UIactions.click(calcMain.btn_clear);
        }
    }

    /*******************************************************************************************
     After Method Description: If Electron: Delete all the list
     *******************************************************************************************/
    @AfterMethod
    public static void afterMethod()
    {
        if (platform.equalsIgnoreCase("electron"))
                ElectronFlows.cleanList();
    }

    @AfterClass
    public void closeSession()
    {
        if (!platform.equalsIgnoreCase("api"))
        {
            if(driver == null) mobileDriver.quit();
            else
            {
                ManageDB.closeConnection();
                driver.quit();
            }
        }
    }

    public static void initBrowser(String browserType)
    {
        if (browserType.equalsIgnoreCase("chrome"))
            driver = initChromeDriver();
        else if (browserType.equalsIgnoreCase("firefox"))
            driver = initFirefoxDriver();
        else if (browserType.equalsIgnoreCase("ie"))
            driver = initIEDriver();
        else throw new RuntimeException("Invalid Browser Type");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(getData("Timeout")));
        driver.get(getData("url"));
        ManagePages.initOrange();

        action = new Actions(driver);
    }

    public static void initMobile()
    {
        dc.setCapability(MobileCapabilityType.UDID, getData("UDID"));
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, getData("AppPackage"));
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, getData("AppActivity"));

        try {mobileDriver = new AndroidDriver<>(new URL(getData("AppiumServer")), dc);}
        catch (Exception e) {System.out.println("Can not connect to Appium Server, See details: " + e);}

        ManagePages.initEriBank();
        mobileDriver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS); // Duration.ofSeconds(Long.parseLong(getData("Timeout")))
        wait = new WebDriverWait(mobileDriver, Long.parseLong(getData("Timeout")));
    }

    public static void initAPI()
    {
        RestAssured.baseURI = getData("urlAPI");
        httpRequest = RestAssured.given();
    }

    public static void initElectron()
    {
        System.setProperty("webdriver.chrome.driver",getData("ElectronDriverPath"));
        ChromeOptions opt = new ChromeOptions();
        opt.setBinary(getData("ElectronAppPath"));
        dc.setCapability("chromeOptions",opt);
        dc.setBrowserName("chrome");
        opt.merge(dc);
        driver = new ChromeDriver(opt);

        ManagePages.initTodo();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(getData("Timeout")));

        action = new Actions(driver);
    }

    public static void initDesktop()
    {
        dc.setCapability("app",getData("CalculatorApp"));

        try {driver = new WindowsDriver(new URL(getData("AppiumServerDesktop")),dc);}
        catch (Exception e) {System.out.println("No Connection to Appium Server, See Details: " +e);}

        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(getData("Timeout")));
        ManagePages.initCalculator();
    }

    public static WebDriver initChromeDriver()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return driver;
    }
    public static WebDriver initFirefoxDriver()
    {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        return driver;
    }
    public static WebDriver initIEDriver()
    {
        WebDriverManager.iedriver().setup();
        WebDriver driver = new InternetExplorerDriver();
        return driver;
    }

}
