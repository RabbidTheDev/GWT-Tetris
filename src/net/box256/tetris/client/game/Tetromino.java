package net.box256.tetris.client.game;

import java.util.*;

class Tetromino extends GameFigure {

    @SuppressWarnings("PointlessArithmeticExpression")
    Tetromino(int width, int height, Type type) {
        super(width, height);

        int startXPosition = width / 2 - 1;

        switch (type) {

            case I:
                startXPosition = width / 2 - 2;
                addBlock(new GameBlock(startXPosition + 0, 0, Color.CYAN));
                addBlock(new GameBlock(startXPosition + 1, 0, Color.CYAN));
                addBlock(new GameBlock(startXPosition + 2, 0, Color.CYAN));
                addBlock(new GameBlock(startXPosition + 3, 0, Color.CYAN));
                break;

            case J:
                addBlock(new GameBlock(startXPosition + 0, 0, Color.BLUE));
                addBlock(new GameBlock(startXPosition + 1, 0, Color.BLUE));
                addBlock(new GameBlock(startXPosition + 2, 0, Color.BLUE));
                addBlock(new GameBlock(startXPosition + 2, 1, Color.BLUE));
                break;

            case L:
                addBlock(new GameBlock(startXPosition + 0, 0, Color.ORANGE));
                addBlock(new GameBlock(startXPosition + 1, 0, Color.ORANGE));
                addBlock(new GameBlock(startXPosition + 2, 0, Color.ORANGE));
                addBlock(new GameBlock(startXPosition + 0, 1, Color.ORANGE));
                break;

            case O:
                addBlock(new GameBlock(startXPosition + 0, 0, Color.YELLOW));
                addBlock(new GameBlock(startXPosition + 1, 0, Color.YELLOW));
                addBlock(new GameBlock(startXPosition + 0, 1, Color.YELLOW));
                addBlock(new GameBlock(startXPosition + 1, 1, Color.YELLOW));
                break;

            case S:
                addBlock(new GameBlock(startXPosition + 1, 0, Color.LIME));
                addBlock(new GameBlock(startXPosition + 2, 0, Color.LIME));
                addBlock(new GameBlock(startXPosition + 0, 1, Color.LIME));
                addBlock(new GameBlock(startXPosition + 1, 1, Color.LIME));
                break;

            case T:
                addBlock(new GameBlock(startXPosition + 0, 0, Color.PURPLE));
                addBlock(new GameBlock(startXPosition + 1, 0, Color.PURPLE));
                addBlock(new GameBlock(startXPosition + 2, 0, Color.PURPLE));
                addBlock(new GameBlock(startXPosition + 1, 1, Color.PURPLE));
                break;

            case Z:
                addBlock(new GameBlock(startXPosition + 0, 0, Color.RED));
                addBlock(new GameBlock(startXPosition + 1, 0, Color.RED));
                addBlock(new GameBlock(startXPosition + 1, 1, Color.RED));
                addBlock(new GameBlock(startXPosition + 2, 1, Color.RED));
                break;

            default:
                throw new RuntimeException("Cannot happen!!!");
        }
    }

    Tetromino(Tetromino copyFrom) {
        super(copyFrom);
    }

    boolean down() {
        return move(0, 1);
    }

    boolean left() {
        return move(-1, 0);
    }

    boolean right() {
        return move(1, 0);
    }

    boolean move(int xDelta, int yDelta) {
        final Set<GameBlock> blocks = getBlocks();

        final HashSet<GameBlock> movedBlocks = new HashSet<>(blocks.size());

        boolean canMove = true;
        for (GameBlock block : blocks) {
            final int newX = block.x + xDelta;
            final int newY = block.y + yDelta;

            if (newX < 0 || newY < 0 || newX >= width || newY >= height) {
                canMove = false;
                break;
            }

            GameBlock moved = new GameBlock(newX, newY, block.color);
            movedBlocks.add(moved);
        }

        if (canMove) {
            clear();
            movedBlocks.forEach(this::addBlock);
        }
        return canMove;
    }

    boolean rotateCounterClockWise() {
        return rotate(Rotation.COUNTER_CLOCK_WISE);
    }

    boolean rotateClockWise() {
        return rotate(Rotation.CLOCK_WISE);
    }

    boolean rotate(Rotation rotation) {
        final Set<GameBlock> blocks = getBlocks();

        int minXPosition = width;
        int minYPosition = height;

        //find out minimal X and Y positions
        for (GameBlock block : blocks) {
            if (block.x < minXPosition) {
                minXPosition = block.x;
            }
            if (block.y < minYPosition) {
                minYPosition = block.y;
            }
        }

        // rough rotation of full figure
        final HashSet<GameBlock> rotatedBlocks = new HashSet<>(blocks.size());
        for (GameBlock block : blocks) {
            final int newX = getXRotation(block, rotation);
            final int newY = getYRotation(block, rotation);
            GameBlock rotated = new GameBlock(newX, newY, block.color);
            rotatedBlocks.add(rotated);
        }

        @SuppressWarnings("SuspiciousNameCombination")
        int newMinXPosition = height; // yes height here
        @SuppressWarnings("SuspiciousNameCombination")
        int newMinYPosition = width;  // yes width here

        //find out minimal X and Y positions for rotated element
        for (GameBlock block : rotatedBlocks) {
            if (block.x < newMinXPosition) {
                newMinXPosition = block.x;
            }
            if (block.y < newMinYPosition) {
                newMinYPosition = block.y;
            }
        }

        int deltaXPosition = minXPosition - newMinXPosition;
        int deltaYPosition = minYPosition - newMinYPosition;

        final HashSet<GameBlock> adjustedBlocks = new HashSet<>(blocks.size());

        // adjust position and validate boundaries
        boolean canRotate = true;
        for (GameBlock rotatedBlock : rotatedBlocks) {

            //margin X and Y adjustment
            GameBlock adjustedBlock = new GameBlock(rotatedBlock.x + deltaXPosition, rotatedBlock.y + deltaYPosition, rotatedBlock.color);

            if (adjustedBlock.x < 0 || adjustedBlock.y < 0 || adjustedBlock.x >= width || adjustedBlock.y >= height) {
                canRotate = false;
                break;
            }
            adjustedBlocks.add(adjustedBlock);
        }

        if (canRotate) {
            clear();
            adjustedBlocks.forEach(this::addBlock);
        }
        return canRotate;
    }

    @SuppressWarnings("SuspiciousNameCombination")
    private int getXRotation(GameBlock block, Rotation rotation) {
        if (rotation == Rotation.COUNTER_CLOCK_WISE) {
            return block.y;
        } else if (rotation == Rotation.CLOCK_WISE) {
            return height - block.y;
        }
        throw new RuntimeException("Invalid rotation parameter");
    }

    @SuppressWarnings("SuspiciousNameCombination")
    private int getYRotation(GameBlock block, Rotation rotation) {
        if (rotation == Rotation.COUNTER_CLOCK_WISE) {
            return width - block.x;
        } else if (rotation == Rotation.CLOCK_WISE) {
            return block.x;
        }
        throw new RuntimeException("Invalid rotation parameter");
    }

    enum Type {
        I, J, L, O, S, T, Z;

        private static final List<Type> TYPES = Collections.unmodifiableList(Arrays.asList(values()));
        private static final int SIZE = TYPES.size();
        private static final Random RANDOM = new Random();

        public static Type random() {
            return TYPES.get(RANDOM.nextInt(SIZE));
        }
    }

    enum Rotation {
        COUNTER_CLOCK_WISE, CLOCK_WISE
    }
}
