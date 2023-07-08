package workflows;

import com.google.common.util.concurrent.Uninterruptibles;
import extensions.UIactions;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.CommonOps;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ElectronFlows extends CommonOps
{
    @Step("Add new task")
    public static void newTask(String task)
    {
        UIactions.updateTextSlow(todoMain.txt_create,task);
        UIactions.insertKey(todoMain.txt_create, Keys.ENTER);
    }

    @Step("Add new task with color")
    public static void newTask(String task, String color)
    {
        UIactions.click(todoColor.btn_selectColor);
        selectColor(todoColor.list_colors, color);
        UIactions.click(todoColor.btn_selectColor);

        UIactions.updateText(todoMain.txt_create,task);
        UIactions.insertKey(todoMain.txt_create, Keys.ENTER);

        UIactions.click(todoColor.btn_selectColor);
        selectColor(todoColor.list_colors,"off");
        UIactions.click(todoColor.btn_selectColor);
    }

    @Step("Select Color from the list")
    public static void selectColor(List colorList, String color)
    {
        if (color.equalsIgnoreCase("off"))
            UIactions.updateDropDown(colorList, 0);
        else if (color.equalsIgnoreCase("red"))
            UIactions.updateDropDown(colorList, 1);
        else if (color.equalsIgnoreCase("orange"))
            UIactions.updateDropDown(colorList, 2);
        else if (color.equalsIgnoreCase("yellow"))
            UIactions.updateDropDown(colorList, 3);
        else if (color.equalsIgnoreCase("green"))
            UIactions.updateDropDown(colorList, 4);
        else if (color.equalsIgnoreCase("blue"))
            UIactions.updateDropDown(colorList, 5);
        else if (color.equalsIgnoreCase("purple"))
            UIactions.updateDropDown(colorList, 6);
        else if (color.equalsIgnoreCase("gray") || color.equalsIgnoreCase("grey"))
            UIactions.updateDropDown(colorList, 7);

        else throw new RuntimeException("Invalid Color");
    }

    @Step("Open and Close the Side Menu")
    public static void sideMenu()
    {
        Uninterruptibles.sleepUninterruptibly(500,TimeUnit.MILLISECONDS);
        UIactions.click(todoSideMenu.btn_openMenu);
    }

    @Step("Open Side Menu choose the colors and close")
    public static void SideMenuColor(String[] colors)
    {
        sideMenu();
        for (String color : colors)
            selectColor(todoSideMenu.list_colors, color);
        sideMenu();
    }

    @Step("Return number of tasks")
    public static int numOfTasks()
    {return todoMain.txt_taskList.size();}

    @Step("Clear all tasks from the list")
    public static void clearList()
    {
        clearSelectedColors();
        while (todoMain.btn_deleteTask.size() > 0)
            UIactions.mouseHover(todoMain.btn_deleteTask.get(0));
    }

    @Step("Clean all the selected colors")
    public static void clearSelectedColors()
    {
        sideMenu();
        for (WebElement color : todoSideMenu.list_selectedColors)
            UIactions.click(color);
        sideMenu();
    }

    @Step("Delete task from list")
    public static void deleteTask(int i)
    {UIactions.mouseHover(todoMain.btn_deleteTask.get(i));}

    @Step("Drag and Drop")
    public static void dragNDrop(int drag, int drop)
    {
        UIactions.dragDrop(todoMain.btn_dragIcon.get(drag), todoMain.btn_dropPoint.get(drop));
    }




}
