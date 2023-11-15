package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ToolBoxPage {

    private WebDriver driver;

    public ToolBoxPage(WebDriver driver) {
        this.driver = driver;
    }

    // On identifie le bouton en français pour le test ISTQB
    private By istqbFrenchButton = By.xpath("//h2[contains(text(), 'ISTQB niveau Foundation (version 2018)')]/following-sibling::div[contains(@class, 'absolute lang')]//a[contains(text(), 'Français')]");

    // On clique sur le bouton pour passer à la version française
    public void clickFrenchButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement frenchButton = wait.until(ExpectedConditions.presenceOfElementLocated(istqbFrenchButton));

        // Fait défiler la page jusqu'au bouton français
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", frenchButton);

        try {
            wait.until(ExpectedConditions.elementToBeClickable(frenchButton));
            frenchButton.click();
        } catch (ElementClickInterceptedException e) {
            // Si l'exception ElementClickInterceptedException se produit, on clique à l'aide de JavaScript
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", frenchButton);
        }

        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowHandles.get(1));

        try {
            Thread.sleep(10000); // Pause de 10 secondes pour permettre le chargement de la page
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Sélectionner une réponse pour une question donnée
    public void selectAnswer(int questionNumber, int answerNumber) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By answerSelector = By.xpath("//input[@name='" + questionNumber + "' and @value='" + (answerNumber + 1) + "']");
        WebElement answer = wait.until(ExpectedConditions.presenceOfElementLocated(answerSelector));

        try {
            wait.until(ExpectedConditions.elementToBeClickable(answer));
            answer.click();
        } catch (ElementClickInterceptedException e) {
            // Si l'exception ElementClickInterceptedException se produit, on clique à l'aide de JavaScript
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", answer);
        }
    }

    // Soumettre le quiz
    public TestResultsPage submitQuiz() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement submitButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("submit")));

        // Fait défiler jusqu'au bouton Terminé
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);

        // Attente que le bouton soit cliquable
        wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        submitButton.click();

        // Attente pour que la page pour obtenir des résultats soit chargée
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("submitMail")));

        return new TestResultsPage(driver);
    }
}
