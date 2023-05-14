package pageObjects.eriBank;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class MakePaymentPage
{
    private AppiumDriver mobileDriver;

    public MakePaymentPage(AppiumDriver mobileDriver)
    {
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver, Duration.ofSeconds(3)),this);
    }

    @AndroidFindBy(id = "makePaymentButton")
    public AndroidElement btn_makePayment;

    @AndroidFindBy(id = "phoneTextField")
    public AndroidElement txt_phone;

    @AndroidFindBy(id = "nameTextField")
    public AndroidElement txt_name;

    @AndroidFindBy(id = "amountTextField")
    public AndroidElement txt_amount;

    @AndroidFindBy(id = "countryTextField")
    public AndroidElement txt_country;

    @AndroidFindBy(id = "sendPaymentButton")
    public AndroidElement btn_sendPayment;

    @AndroidFindBy(id = "button1")
    public AndroidElement btn_yesPayment;

}
