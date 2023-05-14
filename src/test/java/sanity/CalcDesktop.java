package sanity;

import extensions.UIactions;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.DesktopFlows;

@Listeners(utilities.Listeners.class)
public class CalcDesktop extends CommonOps
{
    @Test(description = "Test 1: Multiply and Verify the result")
    @Description("This test Multiply and Verify the result")
    public static void t1_multiply()
    {
        DesktopFlows.multiply(7,5);
        Verifications.verifyString(DesktopFlows.getResult(calcMain.result,2),Integer.toString(7*5));
    }

    @Test(description = "Test 2: Insert number Verify it in HexDecimal")
    @Description("This test Insert number and Verify it in HexDecimal")
    public static void t2_getHexNum()
    {
        DesktopFlows.calcType(calcNavigation.btn_programmer);
        UIactions.click(calcProgram.result_dec);

        DesktopFlows.clickNum(42);
        Verifications.verifyString(DesktopFlows.getResult(calcProgram.result_hex,1),"2A");
    }

    @Test(description = "Test 3: Insert number Verify it in Binary")
    @Description("This test Insert number and Verify it in Binary")
    public static void t3_getBinNum()
    {
        DesktopFlows.calcType(calcNavigation.btn_programmer);
        UIactions.click(calcProgram.result_dec);

        DesktopFlows.clickNum(42);
        Verifications.verifyString(DesktopFlows.getResult(calcProgram.result_binary,1),"00101010");
    }



}
