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

    @Test(description = "Test 3: Drag and Drop task")
    @Description("This test drag one task up in the list")
    public static void t3_dragAndDrop()
    {
        ElectronFlows.newTask("one");
        ElectronFlows.newTask("two");
        ElectronFlows.newTask("Three");
        ElectronFlows.newTask("four");
        ElectronFlows.newTask("five");

//        action.clickAndHold(todoMain.btn_dragIcon.get(1)).moveToElement(todoMain.btn_dropPoint.get(3)).release().build().perform();
//        action.clickAndHold(todoMain.btn_dragIcon.get(1)).release(todoMain.btn_dropPoint.get(3)).build().perform();
//        action.moveToElement(todoMain.btn_dropPoint.get(3)).build().perform();
//        action.release(todoMain.btn_dropPoint.get(3)).build().perform();
//        action.release().build().perform();
//        action.dragAndDrop(todoMain.btn_dragIcon.get(1), todoMain.btn_dropPoint.get(4)).perform();
//        action.dragAndDropBy(todoMain.btn_dragIcon.get(2),0,300).build().perform();

//        ElectronFlows.dragNDrop(1,3);

        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
    }

    @Test(description = "Test 4: New tasks with colors")
    @Description("This test create new task with color and verify number of same color tasks using the side menu")
    public static void t4_taskWithColor()
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
