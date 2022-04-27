import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class Test {
    static String siteHomePage = "https://rozetka.com.ua/";
    private static WebDriver driver;
    private HomePage homepage;
    private ComputerPage computerpage;
    private SportPage sportpage;
    private HelpPage helppage;
    private SearchPage searchpage;

    @Before
    public void Before() {
        System.out.println("Test Start");
    }

    @After
    public void After() {
        System.out.println("Test End");
    }

    @BeforeClass
    public static void testBeforeClass() {
        System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(siteHomePage);
    }

    // 1 переход на стр комп и ноут
    @org.junit.Test
    public void testComputerCategory() throws Exception {
        homepage = PageFactory.initElements(driver, HomePage.class);

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);

        computerpage = homepage.choiceComputerCategory();
        System.out.println(computerpage.getTextComp());
        Assert.assertEquals(computerpage.getTextComp().equals("Компьютеры и ноутбуки"), true);
        driver.quit();
    }

    // 2 переходд на стп спорт
    @org.junit.Test
    public void testSportCategory() throws Exception {
        homepage = PageFactory.initElements(driver, HomePage.class);

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);

        sportpage = homepage.choiceSportCategory();
        System.out.println(sportpage.getSportComp());
        Assert.assertEquals(sportpage.getSportComp().equals("Спорт и увлечения"), true);
        driver.quit();
    }

    // 3 переход на стр помощь
    @org.junit.Test
    public void testHelpCategory() throws Exception {
        homepage = PageFactory.initElements(driver, HomePage.class);

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);

        helppage = homepage.choiceHelpCategory();
        System.out.println(helppage.getHelpComp());
        Assert.assertEquals(helppage.getHelpComp().equals("Справочный центр"), true);
        driver.quit();
    }

    // 4 смена языка на укр
    @org.junit.Test
    public void testLangUa() throws Exception {
        homepage = PageFactory.initElements(driver, HomePage.class);
        Assert.assertEquals(homepage.clUa().getText().equals("Ноутбуки та комп’ютери"), true);
        driver.quit();
    }

    // 5 смена на ру
    @org.junit.Test
    public void testLangRu() throws Exception {
        homepage = PageFactory.initElements(driver, HomePage.class);
        Assert.assertEquals(homepage.clRu().getText().equals("Ноутбуки и компьютеры"), true);
        driver.quit();
    }

    // 6 проверка корректности поиска 1
    @org.junit.Test
    public void testSearch1() throws Exception {
        homepage = PageFactory.initElements(driver, HomePage.class);

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);

        String srch = "asus";
        searchpage = homepage.srch(srch);
        System.out.println(searchpage.notepadText());
        Assert.assertEquals(searchpage.notepadText().toLowerCase().contains(srch.toLowerCase()), true);
        driver.quit();
    }

    // 7 проверка корректности поиска 2
    @org.junit.Test
    public void testSearch2() throws Exception {
        homepage = PageFactory.initElements(driver, HomePage.class);

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);

        String srch = "XIAOMI";
        searchpage = homepage.srch(srch);
        System.out.println(searchpage.notepadText());
        Assert.assertEquals(searchpage.notepadText().toLowerCase().contains(srch.toLowerCase()), true);
        driver.quit();
    }

    // 9 проверка корректности поиска 3
    @org.junit.Test
    public void testSearch3() throws Exception {
        homepage = PageFactory.initElements(driver, HomePage.class);

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);

        String srch = "samsung";
        searchpage = homepage.srch(srch);
        System.out.println(searchpage.notepadText());
        Assert.assertEquals(searchpage.notepadText().toLowerCase().contains(srch.toLowerCase()), true);
        driver.quit();
    }

    // 10 проверка корректности поиска 4
    @org.junit.Test
    public void testSearch4() throws Exception {
        homepage = PageFactory.initElements(driver, HomePage.class);

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);

        String srch = "apple";
        searchpage = homepage.srch(srch);
        System.out.println(searchpage.notepadText());
        Assert.assertEquals(searchpage.notepadText().toLowerCase().contains(srch.toLowerCase()), true);
        driver.quit();
    }

    // 11 проверка корзины 1
    @org.junit.Test
    public void testCart1() throws Exception {
        homepage = PageFactory.initElements(driver, HomePage.class);

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);

        String srch = "XIAOMI";
        searchpage = homepage.srch(srch);
        searchpage.CartAdd1().click();
        System.out.println(searchpage.CartNum());
        Assert.assertEquals(searchpage.CartNum().equals("1"), true);
        driver.quit();
    }

    // 12 проверка корзины 2
    @org.junit.Test
    public void testCart2() throws Exception {
        homepage = PageFactory.initElements(driver, HomePage.class);

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);

        String srch = "XIAOMI";
        searchpage = homepage.srch(srch);
        searchpage.CartAdd1().click();
        searchpage.CartAdd2().click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println(searchpage.CartNum());
        Assert.assertEquals(searchpage.CartNum().equals("2"), true);
        driver.quit();
    }

    // 13 проверка корзина открыается
    @org.junit.Test
    public void testCartOpen() throws Exception {
        homepage = PageFactory.initElements(driver, HomePage.class);

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);

        String srch = "asus";
        searchpage = homepage.srch(srch);
        searchpage.CartAdd1().click();
        searchpage.CartAdd2().click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        searchpage.cart().click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        System.out.println(searchpage.cartText());
        Assert.assertEquals(searchpage.cartText().equals("Корзина"), true);
        driver.quit();
    }

    // 14 проверка корзина открыается
    @org.junit.Test
    public void testCartDel() throws Exception {
        homepage = PageFactory.initElements(driver, HomePage.class);

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);

        String srch = "asus";
        searchpage = homepage.srch(srch);
        // добавили 2 товара
        searchpage.CartAdd1().click();
        searchpage.CartAdd2().click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        searchpage.cart().click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // в корзине два товара
        System.out.println(searchpage.CartNum());
        searchpage.cartDots().click();
        // удаляем 1 товар
        searchpage.cartDel().click();
        searchpage.cartClose().click();
        // проверяем что надпись на корзине 1
        System.out.println(searchpage.CartNum());
        Assert.assertEquals(searchpage.CartNum().equals("1"), true);
        driver.quit();
    }

    // 15 сортировка от дешевого к дорогому
    @org.junit.Test
    public void testSortAZ() throws Exception {
        homepage = PageFactory.initElements(driver, HomePage.class);

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);

        String srch = "asus";
        searchpage = homepage.srch(srch);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        System.out.println(searchpage.price());
        double first = Double.parseDouble(searchpage.price().replaceAll("\\s+",""));

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        searchpage.sortSelect().selectByVisibleText("От дешевых к дорогим");

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        System.out.println(searchpage.price());
        double second = Double.parseDouble(searchpage.price().replaceAll("\\s+",""));

        if (first > second)
            Assert.assertTrue(true);
        else
            Assert.assertFalse(true);

        driver.quit();
    }

    // 13 сортировка от дорогому к дешевому
    @org.junit.Test
    public void testSortZA() throws Exception {
        homepage = PageFactory.initElements(driver, HomePage.class);

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);

        String srch = "asus";
        searchpage = homepage.srch(srch);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        System.out.println(searchpage.price());
        double first = Double.parseDouble(searchpage.price().replaceAll("\\s+",""));

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        searchpage.sortSelect().selectByVisibleText("От дорогих к дешевым");

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        System.out.println(searchpage.price());
        double second = Double.parseDouble(searchpage.price().replaceAll("\\s+",""));

        if (first < second)
            Assert.assertTrue(true);
        else
            Assert.assertFalse(true);

        driver.quit();
    }
}
