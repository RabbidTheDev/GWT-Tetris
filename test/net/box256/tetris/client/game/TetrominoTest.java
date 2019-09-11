package net.box256.tetris.client.game;

import junit.framework.TestCase;

public class TetrominoTest extends TestCase {

    public void testMoveZ() {
        Tetromino z = new Tetromino(8, 6, Tetromino.Type.Z);
        assertEquals("" +
                "   ##   \n" +
                "    ##  \n" +
                "        \n" +
                "        \n" +
                "        \n" +
                "        \n" +
                "", z.toString());

        assertTrue(z.down());
        assertEquals("" +
                "        \n" +
                "   ##   \n" +
                "    ##  \n" +
                "        \n" +
                "        \n" +
                "        \n" +
                "", z.toString());

        assertTrue(z.left());
        assertEquals("" +
                "        \n" +
                "  ##    \n" +
                "   ##   \n" +
                "        \n" +
                "        \n" +
                "        \n" +
                "", z.toString());
        assertTrue(z.left());
        assertTrue(z.left());
        assertFalse(z.left());
        assertEquals("" +
                "        \n" +
                "##      \n" +
                " ##     \n" +
                "        \n" +
                "        \n" +
                "        \n" +
                "", z.toString());

        assertTrue(z.right());
        assertEquals("" +
                "        \n" +
                " ##     \n" +
                "  ##    \n" +
                "        \n" +
                "        \n" +
                "        \n" +
                "", z.toString());
        assertTrue(z.right());
        assertTrue(z.right());
        assertTrue(z.right());
        assertTrue(z.right());
        assertFalse(z.right());
        assertEquals("" +
                "        \n" +
                "     ## \n" +
                "      ##\n" +
                "        \n" +
                "        \n" +
                "        \n" +
                "", z.toString());

        assertTrue(z.down());
        assertTrue(z.down());
        assertEquals("" +
                "        \n" +
                "        \n" +
                "        \n" +
                "     ## \n" +
                "      ##\n" +
                "        \n" +
                "", z.toString());

        assertTrue(z.down());
        assertFalse(z.down());
        assertEquals("" +
                "        \n" +
                "        \n" +
                "        \n" +
                "        \n" +
                "     ## \n" +
                "      ##\n" +
                "", z.toString());

        assertEquals(Color.RED, z.getBlocks().iterator().next().color);
    }

    public void testRotateL() {
        Tetromino tetromino = new Tetromino(6, 4, Tetromino.Type.L);
        assertEquals("" +
                "  ### \n" +
                "  #   \n" +
                "      \n" +
                "      \n" +
                "", tetromino.toString());

        tetromino.rotateClockWise();
        assertEquals("" +
                "  ##  \n" +
                "   #  \n" +
                "   #  \n" +
                "      \n" +
                "", tetromino.toString());

        tetromino.rotateClockWise();
        assertEquals("" +
                "    # \n" +
                "  ### \n" +
                "      \n" +
                "      \n" +
                "", tetromino.toString());

        tetromino.rotateClockWise();
        assertEquals("" +
                "  #   \n" +
                "  #   \n" +
                "  ##  \n" +
                "      \n" +
                "", tetromino.toString());

        tetromino.rotateCounterClockWise();
        assertEquals("" +
                "    # \n" +
                "  ### \n" +
                "      \n" +
                "      \n" +
                "", tetromino.toString());


        tetromino.down();
        tetromino.right();
        tetromino.right();
        tetromino.right();
        assertEquals("" +
                "      \n" +
                "     #\n" +
                "   ###\n" +
                "      \n" +
                "", tetromino.toString());

        assertEquals(Color.ORANGE, tetromino.getBlocks().iterator().next().color);
    }

    public void testI() {

        Tetromino tetromino = new Tetromino(8, 6, Tetromino.Type.I);
        assertEquals("" +
                "  ####  \n" +
                "        \n" +
                "        \n" +
                "        \n" +
                "        \n" +
                "        \n" +
                "", tetromino.toString());

        assertTrue(tetromino.rotateClockWise());
        assertEquals("" +
                "  #     \n" +
                "  #     \n" +
                "  #     \n" +
                "  #     \n" +
                "        \n" +
                "        \n" +
                "", tetromino.toString());

        assertTrue(tetromino.rotateClockWise());
        assertEquals("" +
                "  ####  \n" +
                "        \n" +
                "        \n" +
                "        \n" +
                "        \n" +
                "        \n" +
                "", tetromino.toString());

        assertTrue(tetromino.rotateCounterClockWise());
        assertEquals("" +
                "  #     \n" +
                "  #     \n" +
                "  #     \n" +
                "  #     \n" +
                "        \n" +
                "        \n" +
                "", tetromino.toString());

        assertTrue(tetromino.right());
        assertTrue(tetromino.right());
        assertTrue(tetromino.right());
        assertTrue(tetromino.right());
        assertTrue(tetromino.right());
        assertFalse(tetromino.right());
        assertEquals("" +
                "       #\n" +
                "       #\n" +
                "       #\n" +
                "       #\n" +
                "        \n" +
                "        \n" +
                "", tetromino.toString());

        assertFalse(tetromino.rotateClockWise());
        assertEquals("" +
                "       #\n" +
                "       #\n" +
                "       #\n" +
                "       #\n" +
                "        \n" +
                "        \n" +
                "", tetromino.toString());

        assertEquals(Color.CYAN, tetromino.getBlocks().iterator().next().color);
    }

    public void testT() {

        Tetromino tetromino = new Tetromino(7, 4, Tetromino.Type.T);
        assertEquals("" +
                "  ###  \n" +
                "   #   \n" +
                "       \n" +
                "       \n" +
                "", tetromino.toString());

        assertTrue(tetromino.rotateClockWise());
        assertEquals("" +
                "   #   \n" +
                "  ##   \n" +
                "   #   \n" +
                "       \n" +
                "", tetromino.toString());

        assertTrue(tetromino.rotateClockWise());
        assertEquals("" +
                "   #   \n" +
                "  ###  \n" +
                "       \n" +
                "       \n" +
                "", tetromino.toString());

        assertTrue(tetromino.rotateCounterClockWise());
        assertEquals("" +
                "   #   \n" +
                "  ##   \n" +
                "   #   \n" +
                "       \n" +
                "", tetromino.toString());

        assertTrue(tetromino.right());
        assertTrue(tetromino.right());
        assertTrue(tetromino.right());
        assertFalse(tetromino.right());
        assertFalse(tetromino.rotateClockWise());
        assertEquals("" +
                "      #\n" +
                "     ##\n" +
                "      #\n" +
                "       \n" +
                "", tetromino.toString());

        assertEquals(Color.PURPLE, tetromino.getBlocks().iterator().next().color);
    }

    public void testS() {

        Tetromino tetromino = new Tetromino(7, 4, Tetromino.Type.S);
        assertEquals("" +
                "   ##  \n" +
                "  ##   \n" +
                "       \n" +
                "       \n" +
                "", tetromino.toString());

        assertTrue(tetromino.rotateClockWise());
        assertEquals("" +
                "  #    \n" +
                "  ##   \n" +
                "   #   \n" +
                "       \n" +
                "", tetromino.toString());

        assertTrue(tetromino.rotateClockWise());
        assertEquals("" +
                "   ##  \n" +
                "  ##   \n" +
                "       \n" +
                "       \n" +
                "", tetromino.toString());

        assertTrue(tetromino.rotateCounterClockWise());
        assertEquals("" +
                "  #    \n" +
                "  ##   \n" +
                "   #   \n" +
                "       \n" +
                "", tetromino.toString());

        assertTrue(tetromino.left());
        assertTrue(tetromino.left());
        assertFalse(tetromino.left());
        assertTrue(tetromino.rotateCounterClockWise());
        assertEquals("" +
                " ##    \n" +
                "##     \n" +
                "       \n" +
                "       \n" +
                "", tetromino.toString());

        assertEquals(Color.LIME, tetromino.getBlocks().iterator().next().color);
    }

    public void testO() {

        Tetromino tetromino = new Tetromino(7, 4, Tetromino.Type.O);
        assertEquals("" +
                "  ##   \n" +
                "  ##   \n" +
                "       \n" +
                "       \n" +
                "", tetromino.toString());

        assertTrue(tetromino.rotateClockWise());
        assertEquals("" +
                "  ##   \n" +
                "  ##   \n" +
                "       \n" +
                "       \n" +
                "", tetromino.toString());

        assertTrue(tetromino.rotateCounterClockWise());
        assertEquals("" +
                "  ##   \n" +
                "  ##   \n" +
                "       \n" +
                "       \n" +
                "", tetromino.toString());

        assertTrue(tetromino.right());
        assertTrue(tetromino.right());
        assertTrue(tetromino.right());
        assertFalse(tetromino.right());
        assertTrue(tetromino.rotateClockWise());
        assertEquals("" +
                "     ##\n" +
                "     ##\n" +
                "       \n" +
                "       \n" +
                "", tetromino.toString());

        assertEquals(Color.YELLOW, tetromino.getBlocks().iterator().next().color);
    }

    public void testJ() {

        Tetromino tetromino = new Tetromino(7, 4, Tetromino.Type.J);
        assertEquals("" +
                "  ###  \n" +
                "    #  \n" +
                "       \n" +
                "       \n" +
                "", tetromino.toString());

        assertTrue(tetromino.rotateClockWise());
        assertEquals("" +
                "   #   \n" +
                "   #   \n" +
                "  ##   \n" +
                "       \n" +
                "", tetromino.toString());

        assertTrue(tetromino.rotateClockWise());
        assertEquals("" +
                "  #    \n" +
                "  ###  \n" +
                "       \n" +
                "       \n" +
                "", tetromino.toString());

        assertTrue(tetromino.rotateClockWise());
        assertEquals("" +
                "  ##   \n" +
                "  #    \n" +
                "  #    \n" +
                "       \n" +
                "", tetromino.toString());

        assertTrue(tetromino.rotateCounterClockWise());
        assertTrue(tetromino.rotateCounterClockWise());
        assertEquals("" +
                "   #   \n" +
                "   #   \n" +
                "  ##   \n" +
                "       \n" +
                "", tetromino.toString());


        assertTrue(tetromino.right());
        assertTrue(tetromino.right());
        assertTrue(tetromino.right());
        assertTrue(tetromino.down());
        assertFalse(tetromino.down());
        assertFalse(tetromino.right());
        assertFalse(tetromino.rotateClockWise());
        assertEquals("" +
                "       \n" +
                "      #\n" +
                "      #\n" +
                "     ##\n" +
                "", tetromino.toString());

        assertEquals(Color.BLUE, tetromino.getBlocks().iterator().next().color);
    }


    public void testCopy() {

        Tetromino tetromino = new Tetromino(5, 4, Tetromino.Type.T);

        Tetromino clone = new Tetromino(tetromino);

        clone.down();

        assertEquals("" +
                " ### \n" +
                "  #  \n" +
                "     \n" +
                "     \n" +
                "", tetromino.toString());

        assertEquals("" +
                "     \n" +
                " ### \n" +
                "  #  \n" +
                "     \n" +
                "", clone.toString());
    }
}
