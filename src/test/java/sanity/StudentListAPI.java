package sanity;

import extensions.ApiActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.ApiFlows;

import java.util.List;

public class StudentListAPI extends CommonOps
{
    @Test(description = "Test 1: Get and Verify First Name of Student 1")
    @Description("This Test Verify Student 1 First Name")
    public static void t1_VerifyStudent()
    {
//        ApiActions.get("student/list").prettyPrint();
        Verifications.verifyString(ApiFlows.getStudentData("[0].firstName"),"Vernon");
    }

    @Test(description = "Test 2: Add Student and Verify")
    @Description("This Test Add Student and Verify First Name")
    public static void t2_addStudent()
    {
        ApiFlows.postStudent("John","Smith","johnS@gmail.com","Lawyer");
        Verifications.verifyNum(response.getStatusCode(),201);
    }

    @Test(description = "Test 3: Update Student and Verify")
    @Description("This Test Update Student and Verify it")
    public static void t3_updateStudentCourses()
    {
        String id = ApiFlows.getStudentData("[0].id");

        String[] courses = {"Java","Selenium"};
        List<String> coursesList = ApiFlows.coursesList(courses);

        ApiFlows.putStudent(id,"Vernon","Harper","vh1@gmail.com","Automation",coursesList);
        Verifications.verifyNum(response.getStatusCode(),200);
    }

    @Test(description = "Test 4: Add Courses to student 1")
    @Description("This test add courses to student 1 and verify if added")
    public static void t4_deleteStudent()
    {
        int listSize = Integer.parseInt(ApiFlows.getStudentData("list.size"));
        ApiFlows.delete(Integer.toString(listSize-1));

        Verifications.verifyNum(response.getStatusCode(),204);
    }

}