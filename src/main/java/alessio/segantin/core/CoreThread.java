package alessio.segantin.core;

import alessio.segantin.configuration.IProperties;
import alessio.segantin.configuration.JControllerConfig;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.Socket;

public class CoreThread extends Thread {
    private static Logger log = Logger.getLogger(CoreThread.class);
    private JControllerServer server = null;
    private boolean running = true;
    public CoreThread() throws IOException {
        this.setName(this.getClass().getName());
        JControllerConfig config = JControllerConfig.getInstance();
        server = new JControllerServer(Integer.parseInt(config.getProp(IProperties.SERVER_PORT)),Integer.parseInt(config.getProp(IProperties.SERVER_BACKLOG_LIMIT)));
        this.start();
    }

    public void run(){
        while(isRunning()){
            try {
                Socket s = server.accept();
                log.info("Connected master called: "+s.getRemoteSocketAddress().toString());
            } catch (IOException e) {
                log.error( e.getMessage(), e );
            }
        }
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public void stopCore(){
        setRunning(false);
        try {
            server.close();
        } catch (IOException e) {
            log.info("Server stopped");
        }
    }
}
