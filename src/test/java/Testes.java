import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Testes {
    WebDriver webDriver;

    @BeforeAll
    public void setupAll(){
        System.setProperty("webdriver.chrome.driver",
                "src/test/resources/chromedriver_windows32/chromedriver.exe");
    }

    @BeforeEach
    public void setup(){
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }

    @AfterEach
    public void close(){
        webDriver.close();
    }

    @Test
    public void openBlizzardPage(){
        webDriver.get("https://www.blizzard.com/pt-br/");
        Assertions.assertEquals("https://www.blizzard.com/pt-br/",
                webDriver.getCurrentUrl());
    }

    @Test
    public void findBotaoPreVendaTest(){
        webDriver.get("https://www.blizzard.com/pt-br/");
        WebElement botaoPV = webDriver.findElement(
                By.xpath("//*[@id=\"masthead_button_0_0\"]"));
        botaoPV.click();
        Assertions.assertEquals("https://us.shop.battle.net/pt-br/product/hearthstone-march-of-the-lich-king-bundle",
                webDriver.getCurrentUrl());
    }

    @Test
    public void suporteTest(){
        webDriver.get("https://us.battle.net/support/pt/");
        webDriver.findElement(By.xpath("//*[@id=\"search-bar-container\"]/span/input[2]")).sendKeys("meu jogo não abre", Keys.ENTER);
    }


}
