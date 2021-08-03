import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Scanner;

public class PrivacyStatementTest extends BaseTest{
    @Test
    public void testPrivacyStatementContent(){
        try{
            File file = new File("privacystatement.txt");
            if(file.createNewFile()) {
                System.out.println("File has been created");
            }
        } catch (IOException e) {
            System.err.println("This should never run");
            e.printStackTrace();
        }
        try{
            FileWriter writer = new FileWriter("privacystatement.txt");
            writer.write(homePage.getContentOfPrivacyStatement());
            writer.close();
        } catch (IOException e) {
            System.err.println("There is no such file");
            e.printStackTrace();
        }
        try{
            FileReader reader = new FileReader("privacystatement.txt");
            Scanner scanner = new Scanner(reader);
            Assertions.assertTrue(scanner.hasNextLine());
            Assertions.assertTrue(scanner.nextLine().contains("Az Ön adatainak védelme fontos a számunkra"));
            Assertions.assertTrue(scanner.nextLine().contains("Mi és a partnereink információkat"));
            reader.close();
        } catch (FileNotFoundException e) {
            System.err.println("There is no such file");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
