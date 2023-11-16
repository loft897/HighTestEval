package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestResultsPage {
    private final By emailField = By.id("email");
    private final By sendEmailButton = By.id("submitMail");
    private final By statusAlert = By.tagName("h1");
    private final WebDriver driver;
    private final WebDriverWait wait;

    // Constructeur : initialise le driver et le wait
    public TestResultsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // on saisit l'email dans le champ prévu
    public void setEmail(String email) {
        WebElement emailFieldElement = wait.until(ExpectedConditions.elementToBeClickable(emailField));
        emailFieldElement.sendKeys(email);
    }

    // on recupère et retourne le texte de l'alerte de statut
    public String getAlertText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(statusAlert)).getText();
    }

    // on cliquer sur le bouton d'envoi et passe à la page de confirmation
    public ConfirmationPage clickSendEmailButton() {
        wait.until(ExpectedConditions.elementToBeClickable(sendEmailButton)).click();
        return new ConfirmationPage(driver);
    }
}
