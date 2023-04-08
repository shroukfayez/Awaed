package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ProperityFileSetup
{


    public static String propInitiate(String Key) throws IOException {
        Properties prop = new Properties();

        FileInputStream File = new FileInputStream("D:/Task/Question4_WebAutomation/src/main/java/Resources/TestData.Properity");
        prop.load(File);

        return prop.getProperty(Key);
    }
}
