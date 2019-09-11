package net.box256.tetris.client.game;

import java.util.HashSet;
import java.util.Set;

public class GameEngine {

    private final Well well;
    private final Pile pile;
    private Tetromino tetromino = null;
    private boolean gameOver = false;

    public GameEngine(int width, int height) {
        well = new Well(width, height);
        pile = new Pile(width, height);
    }

    public int widthBlocks() {
        return well.width;
    }

    public int heightBlocks() {
        return well.height;
    }

    public int score() {
        return pile.score();
    }

    public boolean isGameOver() {
        return gameOver;
    }

    @Override
    public String toString() {
        CompositeFigure compositeFigure = new CompositeFigure(well.width, well.height);
        compositeFigure.merge(well);
        compositeFigure.merge(pile);
        if (tetromino != null) {
            compositeFigure.merge(tetromino);
        }
        return compositeFigure.toString();
    }

    public void nextGameStep() {
        if (tetromino == null) {
            // place new tetromino
            tetromino = new Tetromino(well.width, well.height, getNextTetrominoType());
            if (tetromino.conflict(pile)) {
                gameOver = true;
            }
        } else {
            moveDown();
        }
    }

    private boolean moveDown() {
        Tetromino moveCheck = new Tetromino(tetromino);
        moveCheck.down();
        if (noConflictWithWellAndPile(moveCheck)) {
            tetromino.down();
            return true;
        } else {
            pile.merge(tetromino);
            tetromino = null;

            while (true) {
                if (!(pile.clearLine())) {
                    break;
                }
            }
            return false;
        }
    }

    private boolean noConflictWithWellAndPile(Tetromino moveCheck) {
        return (!moveCheck.conflict(well)) && (!moveCheck.conflict(pile));
    }

    public void moveLeft() {
        moveHorizontally(-1);
    }

    public void moveRight() {
        moveHorizontally(1);
    }

    private void moveHorizontally(int xDelta) {
        if (tetromino != null) {
            Tetromino moveCheck = new Tetromino(tetromino);
            moveCheck.move(xDelta, 0);
            if (noConflictWithWellAndPile(moveCheck)) {
                tetromino.move(xDelta, 0);
            }
        }
    }

    public void rotateUp() {
        rotate(Tetromino.Rotation.CLOCK_WISE);
    }

    public void rotateDown() {
        rotate(Tetromino.Rotation.COUNTER_CLOCK_WISE);
    }

    private void rotate(Tetromino.Rotation direction) {
        if (tetromino != null) {
            Tetromino moveCheck = new Tetromino(tetromino);
            moveCheck.rotate(direction);
            if (noConflictWithWellAndPile(moveCheck)) {
                tetromino.rotate(direction);
            }
        }
    }

    public void drop() {
        if (tetromino != null) {
            while (true) {
                if (!(moveDown())) {
                    break;
                }
            }
        }
    }

    public Set<GameBlock> getAllBlocks() {
        HashSet<GameBlock> gameBlocks = new HashSet<>();
        gameBlocks.addAll(well.getBlocks());
        gameBlocks.addAll(pile.getBlocks());
        if (tetromino != null) {
            gameBlocks.addAll(tetromino.getBlocks());
        }
        return gameBlocks;
    }

    Tetromino.Type getNextTetrominoType() {
        return Tetromino.Type.random();
    }

    private static class CompositeFigure extends GameFigure {

        CompositeFigure(int width, int height) {
            super(width, height);
        }
    }
}
