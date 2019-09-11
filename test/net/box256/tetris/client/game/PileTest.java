package net.box256.tetris.client.game;

import junit.framework.TestCase;

import java.util.Set;

public class PileTest extends TestCase {

    public void testClearLine() {
        Pile pile = new Pile(5, 5);
        pile.addBlock(new GameBlock(1, 0, Color.RED));
        pile.addBlock(new GameBlock(1, 1, Color.RED));
        pile.addBlock(new GameBlock(2, 1, Color.BLUE));
        pile.addBlock(new GameBlock(3, 2, Color.PURPLE));
        pile.addBlock(new GameBlock(2, 3, Color.LIME));

        assertFalse(pile.clearLine());
        assertEquals(0, pile.score());
        assertEquals("" +
                " #   \n" +
                " ##  \n" +
                "   # \n" +
                "  #  \n" +
                "     \n", pile.toString());

        pile.addBlock(new GameBlock(1, 2, Color.ORANGE));
        pile.addBlock(new GameBlock(2, 2, Color.ORANGE));
        assertEquals("" +
                " #   \n" +
                " ##  \n" +
                " ### \n" +
                "  #  \n" +
                "     \n", pile.toString());

        assertTrue(pile.clearLine());
        assertFalse(pile.clearLine());
        assertEquals(1, pile.score());
        assertEquals("" +
                "     \n" +
                " #   \n" +
                " ##  \n" +
                "  #  \n" +
                "     \n", pile.toString());

        //test colors are not lost
        Set<GameBlock> pileBlocks = pile.getBlocks();
        GameBlock redBlock = GameBlock.search(pileBlocks, 1, 1);
        assertNotNull(redBlock);
        assertEquals(Color.RED, redBlock.color);
        GameBlock limeBlock = GameBlock.search(pileBlocks, 2, 3);
        assertNotNull(limeBlock);
        assertEquals(Color.LIME, limeBlock.color);

        pile.addBlock(new GameBlock(2, 0));
        pile.addBlock(new GameBlock(3, 1));
        pile.addBlock(new GameBlock(3, 2));
        pile.addBlock(new GameBlock(1, 3));
        pile.addBlock(new GameBlock(3, 3));
        assertEquals("" +
                "  #  \n" +
                " # # \n" +
                " ### \n" +
                " ### \n" +
                "     \n", pile.toString());

        assertTrue(pile.clearLine());
        assertTrue(pile.clearLine());
        assertFalse(pile.clearLine());
        assertEquals(3, pile.score());
        assertEquals("" +
                "     \n" +
                "     \n" +
                "  #  \n" +
                " # # \n" +
                "     \n", pile.toString());
    }
}
