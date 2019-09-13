package net.box256.tetris.client;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

public class Tetris implements EntryPoint {

    private static GameUI gameUI;

    public void onModuleLoad() {

        GWT.setUncaughtExceptionHandler(e -> {
            //does not work in production mode
            GWT.log("Error: ", e);
        });


        final Canvas canvas = Canvas.createIfSupported();
        canvas.addStyleName("GameCanvas");

        RootPanel.get().add(canvas);
        gameUI = new GameUI(canvas);

        Event.addNativePreviewHandler(event -> {

            final int keyCode = event.getNativeEvent().getKeyCode();
            if (keyCode >= 32 && keyCode <= 40 && event.getTypeInt() == 128) {
                if (keyCode == 37) {
                    gameUI.keyPress(GameUI.KEY.LEFT);
                } else if (keyCode == 38) {
                    gameUI.keyPress(GameUI.KEY.UP);
                } else if (keyCode == 39) {
                    gameUI.keyPress(GameUI.KEY.RIGHT);
                } else if (keyCode == 40) {
                    gameUI.keyPress(GameUI.KEY.DOWN);
                } else if (keyCode == 32) {
                    gameUI.keyPress(GameUI.KEY.SPACE);
                }
            }
        });
        final FlowPanel buttonsPanel1 = new FlowPanel();
        buttonsPanel1.addStyleName("ButtonsPanel");
        RootPanel.get().add(buttonsPanel1);

        final FlowPanel buttonsPanel2 = new FlowPanel();
        buttonsPanel2.addStyleName("ButtonsPanel");
        RootPanel.get().add(buttonsPanel2);

        final Button buttonRotateLeft = new Button("RL");
        buttonRotateLeft.addStyleName("ActionButton");
        buttonsPanel1.add(buttonRotateLeft);

        final Button buttonStart = new Button(">|");
        buttonStart.addStyleName("ActionButton");
        buttonsPanel1.add(buttonStart);

        final Button buttonRotateRight = new Button("RR");
        buttonRotateRight.addStyleName("ActionButton");
        buttonsPanel1.add(buttonRotateRight);

        final Button buttonMoveLeft = new Button("<<");
        buttonMoveLeft.addStyleName("ActionButton");
        buttonsPanel2.add(buttonMoveLeft);

        final Button buttonDrop = new Button("DROP");
        buttonDrop.addStyleName("ActionButton");
        buttonsPanel2.add(buttonDrop);

        final Button buttonMoveRight = new Button(">>");
        buttonMoveRight.addStyleName("ActionButton");
        buttonsPanel2.add(buttonMoveRight);

        buttonStart.setEnabled(false);

        buttonStart.addClickHandler(event -> {
            //not implemented yet
        });
        buttonRotateLeft.addClickHandler(event -> gameUI.rotateDown());
        buttonRotateRight.addClickHandler(event -> gameUI.rotateUp());
        buttonMoveLeft.addClickHandler(event -> gameUI.moveLeft());
        buttonMoveRight.addClickHandler(event -> gameUI.moveRight());
        buttonDrop.addClickHandler(event -> gameUI.drop());

        final Label keysInfoLabel = new Label("Use \"arrows\" and \"space\" keys to control the game from the keyboard");
        keysInfoLabel.addStyleName("InfoLabel");
        RootPanel.get().add(keysInfoLabel);

    }
}
