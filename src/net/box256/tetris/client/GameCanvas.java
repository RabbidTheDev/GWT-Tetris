package net.box256.tetris.client;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.canvas.dom.client.CssColor;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.user.client.Window;
import net.box256.tetris.client.game.Color;
import net.box256.tetris.client.game.GameBlock;
import net.box256.tetris.client.game.GameEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

class GameCanvas {

    private final int GAME_PIXEL_SIZE = 6;
    private final int BLOCK_SIZE = 5;
    private final int BLOCKS_WIDTH = 12;
    private final int BLOCKS_HEIGHT = 21;

    private final Context2d context;
    private GameEngine engine;
    private int widthCanvasPixels;
    private int heightCanvasPixels;
    private List<PixelButton> buttons = new ArrayList<>();
    private Boolean pause = false;

    GameCanvas(final Canvas canvas) {

        adjustBrowserCanvasSize(canvas);

        context = canvas.getContext2d();

        startNewGame();

        Window.addResizeHandler(event -> {
            adjustBrowserCanvasSize(canvas);
            drawAll();
        });

        canvas.addClickHandler(event -> {
            final int x = event.getX() / GAME_PIXEL_SIZE;
            final int y = event.getY() / GAME_PIXEL_SIZE;
            //drawText(new PixelText("X", Color.GREY.code, 1.0), x - 2, y - 2);

            //invoke correspondent button
            for (PixelButton pixelButton : buttons) {
                if ((pixelButton.xOffset <= x) && ((pixelButton.xOffset + pixelButton.width()) >= x)) {
                    if ((pixelButton.yOffset <= y) && ((pixelButton.yOffset + pixelButton.height()) >= y)) {
                        pixelButton.onClick();
                    }
                }
            }

        });
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
        widthCanvasPixels = (BLOCKS_WIDTH + 18) * BLOCK_SIZE * GAME_PIXEL_SIZE;
        heightCanvasPixels = (BLOCKS_HEIGHT + 8) * BLOCK_SIZE * GAME_PIXEL_SIZE;

        canvas.setPixelSize(widthCanvasPixels, heightCanvasPixels);
        canvas.setCoordinateSpaceWidth(widthCanvasPixels);
        canvas.setCoordinateSpaceHeight(heightCanvasPixels);
    }

    private void drawAll() {
        context.clearRect(0, 0, widthCanvasPixels, heightCanvasPixels);
        buttons.clear();

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

        PixelButton gameButton;
        if (engine.isGameOver()) {
            PixelText gameOverText = new PixelText("GAME OVER!", "#FF0000", 1);
            drawText(gameOverText, centeredXPosition(gameOverText.width()), textVerticalPadding * 2 + tetrisTitle.height());

            gameButton = new PixelButton("START", Color.BLUE.code, 1) {
                @Override
                public void onClick() {
                    startNewGame();
                }
            };
        } else {
            gameButton = new PixelButton(pause ? "CONTINUE" : "PAUSE", Color.GREY.code, 1) {
                @Override
                public void onClick() {
                    pause = (!pause);
                    drawAll();
                }
            };
        }
        gameButton.xOffset = centeredXPosition(gameButton.width());
        gameButton.yOffset = scoreYOffset + textVerticalPadding + scoreText.height();
        drawButton(gameButton);
        buttons.add(gameButton);

        // move buttons
        final int moveButtonsYPosition = gameAreaYOffset + (engine.heightBlocks() * BLOCK_SIZE / 2);

        final PixelButton moveLeftButton = new PixelButton("LEFT", "#000000", 1) {
            @Override
            public void onClick() {
                engine.moveLeft();
                drawAll();
            }
        };

        moveLeftButton.xOffset = gameAreaXOffset - moveLeftButton.width() - 2;
        moveLeftButton.yOffset = moveButtonsYPosition;
        drawButton(moveLeftButton);
        buttons.add(moveLeftButton);

        final PixelButton moveRightButton = new PixelButton("RIGHT", "#000000", 1) {
            @Override
            public void onClick() {
                engine.moveRight();
                drawAll();
            }
        };
        moveRightButton.xOffset = gameAreaXOffset + (engine.widthBlocks() * BLOCK_SIZE) + 2;
        moveRightButton.yOffset = moveButtonsYPosition;
        drawButton(moveRightButton);
        buttons.add(moveRightButton);

        // rotate buttons
        final int rotateButtonsYPosition = gameAreaYOffset + (engine.heightBlocks() * BLOCK_SIZE / 2) - (BLOCK_SIZE * 3);

        final PixelButton rotateLeftButton = new PixelButton("ROTATE", "#000000", 1) {
            @Override
            public void onClick() {
                engine.rotateDown();
                drawAll();
            }
        };

        rotateLeftButton.xOffset = gameAreaXOffset - rotateLeftButton.width() - 2;
        rotateLeftButton.yOffset = rotateButtonsYPosition;
        drawButton(rotateLeftButton);
        buttons.add(rotateLeftButton);

        final PixelButton rotateRightButton = new PixelButton("ROTATE", "#000000", 1) {
            @Override
            public void onClick() {
                engine.rotateUp();
                drawAll();
            }
        };
        rotateRightButton.xOffset = gameAreaXOffset + (engine.widthBlocks() * BLOCK_SIZE) + 2;
        rotateRightButton.yOffset = rotateButtonsYPosition;
        drawButton(rotateRightButton);
        buttons.add(rotateRightButton);

        final int dropButtonsYPosition = gameAreaYOffset + (engine.heightBlocks() * BLOCK_SIZE / 2) + (BLOCK_SIZE * 3);

        final PixelButton dropLeftButton = new PixelButton("DROP", "#000000", 1) {
            @Override
            public void onClick() {
                engine.drop();
                drawAll();
            }
        };

        dropLeftButton.xOffset = gameAreaXOffset - dropLeftButton.width() - 2;
        dropLeftButton.yOffset = dropButtonsYPosition;
        drawButton(dropLeftButton);
        buttons.add(dropLeftButton);

        final PixelButton dropRightButton = new PixelButton("DROP", "#000000", 1) {
            @Override
            public void onClick() {
                engine.drop();
                drawAll();
            }
        };
        dropRightButton.xOffset = gameAreaXOffset + (engine.widthBlocks() * BLOCK_SIZE) + 2;
        dropRightButton.yOffset = dropButtonsYPosition;
        drawButton(dropRightButton);
        buttons.add(dropRightButton);
    }

    private int centeredXPosition(int gamePixelsWidth) {
        return (widthCanvasPixels / GAME_PIXEL_SIZE) / 2 - gamePixelsWidth / 2;
    }

    private void drawText(PixelText pixelText, int xOffset, int yOffset) {
        final List<Pixel> pixels = pixelText.pixels();
        pixels.forEach((pixel) -> drawPixel(pixel, xOffset, yOffset));
    }

    private void drawButton(PixelButton pixelButton) {
        final List<Pixel> pixels = pixelButton.pixels();
        pixels.forEach((pixel) -> drawPixel(pixel, pixelButton.xOffset, pixelButton.yOffset));
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

    void keyPress(KEY key) {

        boolean changed = false;
        if (key == KEY.UP) {
            engine.rotateUp();
            changed = true;
        } else if (key == KEY.DOWN) {
            engine.rotateDown();
            changed = true;
        } else if (key == KEY.LEFT) {
            engine.moveLeft();
            changed = true;
        } else if (key == KEY.RIGHT) {
            engine.moveRight();
            changed = true;
        } else if (key == KEY.SPACE) {
            engine.drop();
            changed = true;
        }

        if (changed) {
            drawAll();
        }

    }

    enum KEY {
        UP, DOWN, LEFT, RIGHT, SPACE
    }
}
