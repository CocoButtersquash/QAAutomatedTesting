import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Administrator on 04/09/2017.
 */
public class intermediate {
    WebDriver webDriver;

    @Before
    public void before(){
        webDriver = new ChromeDriver();
    }
    @Test
    public void loginTest(){
        webDriver.navigate().to("http://thedemosite.co.uk");
        webDriver.findElement(By.linkText("3. Add a User")).click();
        webDriver.findElement(By.name("username")).sendKeys("testPost");
        webDriver.findElement(By.name("password")).sendKeys("testPass");
        webDriver.findElement(By.name("FormsButton2")).click();
        webDriver.findElement(By.linkText("4. Login")).click();

        webDriver.findElement(By.name("username")).sendKeys("testPost");
        webDriver.findElement(By.name("password")).sendKeys("testPass");
        webDriver.findElement(By.name("FormsButton2")).click();

        Assert.assertEquals(webDriver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b")).getCssValue("color"),"rgba(0, 128, 0, 1)");


    }
    @After
    public  void after(){
        webDriver.quit();

    }
}
