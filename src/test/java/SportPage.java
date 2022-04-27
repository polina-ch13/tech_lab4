
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SportPage {
    private WebDriver driver;
    @FindBy(xpath = "/html/body/app-root/div/div/rz-super-portal/div/main/section/div[1]/h1")
    private WebElement sportText;

    public SportPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getSportComp () {
        return sportText.getText();
    }
}