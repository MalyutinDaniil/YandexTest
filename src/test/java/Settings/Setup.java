package Settings;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Setup {

    public String PATH_TO_PROPERTIES = "src\\resoursec\\config.properties";
    public String LOGIN;
    public String PASSWORD;
    public String TO;

    public void  getSetting()

    {


        FileInputStream fileInputStream;
        Properties prop = new Properties();
        try {
            fileInputStream = new FileInputStream(PATH_TO_PROPERTIES);
            prop.load(fileInputStream);
            LOGIN = prop.getProperty("LOGIN");
            PASSWORD = prop.getProperty("PASSWORD");
            TO = prop.getProperty("TO");

        } catch (
                IOException e) {
            e.printStackTrace();

        }
    }


}
