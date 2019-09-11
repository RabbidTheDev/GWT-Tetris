package net.box256.tetris.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("TetrisService")
public interface TetrisService extends RemoteService {

    String getMessage(String msg);

    class App {
        private static TetrisServiceAsync ourInstance = GWT.create(TetrisService.class);

        public static synchronized TetrisServiceAsync getInstance() {
            return ourInstance;
        }
    }
}
