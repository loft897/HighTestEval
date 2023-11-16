package toolBox;

import base.BaseTests;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.testng.annotations.Test;
import pages.TestResultsPage;
import pages.ToolBoxPage;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class ToolBoxTests extends BaseTests {

    @Test
    public void SuccessToolBox() throws Exception {
        ToolBoxPage toolBoxPage = homePage.clickToolbox();
        toolBoxPage.clickFrenchButton();
        switchToQuizTab();

        // On sélectionne les réponses et soumettons le quiz
        try (CSVReader csvReader = new CSVReaderBuilder(new FileReader("ressources/quiz_responses.csv")).withSkipLines(1).build()) {
            List<String[]> allData = csvReader.readAll();
            for (String[] row : allData) {
                int questionNumber = Integer.parseInt(row[0]) - 1;
                int response = Integer.parseInt(row[1]) - 1;
                toolBoxPage.selectAnswer(questionNumber, response);
            }
        }

        // On obtient la page de résultats du test
        TestResultsPage testResultsPage = toolBoxPage.submitQuiz();

        // On verifie qu'on est sur la bonne page
        assertTrue(testResultsPage.getAlertText().contains("Résultats du test en ligne - Hightest"), "Alert text is incorrect");
    }

    private void switchToQuizTab() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        if (tabs.size() > 1) {
            driver.switchTo().window(tabs.get(1));
        }
    }
}
