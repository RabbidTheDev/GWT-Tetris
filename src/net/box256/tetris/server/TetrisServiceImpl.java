package net.box256.tetris.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import net.box256.tetris.client.TetrisService;

public class TetrisServiceImpl extends RemoteServiceServlet implements TetrisService {
    // Implementation of sample interface method
    public String getMessage(String msg) {
        return "Client said: \"" + msg + "\"<br>Server answered: \"Hi!\"";
    }
}