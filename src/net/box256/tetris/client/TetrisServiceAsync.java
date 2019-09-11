package net.box256.tetris.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface TetrisServiceAsync {
    void getMessage(String msg, AsyncCallback<String> async);
}
