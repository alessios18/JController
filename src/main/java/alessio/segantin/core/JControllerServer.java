package alessio.segantin.core;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;

public class JControllerServer extends ServerSocket {
    public JControllerServer() throws IOException {
    }

    public JControllerServer(int port) throws IOException {
        super(port);
    }

    public JControllerServer(int port, int backlog) throws IOException {
        super(port, backlog);
    }

    public JControllerServer(int port, int backlog, InetAddress bindAddr) throws IOException {
        super(port, backlog, bindAddr);
    }
}
