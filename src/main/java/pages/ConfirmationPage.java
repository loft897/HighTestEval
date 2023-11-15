package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationPage {
    private final WebDriver driver;
    private final By statusAlert = By.tagName("h2");

    public ConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }

    // On obtient le texte de l'alerte de statut
    public String getAlertText() {
        return driver.findElement(statusAlert).getText();
    }
}
