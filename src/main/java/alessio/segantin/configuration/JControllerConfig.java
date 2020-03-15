package alessio.segantin.configuration;

import alessio.segantin.JController;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
public class JControllerConfig {
    private Properties prop = new Properties();
    private static JControllerConfig config = null;
    private static Logger log = Logger.getLogger(JController.class);
    private JControllerConfig() throws IOException {prop.load(JControllerConfig.class.getClassLoader().getResourceAsStream(IProperties.CONFIG_FILE));}

    public static JControllerConfig getInstance() throws IOException {
        if(config == null){
            config = new JControllerConfig();
        }
        return config;
    }

    public String getProp(String arg){
        return prop.getProperty(arg);
    }

    public void printProperties(){
        Iterator<Object> iter = prop.keySet().iterator();
        while(iter != null && iter.hasNext()){
            String key = (String) iter.next();
            log.info("key => " + getProp(key));
        }

    }

}
