package net.box256.tetris.client;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;

public class Tetris implements EntryPoint {

    public void onModuleLoad() {

        GWT.setUncaughtExceptionHandler(e -> {
            //does not work in production mode
            GWT.log("Error: ", e);
        });


        final Canvas canvas = Canvas.createIfSupported();
        canvas.addStyleName("GameCanvas");

        RootPanel.get().add(canvas);
        GameUI.createUI(canvas);
    }
}
