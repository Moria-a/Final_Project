package pageObjects.eriBank;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class LoginPage
{
    private AppiumDriver mobileDriver;

    public LoginPage(AppiumDriver mobileDriver)
    {
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver, Duration.ofSeconds(3)),this);
    }

    @AndroidFindBy(id = "usernameTextField")
    public AndroidElement txt_userName;

    @AndroidFindBy(id = "passwordTextField")
    public AndroidElement txt_password;

    @AndroidFindBy(id = "loginButton")
    public AndroidElement btn_login;
}
