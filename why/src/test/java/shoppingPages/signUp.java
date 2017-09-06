package shoppingPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Administrator on 06/09/2017.
 */
public class signUp {
    @FindBy(css = "#SubmitCreate")
    public static WebElement createBtn;
    @FindBy(css = "#email_create")
    public static WebElement createEmail;
    @FindBy(css = "##id_gender1")
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
    @FindBy(css = "#firstnaem")
    public static WebElement firstNameAddress;
    @FindBy(css = "#lastname")
    public static WebElement lastNameAddress;
    @FindBy(css = "##id_gender1")
    public static WebElement emailAddress;
    @FindBy(css = "#id_gender2")
    public static WebElement companyAddress;
    @FindBy(css = "#email_create")
    public static WebElement addressAdress;
    @FindBy(css = "#email_create")
    public static WebElement adressAdress2;
    @FindBy(css = "#email_create")
    public static WebElement cityAddress;
    @FindBy(css = "#email_create")
    public static WebElement stateAddress;
    @FindBy(css = "#email_create")
    public static WebElement zipAddress;
    @FindBy(css = "#email_create")
    public static WebElement countryAddress;
    @FindBy(css = "#email_create")
    public static WebElement homePhone;
    @FindBy(css = "#email_create")
    public static WebElement mobilePhone;
    @FindBy(css = "#email_create")
    public static WebElement alias;
    @FindBy(css = "#email_create")
    public static WebElement registerButton;

}
