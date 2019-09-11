package net.box256.tetris.client.game;

import java.util.HashSet;
import java.util.Set;

abstract class GameFigure {

    final int width;
    final int height;
    private final HashSet<GameBlock> blocks;

    GameFigure(int width, int height) {
        this.width = width;
        this.height = height;
        blocks = new HashSet<>();
    }

    GameFigure(GameFigure copyFrom) {
        this(copyFrom.width, copyFrom.height);
        final Set<GameBlock> blocks = copyFrom.getBlocks();
        for (GameBlock blockToCopy : blocks) {
            addBlock(new GameBlock(blockToCopy.x, blockToCopy.y));
        }
    }

    void addBlock(GameBlock gameBlock) {
        if (gameBlock.x >= width || gameBlock.y >= height) {
            throw new IllegalArgumentException("Invalid position: " + gameBlock);
        }
        blocks.add(gameBlock);
    }

    void removeBlock(GameBlock gameBlock) {
        blocks.remove(gameBlock);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (blocks.contains(new GameBlock(x, y))) {
                    builder.append("#");
                } else {
                    builder.append(" ");
                }
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    Set<GameBlock> getBlocks() {
        return new HashSet<>(blocks);
    }

    void clear() {
        blocks.clear();
    }

    void merge(GameFigure figure) {
        final Set<GameBlock> mergeBlocks = figure.getBlocks();
        //noinspection Convert2streamapi
        for (GameBlock mergeBlock : mergeBlocks) {
            if (mergeBlock.x < width && mergeBlock.y < height) {
                addBlock(mergeBlock);
            }
        }
    }

    boolean conflict(GameFigure figure) {
        boolean conflict = false;
        final Set<GameBlock> blocks = figure.getBlocks();
        for (GameBlock block : blocks) {
            if (this.blocks.contains(block)) {
                conflict = true;
                break;
            }
        }
        return conflict;
    }
}
