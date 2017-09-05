package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Administrator on 05/09/2017.
 */
public class Home {
    @FindBy(linkText = "3. Add a User")
    public static WebElement addLink;
    @FindBy(linkText = "4. Login")
    public static WebElement loginLink;
    @FindBy(name = "username")
    public static WebElement username;
    @FindBy(name = ("password"))
    public static WebElement password;

}
