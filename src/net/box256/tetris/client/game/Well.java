package net.box256.tetris.client.game;

class Well extends GameFigure {

    Well(int width, int height) {
        super(width, height);

        for (int x = 0; x < width; x++) {
            addBlock(new GameBlock(x, height - 1));
        }
        for (int y = 0; y < height; y++) {
            addBlock(new GameBlock(0, y));
            addBlock(new GameBlock(width - 1, y));
        }
    }
}
