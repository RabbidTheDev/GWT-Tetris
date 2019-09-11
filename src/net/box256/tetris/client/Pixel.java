package net.box256.tetris.client;

class Pixel {

    final int x;
    final int y;
    final String color;
    final double alpha;

    Pixel(String color, double alpha, int x, int y) {
        this.color = color;
        this.alpha = alpha;
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pixel pixel = (Pixel) o;
        return x == pixel.x && y == pixel.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
