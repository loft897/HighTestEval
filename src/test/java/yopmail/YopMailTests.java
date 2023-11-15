package yopmail;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.YopMailPage;

public class YopMailTests extends BaseTests {

    @Test
    public void testYopMail() throws InterruptedException {
        // On crée une instance de la page YopMail en utilisant le driver
        YopMailPage yopMailPage = new YopMailPage(driver);

        // On ouvre YopMail dans un nouvel onglet
        yopMailPage.openInNewTab();

        // On accepte les cookies si nécessaire
        yopMailPage.acceptCookies();

        // On saisit l'adresse e-mail dans le champ
        yopMailPage.enterEmail("hightestevaluation");

        // On clique sur le bouton "Check Mail"
        yopMailPage.clickCheckMail();

        // On attend pendant 10 secondes que la liste des e-mails se charge
        Thread.sleep(10000);
    }
}
