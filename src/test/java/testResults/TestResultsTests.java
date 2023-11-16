package testResults;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.ConfirmationPage;
import pages.TestResultsPage;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertTrue;

public class TestResultsTests extends BaseTests {

    @Test
    public void completeTestResultsProcess() {
        // on lit les données d'e-mail à partir du fichier CSV
        Map<String, String> emailData = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader("ressources/emailAdress.csv"))) {
            String line;
            br.readLine(); // Ignorer l'en-tête
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                emailData.put(values[0].trim(), values[1].trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // On récupère la valeur d'alias
        String emailAlias = emailData.get("alias");

        // On initialise la page des résultats
        TestResultsPage testResultsPage = new TestResultsPage(getDriver());

        // on s'assurer que la page courante est la page des résultats
        if (!getDriver().getCurrentUrl().contains("reponses-test-istqb")) {
            getDriver().get("https://hightest.nc/ressources/reponses-test-istqb.php");
        }

        // On définit l'adresse e-mail et soumettre le formulaire
        testResultsPage.setEmail(emailAlias);
        ConfirmationPage confirmationPage = testResultsPage.clickSendEmailButton();

        // On Vérifie que le texte de l'alerte est correct
        assertTrue(confirmationPage.getAlertText().contains("Parfait !"), "Alert text is incorrect");
    }

}
