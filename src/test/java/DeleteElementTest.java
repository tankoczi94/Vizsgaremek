import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DeleteElementTest extends BaseTest{

    @Test
    public void deleteElementTest(){
        int sizeOfList = 0;
        TopicPage topicPage = homePage.logIn();
        EditedArticlePage editedArticlePage = topicPage.clickOnEditedArticles();
        sizeOfList = editedArticlePage.getSizeOfElementsList();
        if(editedArticlePage.getSizeOfElementsList()>0){
            editedArticlePage.deleteComment();
            Assertions.assertEquals(sizeOfList-1,editedArticlePage.getSizeOfElementsList());
        }else{
            System.err.println("There is no Editable Comment");
        }
    }
}
