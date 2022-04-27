import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        String siteHomePage = "https://rozetka.com.ua/";
        WebDriver driver = new ChromeDriver();
        driver.get(siteHomePage);
        HomePage homepage;
        ComputerPage computerpage;
        SportPage sportpage;
        HelpPage helppage;
        homepage = PageFactory.initElements(driver, HomePage.class);
        computerpage = homepage.choiceComputerCategory();
        sportpage = homepage.choiceSportCategory();
        helppage = homepage.choiceHelpCategory();
    }
}
