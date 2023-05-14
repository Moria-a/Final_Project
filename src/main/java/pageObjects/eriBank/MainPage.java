package pageObjects.eriBank;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class MainPage
{
    private AppiumDriver mobileDriver;

    public MainPage(AppiumDriver mobileDriver)
    {
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver, Duration.ofSeconds(3)),this);
    }

    @AndroidFindBy(id = "title")
    public AndroidElement txt_title;

    @AndroidFindBy(xpath = "//*[@class='android.webkit.WebView']/*[@class='android.widget.TextView']")
    public AndroidElement txt_balance;

    @AndroidFindBy(id = "makePaymentButton")
    public AndroidElement btn_makePayment;

    @AndroidFindBy(id = "mortageRequestButton")
    public AndroidElement btn_mortgageRequest;

    @AndroidFindBy(id = "expenseReportButton")
    public AndroidElement btn_expenseReport;


}
