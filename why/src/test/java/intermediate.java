import ExtentReports.ExtentReportManager;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

/**
 * Created by Administrator on 04/09/2017.
 */
public class intermediate {
    WebDriver webDriver;
    private static ExtentReportManager reportManager;
    @BeforeClass
    public static void init(){
        String property = System.getProperty("user.dir");
        ExtentReports.ReportDetails reportDetails = new ExtentReports.ReportDetails(property + "\\TestReport",
                "Basic Extent Report","Basic Report");
//        reportDetails.setTheme(Theme.DARK);
        reportManager = new ExtentReportManager(ExtentReportManager.ReportType.HTML,reportDetails);
    }

    @Before
    public void before(){
        webDriver = new ChromeDriver();
    }
    @Test
    public void loginTest() throws IOException{
        ExtentTest extentTest = reportManager.setUpTest();
        extentTest.log(Status.INFO,"Go to test website");
        webDriver.navigate().to("http://thedemosite.co.uk");
        extentTest.log(Status.INFO, "go to add user");
        webDriver.findElement(By.linkText("3. Add a User")).click();
        webDriver.findElement(By.name("username")).sendKeys("testPost");
        webDriver.findElement(By.name("password")).sendKeys("testPass");
        webDriver.findElement(By.name("FormsButton2")).click();
        extentTest.log(Status.INFO,"creating user ");
        webDriver.findElement(By.linkText("4. Login")).click();

        webDriver.findElement(By.name("username")).sendKeys("testPost");
        webDriver.findElement(By.name("password")).sendKeys("testPass");
        webDriver.findElement(By.name("FormsButton2")).click();
        extentTest.log(Status.INFO,"Logging in");


        try {
            Assert.assertEquals(webDriver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b")).getCssValue("color"), "rgba(0, 128, 0, 1)");
            extentTest.pass("Passed");
        }
        catch(AssertionError e){
            String details = "Error logging in" + e.getMessage();
            extentTest.fail(details);
            Assert.fail(details);

        }


    }
    @After
    public  void after(){
        webDriver.quit();

    }
    @AfterClass
    public static void cleanUp(){
        reportManager.clearTests();
    }
}
