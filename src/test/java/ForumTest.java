import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ForumTest extends BaseTest{
    @Test
    public void listElements(){
        String[] compare = {"Orosz óra gyűjtők, ","Jófogás - Vélemények, tapasztalatok, ","Milyen zenét hallgatunk most?, "
                ,"Zavaró szomszédok!!!, ","FUTÓ bolondok, ","Írj, amiről csak akarsz, ","KENÓ - KENÓ - KENÓ - KENÓ, "
        ,"(Nagyon) Elvont viccek, ","Gyere, Nagyi! Mesélj!, ","Bor - az istenek ajándéka, "};
        homePage.acceptPrivacyStatement();
        ForumPage forumPage = homePage.clickFirstForumPageButton();
        String[] data = forumPage.listData();
        Assertions.assertTrue(forumPage.findElement(compare,data));
    }
    @Test
    public void scrollThreeTimesTest(){
        homePage.acceptPrivacyStatement();
        ForumPage forumPage = homePage.clickFirstForumPageButton();
        forumPage.scrollThroughTopics(3);
        Assertions.assertEquals(4,forumPage.getNumberOfActualPage());
    }
    @Test
    public void scrollBiggerThanActual(){
        homePage.acceptPrivacyStatement();
        ForumPage forumPage = homePage.clickFirstForumPageButton();
        forumPage.scrollThroughTopics(15555);
        Assertions.assertEquals(1498,forumPage.getNumberOfLastPage());
    }
}
