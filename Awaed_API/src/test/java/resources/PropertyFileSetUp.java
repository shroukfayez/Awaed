package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public  class PropertyFileSetUp {


    public static String GetGlobalValue(String Key) throws IOException {
        Properties prop = new Properties();

        FileInputStream File = new FileInputStream("D:/Task/Awaed_API/src/test/java/resources/GlobalValues.Properity");
        prop.load(File);

        return prop.getProperty(Key);
    }
}
