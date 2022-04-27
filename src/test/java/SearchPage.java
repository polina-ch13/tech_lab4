import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SearchPage {
    private WebDriver driver;
    @FindBy(xpath = "/html/body/app-root/div/div/rz-search/rz-catalog/div/div[2]/section/rz-grid/ul/li[1]/rz-catalog-tile/app-goods-tile-default/div/div[2]/a[2]/span")
    private WebElement rndN;

    @FindBy(xpath = "/html/body/app-root/div/div/rz-search/rz-catalog/div/div[2]/section/rz-grid/ul/li[1]/rz-catalog-tile/app-goods-tile-default/div/div[2]/div[4]/div[2]/app-buy-button/button")
    private WebElement cart1;

    @FindBy(xpath = "/html/body/app-root/div/div/rz-search/rz-catalog/div/div[2]/section/rz-grid/ul/li[2]/rz-catalog-tile/app-goods-tile-default/div/div[2]/div[4]/div[2]/app-buy-button/button")
    private WebElement cart2;

    @FindBy(xpath = "/html/body/app-root/div/div/rz-header/rz-main-header/header/div/div/ul/li[7]/rz-cart/button/rz-icon-counter/span")
    private WebElement cartNum;

    @FindBy(xpath = "/html/body/app-root/div/div/rz-header/rz-main-header/header/div/div/ul/li[7]/rz-cart/button/rz-icon-counter/span")
    private WebElement cartButton;

    @FindBy(xpath = "/html/body/app-root/single-modal-window/div[3]/div[1]/h3")
    private WebElement cartText;

    @FindBy(xpath = "/html/body/app-root/single-modal-window/div[3]/div[2]/rz-shopping-cart/div/ul/li/rz-cart-product/div/div[1]/rz-popup-menu/button")
    private WebElement cartDots;

    @FindBy(xpath = "/html/body/app-root/single-modal-window/div[3]/div[2]/rz-shopping-cart/div/ul/li/rz-cart-product/div/div[1]/rz-popup-menu/div/ul/li[1]/rz-trash-icon/button")
    private WebElement cartDel;

    @FindBy(xpath = "/html/body/app-root/single-modal-window/div[3]/div[1]/button")
    private WebElement cartClose;

    @FindBy(xpath = "/html/body/app-root/div/div/rz-search/rz-catalog/div/div[1]/div/rz-sort/select")
    private WebElement sortSelect;

    @FindBy(xpath = "/html/body/app-root/div/div/rz-search/rz-catalog/div/div[2]/section/rz-grid/ul/li[1]/rz-catalog-tile/app-goods-tile-default/div/div[2]/div[4]/div[2]/p/span[1]")
    private WebElement price;


    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String notepadText() {
        return rndN.getText();
    }

    public WebElement CartAdd1() {
        return cart1;
    }

    public WebElement CartAdd2() {
        return cart2;
    }

    public String CartNum() {
        return cartNum.getText();
    }

    public WebElement cart() {
        return cartButton;
    }

    public String cartText() {
        return cartText.getText();
    }

    public WebElement cartDots() {
        return cartDots;
    }

    public WebElement cartDel() {
        return cartDel;
    }

    public WebElement cartClose() {
        return cartClose;
    }

    public Select sortSelect() {
        Select selectObject = new Select(sortSelect);
        return selectObject;
    }

    public String price() {
        return price.getText();
    }
}
