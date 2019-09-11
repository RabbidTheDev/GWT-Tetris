package net.box256.tetris.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import net.box256.tetris.client.TetrisService;

// Not implemented yet

public class TetrisServiceImpl extends RemoteServiceServlet implements TetrisService {

    public String getMessage(String msg) {
        return "Client said: \"" + msg + "\"<br>Server answered: \"Hi!\"";
    }
}