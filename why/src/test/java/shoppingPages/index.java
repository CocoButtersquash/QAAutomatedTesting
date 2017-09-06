package shoppingPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Administrator on 06/09/2017.
 */
public class index {
    @FindBy(css = "#header > div:nth-child(3) > div > div > div:nth-child(3) > div > a")
    public static WebElement basketLink;
    @FindBy(css = "#center_column > p")
    public static WebElement emptyWarning;
    @FindBy(css = "#homefeatured > li.ajax_block_product.col-xs-12.col-sm-4.col-md-3.first-in-line.first-item-of-tablet-line.first-item-of-mobile-line > div > div.right-block > div.button-container > a.button.ajax_add_to_cart_button.btn.btn-default")
    public static WebElement addToCart;
    @FindBy(css = "#header > div.nav > div > div > nav > div.header_user_info > a")
    public static WebElement signUpLink;

}
