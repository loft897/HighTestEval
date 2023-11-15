package toolBox;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.TestResultsPage;
import pages.ToolBoxPage;

import java.util.ArrayList;

import static org.testng.Assert.assertTrue;

public class ToolBoxTests extends BaseTests {

    @Test
    public void SuccessToolBox() {
        // On clique sur le lien "Toolbox" depuis la page d'accueil
        ToolBoxPage toolBoxPage = homePage.clickToolbox();
        toolBoxPage.clickFrenchButton(); // On choisit le quiz en francais
        switchToQuizTab(); // On bascule vers l'onglet du quiz

        // Tableau des réponses correctes pour chaque question
        int[] reponses = {1, 2, 1, 2, 2, 3, 2, 4, 1, 3, 4, 2, 3, 2, 4, 3, 3, 1, 2, 2};

        // On sélectionne les réponses et soumettons le quiz
        for (int i = 0; i < reponses.length; i++) {
            toolBoxPage.selectAnswer(i, reponses[i] - 1); // Les réponses sont indexées à partir de 0
        }

        // On obtient la page de résultats du test
        TestResultsPage testResultsPage = toolBoxPage.submitQuiz();

        // On verifie qu'on est sur la bonne page
        assertTrue(testResultsPage.getAlertText().contains("Résultats du test en ligne - Hightest"), "Alert text is incorrect");
    }

    private void switchToQuizTab() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        if (tabs.size() > 1) {
            driver.switchTo().window(tabs.get(1)); // On bascule sur le deuxième onglet
        }
    }
}
