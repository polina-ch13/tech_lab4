import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class HomePage {
    private WebDriver driver;
    @FindBy(xpath = "/html/body/app-root/div/div/rz-main-page/div/aside/main-page-sidebar/div[1]/sidebar-fat-menu/div/ul/li[1]/a")
    private WebElement computerCategory;

    @FindBy(xpath = "/html/body/app-root/div/div/rz-main-page/div/aside/main-page-sidebar/div[1]/sidebar-fat-menu/div/ul/li[9]/a")
    private WebElement sportCategory;

    @FindBy(xpath = "/html/body/app-root/div/div/rz-main-page/div/aside/main-page-sidebar/a")
    private WebElement getHelpCategory;

    @FindBy(xpath = "/html/body/app-root/div/div/rz-header/rz-main-header/header/div/div/ul/li[1]/rz-lang/ul/li[2]/a")
    private WebElement ua;

    @FindBy(xpath = "/html/body/app-root/div/div/rz-header/rz-main-header/header/div/div/ul/li[1]/rz-lang/ul/li[1]/a")
    private WebElement ru;

    @FindBy(xpath = "/html/body/app-root/div/div/rz-header/rz-main-header/header/div/div/div/form/div/div[1]/input")
    private WebElement seacrh;

    @FindBy(xpath = "/html/body/app-root/div/div/rz-header/rz-main-header/header/div/div/div/form/button")
    private WebElement seacrhButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ComputerPage choiceComputerCategory() throws InterruptedException {
        computerCategory.click();
        return new ComputerPage(driver);
    }

    public SportPage choiceSportCategory() throws InterruptedException {
        sportCategory.click();
        return new SportPage(driver);
    }

    public HelpPage choiceHelpCategory() throws InterruptedException {
        getHelpCategory.click();
        return new HelpPage(driver);
    }

    public WebElement clUa () {
        ua.click();
        System.out.println(this.computerCategory.getText());
        return computerCategory;
    }

    public WebElement clRu () {
        ua.click();
        ru.click();
        System.out.println(this.computerCategory.getText());
        return computerCategory;
    }

    public SearchPage srch (String s) throws InterruptedException {
        seacrh.sendKeys(s);
        seacrhButton.click();
        return new SearchPage(driver);
    }
}
