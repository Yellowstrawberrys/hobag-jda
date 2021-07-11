import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class bank_check {
    public boolean bank_check(String username){
        try (InputStream input = new FileInputStream("./stock/"+username+".properties")) {

            Properties prop = new Properties();

            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return false;
            }

            //load a properties file from class path, inside static method
            prop.load(input);
            return true;
        } catch (IOException ex) {
            System.out.println("Creating New Bank Account...");
            new save(username, "0", "0", "0", "100","0", "0", "0");
            ex.printStackTrace();
            return true;
        }
    }
}
