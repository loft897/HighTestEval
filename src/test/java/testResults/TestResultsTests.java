package testResults;

import base.BaseTests;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.ConfirmationPage;
import pages.TestResultsPage;

import static org.testng.Assert.assertTrue;

public class TestResultsTests extends BaseTests {

    @Test
    public void sendEmail() {
        WebDriver driver = BaseTests.getDriver();

        // On s'assure que le test démarre sur la page des résultats
        if (!driver.getCurrentUrl().contains("reponses-test-istqb")) {
            // On navigue vers la page des résultats si nécessaire (Remplacez par l'URL appropriée)
            driver.get("https://hightest.nc/ressources/reponses-test-istqb.php");
        }

        // On crée une instance de la page des résultats
        TestResultsPage testResultsPage = new TestResultsPage(driver);

        // On définit une adresse e-mail
        testResultsPage.setEmail("alt.b7-1om5mdrp@yopmail.com");

        // On clique sur le bouton d'envoi de l'e-mail et passe à la page de confirmation
        ConfirmationPage confirmationPage = testResultsPage.clickSendEmailButton();

        // On vérifie que le texte de l'alerte contient "Parfait !"
        assertTrue(confirmationPage.getAlertText().contains("Parfait !"), "Alert text is incorrect");
    }
}
