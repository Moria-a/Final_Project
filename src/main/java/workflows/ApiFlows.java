package workflows;

import extensions.ApiActions;
import io.qameta.allure.Step;
import utilities.CommonOps;

import java.util.ArrayList;
import java.util.List;


public class ApiFlows extends CommonOps
{
    @Step("Business Flow: Get Student")
    public static String get(String jPath) {
        response = ApiActions.get("/student/");
        return ApiActions.extractFromJSON(response, jPath);
    }

    @Step("Business Flow: Get Student Data")
    public static String getStudentData(String jPath) {
        response = ApiActions.get("/student/list");
        return ApiActions.extractFromJSON(response, jPath);
    }

    @Step("Business Flow: Create New Student")
    public static void postStudent(String firstName, String lastName, String email, String programme) {
        params.put("firstName", firstName);
        params.put("lastName", lastName);
        params.put("email", email);
        params.put("programme", programme);
        ApiActions.post(params, "student");
    }
    @Step("Business Flow: Create New Student, With courses")
    public static void postStudent(String firstName, String lastName, String email, String programme, List<String> courses) {
        params.put("firstName", firstName);
        params.put("lastName", lastName);
        params.put("email", email);
        params.put("programme", programme);
        params.put("courses", courses);
        ApiActions.post(params, "student");
    }

    @Step("Business Flow: Update Existing Student Data")
    public static void putStudent(String id, String firstName, String lastName, String email, String programme) {
        params.put("firstName", firstName);
        params.put("lastName", lastName);
        params.put("email", email);
        params.put("programme", programme);
        ApiActions.put(params, "student/" + id);
    }
    @Step("Business Flow: Update Existing Student Data With courses")
    public static void putStudent(String id, String firstName, String lastName, String email, String programme, List<String> courses) {
        params.put("firstName", firstName);
        params.put("lastName", lastName);
        params.put("email", email);
        params.put("programme", programme);
        params.put("courses", courses);
        ApiActions.put(params, "student/" + id);
    }

    @Step("Delete Employee From Server")
    public static void delete(String i)
    {ApiActions.delete(getStudentData("["+i+"].id"));}


    @Step("Business Flow: Split String and return List of courses")
    public static List<String> coursesList(String[] courses) {
        List<String> coursesList = new ArrayList<>();
        for (String c : courses)
            coursesList.add(c);
        return coursesList;
    }

    @Step("Business Flow: Return Students Size List")
    public static String listSize()
    {
        int i=0;
        while (true)
        {
            try {ApiFlows.getStudentData("["+i+"].id");}
            catch (Exception e)
            {
                i--;
                break;
            }
            i++;
        }
        return Integer.toString(i);
    }

}