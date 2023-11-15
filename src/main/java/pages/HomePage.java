package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // On crée une méthode pour cliquer sur le lien "Toolbox"
    public ToolBoxPage clickToolbox() {
        // On recherche le lien "Toolbox" par son xpath
        driver.findElement(By.xpath("//a[@class='nav-link' and text()='Toolbox']")).click();
        // On retourne une nouvelle instance de la page ToolBoxPage
        return new ToolBoxPage(driver);
    }
}
