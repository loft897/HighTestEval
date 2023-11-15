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

    private final WebDriver driver;
    private final By statusAlert = By.tagName("h1");

    public TestResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    // On définit la méthode pour saisir une adresse e-mail
    public void setEmail(String email) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement emailFieldElement = wait.until(ExpectedConditions.elementToBeClickable(emailField));
        emailFieldElement.sendKeys(email);
    }

    // On obtient le texte de l'alerte de statut
    public String getAlertText() {
        return driver.findElement(statusAlert).getText();
    }

    // On clique sur le bouton d'envoi de l'e-mail et passe à la page de confirmation
    public ConfirmationPage clickSendEmailButton() {
        driver.findElement(sendEmailButton).click();
        return new ConfirmationPage(driver);
    }
}
