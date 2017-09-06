import ExtentReports.ExtentReportManager;
import ExtentReports.ReportDetails;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import shoppingPages.index;

/**
 * Created by Administrator on 06/09/2017.
 */
public class advanced {
    private WebDriver webDriver;
    private static ExtentReportManager reportManager;


    @BeforeClass
    public static void init(){
        String property = System.getProperty("user.dir");
        ReportDetails reportDetails = new ReportDetails(property + "\\advancedReport",
                "Basic Extent Report","ShoppingReport");
        reportManager = new ExtentReportManager(ExtentReportManager.ReportType.HTML,reportDetails);
    }

    @Before
    public void setUp(){
        webDriver = new ChromeDriver();
    }

    @After
    public void tearDown(){
        webDriver.quit();
    }

    @AfterClass
    public static void cleanUp(){
        reportManager.clearTests();

    }

    @Test
    public void emptyBasket(){
        ExtentTest extentTest = reportManager.setUpTest();
        extentTest.log(Status.INFO,"Navigating to basket");

        PageFactory.initElements(webDriver, index.class);
        webDriver.navigate().to("http://automationpractice.com/index.php?controller=order");

        try{
            Assert.assertEquals(index.emptyWarning.getText(),"Your shopping cart is empty.");
            extentTest.pass("basket is empty");
        } catch (AssertionError e) {
            String details = "basket is not empty " + e.getMessage();
            extentTest.fail(details);

        }



    }
    @Test
    public void addToBasket(){
        PageFactory.initElements(webDriver,index.class);
        ExtentTest extentTest = reportManager.setUpTest();
        webDriver.navigate().to("http://automationpractice.com/index.php");
        extentTest.log(Status.INFO,"Navigating to automationpractice.com ");
        index.addToCart.click();
        index.basketLink.click();
        extentTest.log(Status.INFO,"Adding item to basket");
        try {
            Assert.assertNotEquals(index.emptyWarning.getText(), "Your shopping cart is empty.");
            extentTest.pass("Item added to basket");

        }catch(AssertionError e){
            String details = "basket is empty" + e.getMessage();
            extentTest.fail(details);
        }
    }
    public void signUp(){


    }


    @Test
    public void purchaseItem(){
        PageFactory.initElements(webDriver,index.class);
        PageFactory.initElements(webDriver,index.class);
        ExtentTest extentTest = reportManager.setUpTest();
        webDriver.navigate().to("http://automationpractice.com/index.php");
        extentTest.log(Status.INFO,"Navigating to automationpractice.com ");
        index.addToCart.click();
        index.basketLink.click();


    }





}

