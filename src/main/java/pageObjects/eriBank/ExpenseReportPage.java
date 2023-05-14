package pageObjects.eriBank;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

public class ExpenseReportPage
{
    private AppiumDriver mobileDriver;

    public ExpenseReportPage(AppiumDriver mobileDriver)
    {
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver, Duration.ofSeconds(3)),this);
    }

    @AndroidFindBy(id = "addButton")
    public AndroidElement btn_add;

    @AndroidFindBy(id = "backButton")
    public AndroidElement btn_back;

    @AndroidFindBy(id = "titleTextView")
    public List<AndroidElement> list_expenses;
}
