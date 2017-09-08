package Autotrader;

import Autotrader.Pages.Home;
import ExtentReports.ExtentReportManager;
import Spreadsheets.SpreadSheetReader;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.junit.*;
import org.junit.rules.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.os.WindowsUtils;
import org.openqa.selenium.support.PageFactory;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 08/09/2017.
 */
public class tests {
    WebDriver webDriver;
    private static ExtentReportManager reportManager;
    @BeforeClass
    public static void init(){
        String property = System.getProperty("user.dir");
        ExtentReports.ReportDetails reportDetails = new ExtentReports.ReportDetails(property + "\\AutoTrader",
                "AutoTrader Report","AutoTrader");
//        reportDetails.setTheme(Theme.DARK);
        reportManager = new ExtentReportManager(ExtentReportManager.ReportType.HTML,reportDetails);
    }
    @Before
    public void before(){
        SpreadSheetReader sheetReader = new SpreadSheetReader(System.getProperty("user.dir") + "/src/main/resources/browser.xlsx");
        List<String> xcells =sheetReader.readRow(0,"Input Data");
        switch (xcells.get(0)) {
            case "chrome":
                webDriver = new ChromeDriver();
            break;
            case "firefox":
                webDriver = new FirefoxDriver();


        }
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


        @Test
    public  void searchCarFromSheet(){
            SpreadSheetReader sheetReader = new SpreadSheetReader(System.getProperty("user.dir") + "/src/main/resources/Autotrader.xlsx");
            List<String> row = sheetReader.readRow(1, "Car");
            PageFactory.initElements(webDriver,Home.class);
            ExtentTest extentTest = reportManager.setUpTest();
            webDriver.navigate().to("http://www.autotrader.co.uk/");
            extentTest.log(Status.INFO,"Navigating to http://www.autotrader.co.uk/");
            Home.postcode.sendKeys(row.get(0));
            Home.selectChange(Home.distance,row.get(1));
            Home.selectChange(Home.make,row.get(2).toUpperCase());
            Home.selectChange(Home.model,row.get(3).toUpperCase());
            Home.selectChange(Home.minPrice,row.get(4));
            Home.selectChange(Home.maxPrice,row.get(5));
            extentTest.log(Status.INFO,"Attempting to add details");
            extentTest.log(Status.INFO,"Attempting to search");
            try{
                Home.search.click();
                Assert.assertNotEquals(webDriver.getCurrentUrl(),"https://www.autotrader.co.uk");
                extentTest.pass("Search successful");
            }catch(AssertionError e){
             extentTest.fail("search was invalid" + e);

            }
        }
        @Test
        public void searchMotorhomeFromSheet(){
        SpreadSheetReader sheetReader = new SpreadSheetReader(System.getProperty("user.dir") + "/src/main/resources/Autotrader.xlsx");
        List<String> row = sheetReader.readRow(1, "Motorhome");
        PageFactory.initElements(webDriver,Home.class);
        ExtentTest extentTest = reportManager.setUpTest();
        webDriver.navigate().to("http://www.autotrader.co.uk/motorhomes");
        extentTest.log(Status.INFO,"Navigating to http://www.autotrader.co.uk/");
        Home.postcode.sendKeys(row.get(0));
        Home.selectChange(Home.distance,row.get(1));
        Home.selectChange(Home.make,row.get(2).toUpperCase());
        Home.selectChange(Home.berth,row.get(3).toUpperCase());
        Home.selectChange(Home.minPrice,row.get(4));
        Home.selectChange(Home.maxPrice,row.get(5));
        extentTest.log(Status.INFO,"Attempting to add details");
        extentTest.log(Status.INFO,"Attempting to search");
        try{
            Home.search.click();
            Assert.assertNotEquals(webDriver.getCurrentUrl(),"https://www.autotrader.co.uk/motorhomes");
            extentTest.pass("Search for Motorhome successful");
        }catch(AssertionError e){
            extentTest.fail("search was invalid" + e);

        }
    }
    @Test
    public void privateNumberSearch(){
        SpreadSheetReader sheetReader = new SpreadSheetReader(System.getProperty("user.dir") + "/src/main/resources/Autotrader.xlsx");
        List<String> row = sheetReader.readRow(1, "Motorhome");
        PageFactory.initElements(webDriver,Home.class);
        ExtentTest extentTest = reportManager.setUpTest();
        webDriver.navigate().to("http://www.autotrader.co.uk/private-number-plates");
        extentTest.log(Status.INFO,"Navigating to http://www.autotrader.co.uk/private-number-plates");
        Home.bCRInput.sendKeys("TEST");
        Home.bCRSearch.click();
        extentTest.log(Status.INFO,"searching for no plate");

        ArrayList<String> tabs = new ArrayList<String>(webDriver.getWindowHandles());

        try {
            Assert.assertEquals(tabs.size(), 2);
            extentTest.pass("search complete");
        }
        catch(AssertionError e){
            extentTest.fail("search fail" + e);

        }
    }
    @Test
    public void button(){
        webDriver.findElement(By.cssSelector(".footer__nav-social > li:nth-child(2) > a:nth-child(1)")).click();
        Assert.assertEquals(webDriver.getCurrentUrl(),"https://twitter.com/AutoTrader_UK");
    }
    @Test
    public void otherButton(){
        webDriver.findElement(By.cssSelector(".footer__nav-social > li:nth-child(4) > a:nth-child(1)")).click();
        Assert.assertEquals(webDriver.getCurrentUrl(),"https://www.instagram.com/autotraderuk/?hl=en");
    }
    @Test
    public void findClosestDealer(){
        PageFactory.initElements(webDriver,Home.class);
        webDriver.navigate().to("http://www.autotrader.co.uk/car-dealers");
        Timeout.seconds(1);
        Home.postcode.sendKeys("CH14BJ");
        Home.selectChange(Home.dealerMake,"FORD");
        Home.selectChange(Home.dealerModel,"");
        webDriver.findElement(By.cssSelector("#submit")).click();
        Timeout.seconds(2);

        Assert.assertTrue(Home.dealerSearchH1.getText().contains("CH1"));

    }
    @Test
    public void fin







    }



