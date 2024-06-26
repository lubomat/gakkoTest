package pl.edu.pjwstk.gakko.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.edu.pjwstk.gakko.pages.TasksPage;
import pl.edu.pjwstk.gakko.utils.SeleniumHelper;

import java.io.IOException;

public class TasksTest extends BaseTest {

    @Test
    public void addTaskWithMultipleTasksTest() throws InterruptedException, IOException {

        ExtentTest test = extentReports.createTest("Creating Task pool With Multiple Tasks Test");
        TasksPage tasksPage = new TasksPage(driver);
        test.log(Status.PASS, "Entering to Tasks module", SeleniumHelper.getScreenshot(driver));
        tasksPage.enterTasksModule();
        test.log(Status.PASS, "Entering to Tasks module done", SeleniumHelper.getScreenshot(driver));
        test.log(Status.PASS, "Creating Task pool with multiple tasks", SeleniumHelper.getScreenshot(driver));
        tasksPage.addNewTaskPoolWithMultipleTasks(
                "Testowa nazwa puli",
                "Testowa nazwa oceny",
                "2025-05-22 00:00",
                "2025-05-23 00:00",
                "pierwsze zadanie testowe",
                "drugie zadanie testowe");
        test.log(Status.PASS, "Creating Task pool with multiple tasks done", SeleniumHelper.getScreenshot(driver));

        Assert.assertTrue(tasksPage.SuccessfullyMessage.isDisplayed());
        Assert.assertEquals(tasksPage.getSuccessfullyMessage(), "Pula zadań została zapisana pomyślnie");

    }

    @Test
    public void deleteTaskPoolFirstOnListTest() throws IOException {

        ExtentTest test = extentReports.createTest("Creating Task pool With Multiple Tasks Test");
        TasksPage tasksPage = new TasksPage(driver);
        test.log(Status.PASS, "Entering to Tasks module", SeleniumHelper.getScreenshot(driver));
        tasksPage.enterTasksModule();
        test.log(Status.PASS, "Entering to Tasks module done", SeleniumHelper.getScreenshot(driver));
        test.log(Status.PASS, "Deleting Task pool first on list", SeleniumHelper.getScreenshot(driver));
        tasksPage.deleteTaskPoolFirstOnList();
        test.log(Status.PASS, "Deleting Task pool first on list done", SeleniumHelper.getScreenshot(driver));

        Assert.assertTrue(tasksPage.SuccessfullyMessage.isDisplayed());
        Assert.assertEquals(tasksPage.getSuccessfullyMessage(),"Pula zadań została usunięta pomyślnie");



    }
}
