package net.box256.tetris.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("TetrisService")
public interface TetrisService extends RemoteService {

    // Sample interface method of remote interface
    String getMessage(String msg);

    /**
     * Utility/Convenience class.
     * Use TetrisService.App.getInstance() to access static instance of tetrisServiceAsync
     */
    class App {
        private static TetrisServiceAsync ourInstance = GWT.create(TetrisService.class);

        public static synchronized TetrisServiceAsync getInstance() {
            return ourInstance;
        }
    }
}
