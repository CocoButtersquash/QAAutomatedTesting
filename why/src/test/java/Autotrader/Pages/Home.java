package Autotrader.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Administrator on 08/09/2017.
 */
public class Home {
    //car
    @FindBy(css ="#postcode")
   public static WebElement postcode ;
    @FindBy(css ="#radius")
     public static  WebElement distance ;
    @FindBy(css ="")
    public static WebElement show ;
    @FindBy(css ="#searchVehiclesMake")
    public static WebElement make ;
    @FindBy(css ="#searchVehiclesModel")
    public static WebElement model ;
    @FindBy(css ="#searchVehiclesPriceFrom")
    public static WebElement maxPrice ;
    @FindBy(css ="#searchVehiclesPriceFrom")
    public static WebElement minPrice ;
    @FindBy(css = "#search")
    public static WebElement search ;
    //motorhome
    @FindBy(css ="#searchVehicleBerth")
    public static WebElement berth;
    //noplate
    @FindBy(css = "input.input-large:nth-child(1)")
    public static WebElement bCRInput;
    @FindBy(css=".tracking-britishCarRegistrationsSearch")
    public static WebElement bCRSearch;
    //dealer
    @FindBy(css =".dealerList__title")
    public static WebElement dealerSearchH1;
    @FindBy(css="div.dealerForm__field:nth-child(6) > div:nth-child(2) > select:nth-child(1)")
    public static WebElement dealerModel ;
    @FindBy(css="div.dealerForm__field:nth-child(5) > div:nth-child(2) > select:nth-child(1)")
    public static WebElement dealerMake ;


    //proc
    public static void selectChange(WebElement webElement, String changeTo){
         Select select = new Select(webElement);
         select.selectByValue(changeTo);
     }


}
