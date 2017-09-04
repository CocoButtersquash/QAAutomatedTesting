import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



/**
 * Created by Administrator on 04/09/2017.
 */
public class ex1 {
    WebDriver webDriver;
    @Test
    public void myTestMethod(){
        System.out.println("Hello World");
    }
    @BeforeClass
    public static void beforeClassM(){
        System.out.println("Before Class");
    }
    @Before
    public  void beforeM(){
        System.out.println("Before");

    }
    @Test
    public void mainTest(){
        System.out.println("Test");

    }
    @After
    public  void afterM(){
        System.out.println("After");
        webDriver.quit();


    }
    @AfterClass
    public static void afterClassM(){
        System.out.println("After Class");

    }
    @Test
    public void testQA(){
        webDriver = new ChromeDriver();
        webDriver.navigate().to("https:www.qa.com/");
        Assert.assertEquals("https://www.qa.com/",webDriver.getCurrentUrl());

    }


}
