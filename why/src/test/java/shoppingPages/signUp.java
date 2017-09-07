package shoppingPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Administrator on 06/09/2017.
 */
public class signUp {
    @FindBy(css = "#SubmitCreate")
    public static WebElement createBtn;
    @FindBy(css = "#email_create")
    public static WebElement createEmail;
    @FindBy(css = "#id_gender1")
    public static WebElement maleRad;
    @FindBy(css = "#id_gender2")
    public static WebElement fMaleRad;
    @FindBy(css = "#customer_firstname")
    public static WebElement firstnameCreate;
    @FindBy(css = "#customer_lastname")
    public static WebElement lastNameCreate;
    @FindBy(css = "#email")
    public static WebElement emailCreate;
    @FindBy(css = "#passwd")
    public static WebElement passwordCreate;
    @FindBy(css = "#days")
    public static WebElement dobDay;
    @FindBy(css = "#months")
    public static WebElement dobMonth;
    @FindBy(css = "#years")
    public static WebElement dobYear;
    @FindBy(css = "#firstname")
    public static WebElement firstNameAddress;
    @FindBy(css = "#lastname")
    public static WebElement lastNameAddress;
    @FindBy(css = "#company")
    public static WebElement companyAddress;
    @FindBy(css = "#address1")
    public static WebElement address1;
    @FindBy(css = "#address2")
    public static WebElement addressAdress;
    @FindBy(css = "#city")
    public static WebElement cityAddress;
    @FindBy(css = "#id_state")
    public static WebElement stateAddress;
    @FindBy(css = "#postcode")
    public static WebElement zipAddress;
    @FindBy(css = "#id_country")
    public static WebElement countryAddress;
    @FindBy(css = "#other")
    public static WebElement other;
    @FindBy(css = "#phone")
    public static WebElement homePhone;
    @FindBy(css = "#phone_mobile")
    public static WebElement mobilePhone;
    @FindBy(css = "#alias")
    public static WebElement alias;
    @FindBy(css = "#submitAccount")
    public static WebElement registerButton;

    public static void selecter(WebElement webElement, String toTurn ){
        Select select = new Select(webElement);
        select.selectByValue(toTurn);
    }


}
