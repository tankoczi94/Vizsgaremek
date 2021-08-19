import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RepeatedInputTest extends BaseTest{
    @Test
    public void insertCommentTest(){
        String text1 = "Hello";
        TopicPage topicPage = homePage.logIn();


        ForumPage forumPage = topicPage.clickFirstForumPageButton();

        ArticlePage articlePage = forumPage.clickOnFirstArticle();

        EditArticlePage editArticlePage = articlePage.clickCommentButton();
        editArticlePage.clearTextArea();
        editArticlePage.enterComment(text1+serial);
        ArticlePage articlePage1 = editArticlePage.sendInComment();
        if(!editArticlePage.getErrorText().isEmpty()){
            serial++;
            editArticlePage.clearTextArea();
            editArticlePage.enterComment(text1+serial);
            ArticlePage articlePage2 = editArticlePage.sendInComment();
        }
        Assertions.assertEquals(text1+serial,articlePage1.getCommentText());
    }
    @Test
    public void repeatedCommentTest(){
        String text1 = "";
        String toValidate = "";
        TopicPage topicPage = homePage.logIn();
        try {
            File myObj = new File("privacystatement.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                text1+=data;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("There is no such file.");
            e.printStackTrace();
        }

        ForumPage forumPage = topicPage.clickFirstForumPageButton();

        ArticlePage articlePage = forumPage.clickOnFirstArticle();
        for (int i = 0; i < 2; i++) {
            EditArticlePage editArticlePage = articlePage.clickCommentButton();
            editArticlePage.clearTextArea();
            editArticlePage.enterComment(text1);
            ArticlePage articlePage1 = editArticlePage.sendInComment();
            if(!editArticlePage.getErrorText().isEmpty()){
                toValidate += editArticlePage.getErrorText();
                break;
            }
        }
        Assertions.assertTrue(toValidate
                .contains("Hozzászólását ugyanezzel a szöveggel már elküldte fórumunkba, azonban teljesen azonos hozzászólásokat technikai okokból csak egyszer fogadunk el. Kérjük, módosítsa hozzászólását."));
    }
}
