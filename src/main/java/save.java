import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class save {
    public save(String username, String zeonele, String jk,String zeonh,String money, String jk_cm,String da,String iep){
        String path = null;
        try {
            path = new File("./stock/"+username+".properties").getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (OutputStream output = new FileOutputStream(path)) {

            Properties prop = new Properties();

            // set the properties value
            prop.setProperty("zeone", zeonele);
            prop.setProperty("jk", jk);
            prop.setProperty("zeonh", zeonh);
            prop.setProperty("money", money);
            prop.setProperty("jk_cm", jk_cm);
            prop.setProperty("da", da);
            prop.setProperty("iep", iep);


            // save properties to project root folder
            prop.store(output, null);

        } catch (IOException io) {
            io.printStackTrace();
        }

    }
}
