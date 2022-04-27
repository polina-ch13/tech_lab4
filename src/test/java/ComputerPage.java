
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class ComputerPage {
    private WebDriver driver;
    @FindBy(xpath = "/html/body/app-root/div/div/rz-super-portal/div/main/section/div[1]/h1")
    private WebElement compText;

    @FindBy(xpath = "/html/body/app-root/div/div/rz-super-portal/div/main/section/div[2]/rz-dynamic-widgets/rz-widget-list[1]/section/ul/li[1]/rz-list-tile/div/a[1]")
    private WebElement notepads;

    public ComputerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getTextComp () {
        return compText.getText();
    }
}