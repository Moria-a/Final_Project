package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlows;

@Listeners(utilities.Listeners.class)
public class OrangeWebDB extends CommonOps
{
        @Test(description = "Test 1: Login to OrangeHRM with DB Credentials")
        @Description("This Test login and verifies if the arrow in the left menu is enable")
        public static void t1_verifyArrowEnabled()
        {
            WebFlows.loginDB();
            Verifications.verifyIsEnabled(orangeLeftMenu.btn_arrow);
        }

}
