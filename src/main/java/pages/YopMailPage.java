package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

    // On accepte les cookies si nécessaire
    public void acceptCookies() {
        WebElement acceptCookiesButton = driver.findElement(By.id("accept"));
        acceptCookiesButton.click();
    }
}
