package net.box256.tetris.client;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.canvas.dom.client.CssColor;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import net.box256.tetris.client.game.Color;
import net.box256.tetris.client.game.GameBlock;
import net.box256.tetris.client.game.GameEngine;

import java.util.List;
import java.util.Set;

class GameUI {

    private final int GAME_PIXEL_SIZE = 6;
    private final int BLOCK_SIZE = 5;
    private final int BLOCKS_WIDTH = 12;
    private final int BLOCKS_HEIGHT = 21;

    private final Context2d context;
    private GameEngine engine;
    private int widthCanvasPixels;
    private int heightCanvasPixels;

    private Boolean pause = false;
    private final Button buttonGame;

    private GameUI(final Canvas canvas) {

        adjustBrowserCanvasSize(canvas);

        context = canvas.getContext2d();

        //todo: nice symbols for buttons
        //todo: make buttons and canvas unfocusable tabIndex="-1"

        buttonGame = new Button(">|");
        final Button buttonRotateRight = new Button("RR");
        final Button buttonMoveLeft = new Button("<<");
        final Button buttonDrop = new Button("DROP");
        final Button buttonMoveRight = new Button(">>");

        startNewGame();

        Window.addResizeHandler(event -> {
            adjustBrowserCanvasSize(canvas);
            drawAll();
        });

        Event.addNativePreviewHandler(event -> {
            final int keyCode = event.getNativeEvent().getKeyCode();
            if (keyCode >= 32 && keyCode <= 40 && event.getTypeInt() == 128) {
                if (keyCode == 37) {
                    GameUI.this.keyPress(GameUI.KEY.LEFT);
                } else if (keyCode == 38) {
                    GameUI.this.keyPress(GameUI.KEY.UP);
                } else if (keyCode == 39) {
                    GameUI.this.keyPress(GameUI.KEY.RIGHT);
                } else if (keyCode == 40) {
                    GameUI.this.keyPress(GameUI.KEY.DOWN);
                } else if (keyCode == 32) {
                    GameUI.this.keyPress(GameUI.KEY.SPACE);
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

        buttonGame.addStyleName("ActionButton");
        buttonsPanel1.add(buttonGame);

        buttonRotateRight.addStyleName("ActionButton");
        buttonsPanel1.add(buttonRotateRight);

        buttonMoveLeft.addStyleName("ActionButton");
        buttonsPanel2.add(buttonMoveLeft);

        buttonDrop.addStyleName("ActionButton");
        buttonsPanel2.add(buttonDrop);

        buttonMoveRight.addStyleName("ActionButton");
        buttonsPanel2.add(buttonMoveRight);

        buttonGame.addClickHandler(event -> {
            if (engine.isGameOver()) {
                startNewGame();
            } else {
                pause = !pause;
                drawAll();
            }
        });

        buttonRotateLeft.addClickHandler(event -> GameUI.this.actionRotateDown());
        buttonRotateRight.addClickHandler(event -> GameUI.this.actionRotateUp());
        buttonMoveLeft.addClickHandler(event -> GameUI.this.actionMoveLeft());
        buttonMoveRight.addClickHandler(event -> GameUI.this.actionMoveRight());
        buttonDrop.addClickHandler(event -> GameUI.this.actionDrop());

        final Label keysInfoLabel = new Label("Use \"arrows\" and \"space\" keys to control the game from the keyboard");
        keysInfoLabel.addStyleName("InfoLabel");
        RootPanel.get().add(keysInfoLabel);

    }

    static void createUI(final Canvas canvas) {
        new GameUI(canvas);
    }

    private void startNewGame() {
        engine = new GameEngine(BLOCKS_WIDTH, BLOCKS_HEIGHT);

        drawAll();

        Scheduler.get().scheduleFixedPeriod(() -> {
            if (!pause) {
                engine.nextGameStep();
            }
            drawAll();
            return !(engine.isGameOver());
        }, 500);
    }

    private void adjustBrowserCanvasSize(Canvas canvas) {
        widthCanvasPixels = (BLOCKS_WIDTH + 2) * BLOCK_SIZE * GAME_PIXEL_SIZE;
        heightCanvasPixels = (BLOCKS_HEIGHT + 5) * BLOCK_SIZE * GAME_PIXEL_SIZE;

        canvas.setPixelSize(widthCanvasPixels, heightCanvasPixels);
        canvas.setCoordinateSpaceWidth(widthCanvasPixels);
        canvas.setCoordinateSpaceHeight(heightCanvasPixels);
    }

    private void drawAll() {
        context.clearRect(0, 0, widthCanvasPixels, heightCanvasPixels);

        drawMatrixArea();

        final int textVerticalPadding = 2;
        PixelText tetrisTitle = new PixelText("TETRIS", "#ABABFF", 1);
        drawText(tetrisTitle, centeredXPosition(tetrisTitle.width()), textVerticalPadding);

        final int gameAreaXOffset = centeredXPosition(engine.widthBlocks() * BLOCK_SIZE);
        final int gameAreaYOffset = textVerticalPadding * 3 + tetrisTitle.height() * 2;

        Set<GameBlock> blocks = engine.getAllBlocks();

        blocks.forEach((block) -> drawBlock(block, gameAreaXOffset, gameAreaYOffset));

        int scoreYOffset = gameAreaYOffset + (engine.heightBlocks() * BLOCK_SIZE) + textVerticalPadding;
        PixelText scoreText = new PixelText("SCORE " + engine.score(), Color.GREY.code, 1);
        drawText(scoreText, centeredXPosition(scoreText.width()), scoreYOffset);

        if (engine.isGameOver()) {
            buttonGame.setText("Start");

            PixelText gameOverText = new PixelText("GAME OVER!", "#FF0000", 1);
            drawText(gameOverText, centeredXPosition(gameOverText.width()), textVerticalPadding * 2 + tetrisTitle.height());

        } else if (pause) {
            buttonGame.setText("Continue");
        } else {
            buttonGame.setText("Pause");
        }
    }

    private void actionDrop() {
        engine.drop();
        drawAll();
    }

    private void actionRotateUp() {
        engine.rotateUp();
        drawAll();
    }

    private void actionRotateDown() {
        engine.rotateDown();
        drawAll();
    }

    private void actionMoveLeft() {
        engine.moveLeft();
        drawAll();
    }

    private void actionMoveRight() {
        engine.moveRight();
        drawAll();
    }

    private int centeredXPosition(int gamePixelsWidth) {
        return (widthCanvasPixels / GAME_PIXEL_SIZE) / 2 - gamePixelsWidth / 2;
    }

    private void drawText(PixelText pixelText, int xOffset, int yOffset) {
        final List<Pixel> pixels = pixelText.pixels();
        pixels.forEach((pixel) -> drawPixel(pixel, xOffset, yOffset));
    }

    private void drawBlock(GameBlock block, int xOffset, int yOffset) {

        for (int i = 0; i < BLOCK_SIZE; i++) {
            for (int j = 0; j < BLOCK_SIZE; j++) {
                drawPixel(new Pixel(block.color.code, 0.8, (block.x * BLOCK_SIZE) + i + xOffset, (block.y * BLOCK_SIZE) + j + yOffset), 0, 0);
            }
        }
    }

    private void drawMatrixArea() {
        context.setLineWidth(1);
        context.setStrokeStyle(CssColor.make(100, 100, 100));
        context.setGlobalAlpha(0.1);

        for (int x = 0; x < widthCanvasPixels; x = x + GAME_PIXEL_SIZE) {
            drawLine(x, x, 0, this.heightCanvasPixels);
        }
        for (int y = 0; y < heightCanvasPixels; y = y + GAME_PIXEL_SIZE) {
            drawLine(0, this.widthCanvasPixels, y, y);
        }
    }

    private void drawLine(int xFrom, int xTo, int yFrom, int yTo) {
        context.beginPath();
        context.moveTo(xFrom, yFrom);
        context.lineTo(xTo, yTo);
        context.stroke();
    }

    private void drawPixel(Pixel pixel, int xOffset, int yOffset) {
        context.setGlobalAlpha(pixel.alpha);
        context.setFillStyle(pixel.color);
        final int absoluteX = GAME_PIXEL_SIZE * pixel.x + 1 + GAME_PIXEL_SIZE * xOffset;
        final int absoluteY = GAME_PIXEL_SIZE * pixel.y + 1 + GAME_PIXEL_SIZE * yOffset;
        context.fillRect(absoluteX, absoluteY, GAME_PIXEL_SIZE - 1, GAME_PIXEL_SIZE - 1);
    }

    private void keyPress(KEY key) {

        if (key == KEY.UP) {
            actionRotateUp();
        } else if (key == KEY.DOWN) {
            actionRotateDown();
        } else if (key == KEY.LEFT) {
            actionMoveLeft();
        } else if (key == KEY.RIGHT) {
            actionMoveRight();
        } else if (key == KEY.SPACE) {
            actionDrop();
        }
    }

    private enum KEY {
        UP, DOWN, LEFT, RIGHT, SPACE
    }
}
