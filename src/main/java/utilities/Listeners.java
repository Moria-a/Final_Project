package utilities;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

public class Listeners extends CommonOps implements ITestListener
{
    public void onStart(ITestContext execution)
    {        System.out.println("---------- Starting Execution ----------");}

    public void onFinish(ITestContext execution)
    {        System.out.println("---------- Finished Execution ----------");}

    public void onTestStart(ITestResult test)
    {        System.out.println("---------- Starting Test: " + test.getName() + " ----------");}

    public void onTestSuccess(ITestResult test)
    {
        if (!platform.equalsIgnoreCase("api"))
        {
            System.out.println("---------- " + test.getName() + " Test Success ----------");

            // Stop Recording:
            try {MonteScreenRecorder.stopRecord();}
            catch (Exception e) {throw new RuntimeException(e);}

            // Delete Recorded File:
            File file = new File("./test-recordings/" + test.getName() + ".avi");
            if (file.delete())
                System.out.println("File Deleted Successfully");
            else System.out.println("Failed To Deleted File");
        }
    }

    public void onTestFailure(ITestResult test)
    {
        if (!platform.equalsIgnoreCase("api"))
        {
            System.out.println("---------- " + test.getName() + " Test Failed ----------");

            // Stop Recording:
            try {MonteScreenRecorder.stopRecord();}
            catch (Exception e) {throw new RuntimeException(e);}

            saveScreenshot();
        }
    }

    public void onTestSkipped(ITestResult test)
    {        System.out.println("---------- Skipping Test: " + test.getName() + " ----------");}

    public void onTestFailedButWithinSuccessPercentage(ITestResult test) {}

    @Attachment(value = "Page Screenshot", type = "image/png")
    public byte[] saveScreenshot()
    {
        if (driver == null)
            return (byte[])((TakesScreenshot)mobileDriver).getScreenshotAs(OutputType.BYTES);
        else
            return (byte[])((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }


}
