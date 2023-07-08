package sanity;

import com.google.common.util.concurrent.Uninterruptibles;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.ElectronFlows;

import java.util.concurrent.TimeUnit;

@Listeners(utilities.Listeners.class)
public class TodoListElectron extends CommonOps
{
    @Test(description = "Test 1: Create new tasks and verify the list size")
    @Description("This Test add new tasks to the list and verify list size")
    public static void t1_newTask()
    {
        ElectronFlows.newTask("To");
        ElectronFlows.newTask("Do");
        ElectronFlows.newTask("List");
        Verifications.verifyNum(ElectronFlows.numOfTasks(),3);
    }

    @Test(description = "Test 2: Delete Task and Verify")
    @Description("This Test Delete from the list and verify size of list")
    public static void t2_deleteTask()
    {
        ElectronFlows.newTask("To do");
        ElectronFlows.newTask("Something");

        ElectronFlows.deleteTask(1);
        Verifications.verifyNum(ElectronFlows.numOfTasks(),1);
    }

    @Test(description = "Test 3: New tasks with colors")
    @Description("This test create new task with color and verify number of same color tasks using the side menu")
    public static void t3_taskWithColor()
    {
        ElectronFlows.newTask("Red","red");
        ElectronFlows.newTask("Grey","grey");
        ElectronFlows.newTask("No Color");
        ElectronFlows.newTask("Yellow","yellow");
        ElectronFlows.newTask("Gray","gray");

        String colors[] = {"yellow","gray"};
        ElectronFlows.SideMenuColor(colors);

        Verifications.verifyNum(ElectronFlows.numOfTasks(),3);
    }



}
