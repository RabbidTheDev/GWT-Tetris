package net.box256.tetris.client;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.RootPanel;

public class Tetris implements EntryPoint {

    private static GameCanvas gameCanvas;

    public void onModuleLoad() {

        GWT.setUncaughtExceptionHandler(e -> {
            //does not work in production mode
            GWT.log("Error: ", e);
        });


        final Canvas canvas = Canvas.createIfSupported();
        canvas.addStyleName("GameCanvas");

        RootPanel.get().add(canvas);
        gameCanvas = new GameCanvas(canvas);

        Event.addNativePreviewHandler(event -> {
            //NativeEvent ne = event.getNativeEvent();
            //GWT.log(ne.getCharCode() + " (" + ((char) ne.getCharCode()) + ") " +
            //        (ne.getButton() != 1 ? " button=" + ne.getButton() : "") +
            //        (ne.getKeyCode() != ne.getCharCode() ? " keyCode=" +
            //                ne.getKeyCode() : "") +
            //        (ne.getAltKey() ? " ALT" : "") +
            //        (ne.getCtrlKey() ? " CTRL" : "") +
            //        (ne.getMetaKey() ? " META" : "") +
            //        (ne.getShiftKey() ? " SHIFT" : ""));
            final int keyCode = event.getNativeEvent().getKeyCode();
            if (keyCode >= 32 && keyCode <= 40 && event.getTypeInt() == 128) {
                if (keyCode == 37) {
                    gameCanvas.keyPress(GameCanvas.KEY.LEFT);
                } else if (keyCode == 38) {
                    gameCanvas.keyPress(GameCanvas.KEY.UP);
                } else if (keyCode == 39) {
                    gameCanvas.keyPress(GameCanvas.KEY.RIGHT);
                } else if (keyCode == 40) {
                    gameCanvas.keyPress(GameCanvas.KEY.DOWN);
                } else if (keyCode == 32) {
                    gameCanvas.keyPress(GameCanvas.KEY.SPACE);
                }
            }
        });
    }
}
