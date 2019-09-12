package net.box256.tetris.client;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
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
        final HTML footerLabel = new HTML("<span style='color:gray; font-style: italic'> Use \"arrows\" and \"space\" keys to control the game </span>");
        footerLabel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        RootPanel.get().add(footerLabel);
        gameCanvas = new GameCanvas(canvas);

        Event.addNativePreviewHandler(event -> {

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
