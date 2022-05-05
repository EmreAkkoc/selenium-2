import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {

    protected Properties config;
    public ConfigLoader() throws IOException {

        config=new Properties();
        FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/src/test/configs/configurations.properties");
        config.load(fis);

    }
}
