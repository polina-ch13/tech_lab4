import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HelpPage {
    private WebDriver driver;
    @FindBy(xpath = "/html/body/header/div/div/div[1]/div[2]/a/p")
    private WebElement helpText;

    public HelpPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getHelpComp() {
        return helpText.getText();
    }
}