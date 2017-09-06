import ExtentReports.ExtentReportManager;
import ExtentReports.ReportDetails;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by Administrator on 05/09/2017.
 */
public class mooseActions {
    WebDriver webDriver;
    Actions mover;
    public static ExtentReportManager extentReportManager;


    @BeforeClass
    public static void init(){
        String property = System.getProperty("user.dir");
        ReportDetails reportDetails = new ReportDetails(property + "\\mouseActions",
                "Basic Extent Report","MooseReport");
//        reportDetails.setTheme(Theme.DARK);
        extentReportManager = new ExtentReportManager(ExtentReportManager.ReportType.HTML,reportDetails);
    }
    @Before
    public void before(){
        webDriver = new ChromeDriver();
        mover = new Actions(webDriver);



    }
    @Test
    public void dragNDrop(){
        webDriver.navigate().to("http://demoqa.com");
        webDriver.findElement(By.cssSelector("#menu-item-140 > a:nth-child(1)")).click();

        mover.dragAndDrop(webDriver.findElement(By.id("draggable")), webDriver.findElement(By.cssSelector("#menu-item-140 > a:nth-child(1)")) ).perform();




        }
        @Test
        public void resize(){
            webDriver.navigate().to("http://demoqa.com/resizable");
            WebElement target =  webDriver.findElement(By.cssSelector("#resizable > div:nth-child(4)"));
            mover.clickAndHold(target).perform();
            mover.moveToElement(target,100,100).perform();
            mover.click().perform();

        }
        @Test
    public void reOrder(){
            webDriver.navigate().to("http://demoqa.com/sortable/");

            webDriver.findElement(By.cssSelector("#ui-id-3")).click();
            Point targetpos = webDriver.findElement(By.cssSelector("#sortable_grid > li:nth-child(5)")).getLocation();
            WebElement  target = webDriver.findElement(By.cssSelector("#sortable_grid > li:nth-child(1)"));
            //mover.dragAndDrop(target,webDriver.findElement(By.cssSelector("#sortable_grid > li:nth-child(5)"))).perform();
            mover.clickAndHold(webDriver.findElement(By.cssSelector("#sortable_grid > li:nth-child(1)"))).perform();
            mover.moveByOffset(0,100).perform();
            mover.click().perform();
            Assert.assertEquals(target.getLocation(),targetpos);

    }
    @Test
    public void datPicker(){
        WebElement dp;
        webDriver.navigate().to("http://demoqa.com/datepicker/");

        dp = webDriver.findElement(By.cssSelector("#datepicker1"));
        dp.click();
        webDriver.findElement(By.cssSelector(".ui-icon-circle-triangle-e")).click();
        webDriver.findElement(By.cssSelector(".ui-icon-circle-triangle-e")).click();

        webDriver.findElement(By.cssSelector(".ui-datepicker-calendar > tbody:nth-child(2) > tr:nth-child(4) > td:nth-child(5) > a:nth-child(1)")).click();
        Assert.assertEquals(dp.getAttribute("value"),"November 24, 2017");
    }
        @After
    public void after(){
        webDriver.quit();

        }

    }
