package net.box256.tetris.client.game;

import java.util.Collection;

public class GameBlock {

    public final int x;
    public final int y;
    public final Color color;


    GameBlock(int x, int y) {
        this(x, y, Color.GREY);
    }

    GameBlock(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("Invalid position: " + this);
        }
    }

    static GameBlock search(Collection<GameBlock> blocks, int x, int y) {
        for (GameBlock block : blocks) {
            if (block.x == x && block.y == y) {
                return block;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "[" + x + ',' + y + ']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GameBlock)) {
            return false;
        }

        GameBlock gameBlock = (GameBlock) o;

        return x == gameBlock.x && y == gameBlock.y;

    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
