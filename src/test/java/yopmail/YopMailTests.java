package yopmail;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.YopMailPage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertTrue;

public class YopMailTests extends BaseTests {

    @Test
    public void testCompleteYopMailWorkflow() throws InterruptedException {
        YopMailPage yopMailPage = new YopMailPage(driver);

        // on lit les données d'e-mail à partir du fichier CSV
        Map<String, String> emailData = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader("ressources/emailAdress.csv"))) {
            String line;
            br.readLine(); // on ignore l'en-tête
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                emailData.put(values[0].trim(), values[1].trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // On récupère la valeur de l'email
        String email = emailData.get("email");

        // on ouvre YopMail dans un nouvel onglet et accepte les cookies
        yopMailPage.openInNewTab();
        yopMailPage.acceptCookies();

        // on saisit l'email, vérifie les mails, ouvre le premier mail
        yopMailPage.enterEmail(email);
        yopMailPage.clickCheckMail();

        // on verifie si l'adresse e-mail est visible
        assertTrue(yopMailPage.isEmailVisible(email), "Email address not visible");

        // Attendre que la liste des e-mails se charge
        Thread.sleep(10000);


    }
}
