import ExtentReports.ExtentReportManager;
import Spreadsheets.SpreadSheetReader;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.io.IOException;
import java.util.List;
import java.util.function.Function;
import Pages.*;

import static java.util.concurrent.TimeUnit.SECONDS;

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
//extent example
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
    @Test
    public void spreadsheetTest(){
       //using data from spreadsheet example
        SpreadSheetReader sheetReader = new SpreadSheetReader(System.getProperty("user.dir") + "/src/main/resources/testing.xlsx");
        webDriver.navigate().to("http://thedemosite.co.uk");
        webDriver.findElement(By.linkText("3. Add a User")).click();

        int[] numberOfRows = {1,2,3,4};
        for (int rowNo : numberOfRows){
            sheetReader.readRow(rowNo, "Input Data");
        }
        for(int i = 0;i <= numberOfRows.length;i++) {

            List<String> row = sheetReader.readRow(i, "Input Data");
            String usrname = row.get(0);
            String password = row.get(1);

            try {
                webDriver.findElement(By.name("username")).sendKeys(usrname);
                webDriver.findElement(By.name("password")).sendKeys(password);
                webDriver.findElement(By.name("FormsButton2")).click();
                webDriver.findElement(By.linkText("4. Login")).click();

                webDriver.findElement(By.name("username")).sendKeys(usrname);
                webDriver.findElement(By.name("password")).sendKeys(password);
                webDriver.findElement(By.name("FormsButton2")).click();
                try {
                    Assert.assertEquals(webDriver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b")).getCssValue("color"), "rgba(0, 128, 0, 1)");

                } catch (AssertionError e) {
                    String details = "Error logging in" + e.getMessage();
                    System.out.println(details);

                }
            }
            catch(UnhandledAlertException e){
                webDriver.switchTo().alert().accept();
                System.out.println(e);

            }



            }


        }

        @Test
        public void changeBrowser() {
            //change browser based on entry into spreadsheet
            SpreadSheetReader sheetReader = new SpreadSheetReader(System.getProperty("user.dir") + "/src/main/resources/browser.xlsx");
            List<String> browser = sheetReader.readRow(0, "Input Data");
                String browserSt = browser.get(0);
                switch (browserSt) {
                    case "chrome":
                        webDriver = new ChromeDriver();
                        break;
                    case "firefox":
                        webDriver = new FirefoxDriver();


                }
            webDriver.navigate().to("http://thedemosite.co.uk");
            webDriver.findElement(By.linkText("3. Add a User")).click();
            Wait<WebDriver> wait = new FluentWait<WebDriver>(webDriver)
                    .withTimeout(10,SECONDS)
                    .pollingEvery(5,SECONDS)
                    .ignoring(NoSuchElementException.class);
            WebElement usernom = wait.until(new Function<WebDriver, WebElement>() {
                public WebElement apply(WebDriver webDriver) {
                   return  webDriver.findElement(By.name("username"));

                }
            });
            webDriver.findElement(By.name("username")).sendKeys("test");
            webDriver.findElement(By.name("password")).sendKeys("password");
            webDriver.findElement(By.name("FormsButton2")).click();
            }

            @Test
            public void shortendTest(){
               //using pagefactory
                PageFactory.initElements(webDriver, Home.class);

                webDriver.navigate().to("http://thedemosite.co.uk");
                Home.addLink.click();
                Home.username.sendKeys("test");
                Home.password.sendKeys("test");
                webDriver.findElement(By.name("FormsButton2")).click();
            }

    @After
    public  void after(){
        try {
            webDriver.quit();
        }
        catch (WebDriverException e){
            System.out.println(e);

        }

    }
    @AfterClass
    public static void cleanUp(){
        reportManager.clearTests();
    }
}
