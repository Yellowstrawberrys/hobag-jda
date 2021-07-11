import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class load {
    public String zeone(String username){
        String s = null;
        try (InputStream input = new FileInputStream("./stock/"+username+".properties")) {

            Properties prop = new Properties();

            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return "ERROR";
            }

            //load a properties file from class path, inside static method
            prop.load(input);
            s= prop.getProperty("zeone");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return s;
    }
    public String zeonh(String username){
        String s = null;
        try (InputStream input = new FileInputStream("./stock/"+username+".properties")) {

            Properties prop = new Properties();

            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return "ERROR";
            }

            //load a properties file from class path, inside static method
            prop.load(input);
            s= prop.getProperty("zeonh");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return s;
    }
    public String jk(String username){
        String s = null;
        try (InputStream input = new FileInputStream("./stock/"+username+".properties")) {

            Properties prop = new Properties();

            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return "ERROR";
            }

            //load a properties file from class path, inside static method
            prop.load(input);
            s= prop.getProperty("jk");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return s;
    }
    public String jk_cm(String username){
        String s = null;
        try (InputStream input = new FileInputStream("./stock/"+username+".properties")) {

            Properties prop = new Properties();

            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return "ERROR";
            }

            //load a properties file from class path, inside static method
            prop.load(input);
            s= prop.getProperty("jk_cm");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return s;
    }
    public String da(String username){
        String s = null;
        try (InputStream input = new FileInputStream("./stock/"+username+".properties")) {

            Properties prop = new Properties();

            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return "ERROR";
            }

            //load a properties file from class path, inside static method
            prop.load(input);
            s= prop.getProperty("da");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return s;
    }
    public String iep(String username){
        String s = null;
        try (InputStream input = new FileInputStream("./stock/"+username+".properties")) {

            Properties prop = new Properties();

            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return "ERROR";
            }

            //load a properties file from class path, inside static method
            prop.load(input);
            s= prop.getProperty("iep");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return s;
    }
    public String money(String username){
        String s = null;
        try (InputStream input = new FileInputStream("./stock/"+username+".properties")) {

            Properties prop = new Properties();

            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return "ERROR";
            }

            //load a properties file from class path, inside static method
            prop.load(input);
            s= prop.getProperty("money");
        } catch (IOException ex) {
            s ="ERROR";
            ex.printStackTrace();
        }
        return s;
    }
}
