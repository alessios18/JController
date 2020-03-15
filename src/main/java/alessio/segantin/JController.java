package alessio.segantin;


import alessio.segantin.configuration.IProperties;
import alessio.segantin.configuration.JControllerConfig;
import alessio.segantin.core.CoreThread;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class JController {
    static boolean running = true;
    static Logger log = Logger.getLogger(JController.class);
    static Scanner sc = new Scanner(System.in);
    public static void main( String[] args ){
        try {
            log.info("JController is Starting...");
            log.info("loading configurations...");
            JControllerConfig.getInstance().printProperties();
            log.info("configurations loaded [OK]");
            CoreThread core = new CoreThread();
            while (running) {
                System.out.print("JController:> ");
                String command = sc.nextLine();
                if (command.equals("exit")) {
                    running = false;
                    core.stopCore();
                    core.join();
                }
                System.out.println("");
            }
        }catch(IOException | InterruptedException e){
            log.error( e.getMessage(), e );
        }
    }
}
