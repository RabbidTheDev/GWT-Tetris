package net.box256.tetris.client.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

class Pile extends GameFigure {

    private int score = 0;

    Pile(int width, int height) {
        super(width, height);
    }

    boolean clearLine() {
        Set<GameBlock> blocks = getBlocks();

        final int fullLineSize = width - 2;

        for (int y = 0; y < (height - 1); y++) {
            List<GameBlock> line = new ArrayList<>();
            for (int x = 1; x < (width - 1); x++) {
                GameBlock block = GameBlock.search(blocks, x, y);
                if (block != null) {
                    line.add(block);
                }
            }
            if (line.size() == fullLineSize) {
                score++;
                line.forEach(this::removeBlock);
                moveUpperPartDown(y);
                return true;
            }
        }
        return false;
    }

    private void moveUpperPartDown(int lineY) {
        if (lineY == 0) {
            return;
        }
        Set<GameBlock> blocks = getBlocks();
        for (int y = (lineY - 1); y >= 0; y--) {
            for (int x = 1; x < (width - 1); x++) {
                GameBlock block = GameBlock.search(blocks, x, y);
                if (block != null) {
                    removeBlock(block);
                    addBlock(new GameBlock(x, y + 1, block.color));
                }
            }
        }
    }

    int score() {
        return score;
    }
}
