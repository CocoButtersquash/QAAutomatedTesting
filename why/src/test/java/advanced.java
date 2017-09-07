import ExtentReports.ExtentReportManager;
import ExtentReports.ReportDetails;
import Spreadsheets.SpreadSheetReader;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.sun.deploy.security.DeployURLClassPathCallback;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import shoppingPages.index;
import shoppingPages.signUp;

import java.security.cert.Extension;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;

/**
 * Created by Administrator on 06/09/2017.
 */
public class advanced {
    private WebDriver webDriver;
    private static ExtentReportManager reportManager;
    SpreadSheetReader sheetReader = new SpreadSheetReader(System.getProperty("user.dir") + "/src/main/resources/users.xlsx");



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
        //webDriver.quit();
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
    @Test
    public void signUp(){
        ExtentTest extentTest = reportManager.setUpTest();
        Actions mover = new Actions(webDriver);
        PageFactory.initElements(webDriver,index.class);
        PageFactory.initElements(webDriver, signUp.class);
        extentTest.log(Status.INFO,"Initialising Variables from pages");

        webDriver.navigate().to("http://automationpractice.com/index.php");
        extentTest.log(Status.INFO,"navigating to sign up");
        index.signUpLink.click();



        signUp.createEmail.sendKeys("Test@Notreal.MadeUp");
            signUp.createBtn.click();
            extentTest.log(Status.INFO, "Attempting new sign up ");

        try {
            waituntil();
        }
        catch (Exception t)
        {
            String details = "email already registered "+ t;
            extentTest.fail(details);
            return;

        }





        signUp.maleRad.click();
        signUp.firstnameCreate.sendKeys("MAN");
        signUp.lastNameCreate.sendKeys("MAN");
        signUp.passwordCreate.sendKeys("P@55word");
        signUp.selecter(signUp.dobDay,"12");
        signUp.selecter(signUp.dobMonth,"10");
        signUp.selecter(signUp.dobYear,"1990");
        signUp.address1.sendKeys("29 HouseOn Street");
        signUp.cityAddress.sendKeys("Manchester");
        signUp.selecter(signUp.stateAddress,"7");
        signUp.selecter(signUp.countryAddress,"21");
        signUp.zipAddress.sendKeys("20500");
        signUp.mobilePhone.sendKeys("12345678910");
        signUp.alias.sendKeys("home");
        signUp.registerButton.click();
        extentTest.log(Status.INFO,"completing fields");

        try {
            Assert.assertNotEquals(webDriver.getCurrentUrl(), "http://automationpractice.com/index.php?controller=authentication");
            extentTest.pass("account created");
        }
        catch(AssertionError e){
            String details = "failed because of " + e;
            extentTest.fail(details);



        }

    }
    @Test
    public void signIn(){

        
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


    private void waituntil(){
        Wait<WebDriver> wait = new FluentWait<WebDriver>(webDriver)
                .withTimeout(20, TimeUnit.SECONDS)
                .pollingEvery(5, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
        WebElement magic = wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                return webDriver.findElement(By.cssSelector("#id_gender2"));
            }
        });

    }




}

