package net.box256.tetris.client.game;

import junit.framework.TestCase;

import java.util.Set;

public class GameFigureTest extends TestCase {

    public void testWellBlocks() {
        Well well = new Well(5, 7);
        assertEquals("" +
                "#   #\n" +
                "#   #\n" +
                "#   #\n" +
                "#   #\n" +
                "#   #\n" +
                "#   #\n" +
                "#####\n", well.toString());
        Set<GameBlock> blocks = well.getBlocks();
        assertEquals(17, blocks.size());

        well = new Well(6, 8);
        assertEquals("" +
                "#    #\n" +
                "#    #\n" +
                "#    #\n" +
                "#    #\n" +
                "#    #\n" +
                "#    #\n" +
                "#    #\n" +
                "######\n", well.toString());
        blocks = well.getBlocks();
        assertEquals(20, blocks.size());
    }

    public void testIllegalPosition() {
        final CustomFigure figure = new CustomFigure(2, 4);
        figure.addCustomBlock(0, 0);
        figure.addCustomBlock(1, 3);

        try {
            figure.addCustomBlock(-1, 0);
            fail("Should be illegal position exception");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid position: [-1,0]", e.getMessage());
        }

        try {
            figure.addCustomBlock(0, -1);
            fail("Should be illegal position exception");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid position: [0,-1]", e.getMessage());
        }

        try {
            figure.addCustomBlock(2, 0);
            fail("Should be illegal position exception");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid position: [2,0]", e.getMessage());
        }

        try {
            figure.addCustomBlock(0, 4);
            fail("Should be illegal position exception");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid position: [0,4]", e.getMessage());
        }

        assertEquals("" +
                "# \n" +
                "  \n" +
                "  \n" +
                " #\n", figure.toString());
    }

    public void testMerge() {
        final CustomFigure figure = new CustomFigure(3, 5);
        figure.addCustomBlock(0, 0);
        figure.addCustomBlock(2, 4);
        assertEquals("" +
                "#  \n" +
                "   \n" +
                "   \n" +
                "   \n" +
                "  #\n", figure.toString());

        final CustomFigure mergeFigure = new CustomFigure(4, 4);
        mergeFigure.addCustomBlock(1, 1);
        mergeFigure.addCustomBlock(2, 2);
        mergeFigure.addCustomBlock(3, 3);
        assertEquals("" +
                "    \n" +
                " #  \n" +
                "  # \n" +
                "   #\n", mergeFigure.toString());

        assertFalse("No conflicts expected", figure.conflict(mergeFigure));
        assertEquals("" +
                "#  \n" +
                "   \n" +
                "   \n" +
                "   \n" +
                "  #\n", figure.toString()); // no changes yet

        figure.merge(mergeFigure);
        assertEquals("" +
                "#  \n" +
                " # \n" +
                "  #\n" +
                "   \n" +
                "  #\n", figure.toString());


        //conflict figure
        final CustomFigure conflictFigure = new CustomFigure(3, 3);
        conflictFigure.addCustomBlock(1, 1);
        conflictFigure.addCustomBlock(2, 1);

        assertTrue("Should be conflict at 1,1", figure.conflict(conflictFigure));

        figure.merge(conflictFigure);
        assertEquals("" +
                "#  \n" +
                " ##\n" +
                "  #\n" +
                "   \n" +
                "  #\n", figure.toString());
    }

    private static class CustomFigure extends GameFigure {
        CustomFigure(int width, int height) {
            super(width, height);
        }

        void addCustomBlock(int x, int y) {
            addBlock(new GameBlock(x, y));
        }
    }

}
