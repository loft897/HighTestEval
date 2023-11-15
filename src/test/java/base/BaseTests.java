package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pages.HomePage;

public class BaseTests {
    protected static WebDriver driver;

    // On crée une méthode pour obtenir le driver
    public static WebDriver getDriver() {
        return driver;
    }

    protected HomePage homePage;

    @BeforeSuite
    public void setUp() {
        // On configure le chemin du chromedriver et les autres config pour le navigateur
        System.setProperty("webdriver.chrome.driver", "ressources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://hightest.nc/");
        driver.manage().window().maximize();
        WebElement acceptCookiesButton = driver.findElement(By.id("cookie_action_close_header"));
        acceptCookiesButton.click();
        try {
            // On attend 2 secondes (2000 millisecondes)
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // On initialise la page d'accueil (HomePage)
        homePage = new HomePage(driver);
    }

    @AfterSuite
    public void tearDown() {
        // On quitte le navigateur et ferme toutes les fenêtres apres l'execution de la suite des tests bien sur
        driver.quit();
    }
}
