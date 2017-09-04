import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Administrator on 04/09/2017.
 */
public class watchThis {
    WebDriver webDriver;
    @Before
    public void setUp() {
    webDriver = new ChromeDriver();


    }
    @After
    public void tearDown(){
        webDriver.quit();

    }
    @Test
    public void tryMe(){
        webDriver.navigate().to("http://www.qa.com");


    }
}