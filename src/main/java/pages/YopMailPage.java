package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class YopMailPage {
    private WebDriver driver;
    private JavascriptExecutor jsExecutor;

    public YopMailPage(WebDriver driver) {
        this.driver = driver;
        this.jsExecutor = (JavascriptExecutor) this.driver;
    }

    // On ouvre la page YopMail dans un nouvel onglet
    public void openInNewTab() {
        jsExecutor.executeScript("window.open('https://yopmail.com/fr/')");
        switchToLastTab();
    }

    // On bascule vers le dernier onglet
    private void switchToLastTab() {
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
    }

    // On saisit l'adresse e-mail dans le champ
    public void enterEmail(String email) {
        WebElement emailInput = driver.findElement(By.id("login"));
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    // On clique sur le bouton "Check Mail"
    public void clickCheckMail() {
        driver.findElement(By.cssSelector("button.md")).click();
    }

    // On vérifie si l'adresse email du compte Yopmail est visible
    public boolean isEmailVisible(String email) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement emailDiv = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.bname")));
            return emailDiv.getText().contains(email);
        } catch (TimeoutException e) {
            return false;
        }
    }

    // On accepte les cookies si nécessaire
    public void acceptCookies() {
        WebElement acceptCookiesButton = driver.findElement(By.id("accept"));
        acceptCookiesButton.click();
    }
}
