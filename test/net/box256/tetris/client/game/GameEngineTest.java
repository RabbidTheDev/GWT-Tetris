package net.box256.tetris.client.game;

import junit.framework.TestCase;

public class GameEngineTest extends TestCase {

    public void testStupidGame() {

        GameEngine engine = new GameEngine(8, 6) {
            @Override
            Tetromino.Type getNextTetrominoType() {
                return Tetromino.Type.T;
            }
        };

        assertFalse(engine.isGameOver());
        assertEquals("" +
                "#      #\n" +
                "#      #\n" +
                "#      #\n" +
                "#      #\n" +
                "#      #\n" +
                "########\n", engine.toString());

        engine.nextGameStep();
        assertFalse(engine.isGameOver());
        assertEquals("" +
                "#  ### #\n" +
                "#   #  #\n" +
                "#      #\n" +
                "#      #\n" +
                "#      #\n" +
                "########\n", engine.toString());

        engine.nextGameStep();
        engine.nextGameStep();
        engine.nextGameStep();
        engine.nextGameStep();
        assertFalse(engine.isGameOver());
        assertEquals("" +
                "#      #\n" +
                "#      #\n" +
                "#      #\n" +
                "#  ### #\n" +
                "#   #  #\n" +
                "########\n", engine.toString());

        engine.nextGameStep();
        assertFalse(engine.isGameOver());
        assertEquals("" +
                "#  ### #\n" +
                "#   #  #\n" +
                "#      #\n" +
                "#  ### #\n" +
                "#   #  #\n" +
                "########\n", engine.toString());

        engine.nextGameStep();
        assertEquals("" +
                "#      #\n" +
                "#  ### #\n" +
                "#   #  #\n" +
                "#  ### #\n" +
                "#   #  #\n" +
                "########\n", engine.toString());
        assertFalse(engine.isGameOver());

        engine.nextGameStep();
        assertEquals("" +
                "#      #\n" +
                "#  ### #\n" +
                "#   #  #\n" +
                "#  ### #\n" +
                "#   #  #\n" +
                "########\n", engine.toString());
        assertFalse(engine.isGameOver());

        engine.nextGameStep();
        assertEquals("" +
                "#  ### #\n" +
                "#  ### #\n" +
                "#   #  #\n" +
                "#  ### #\n" +
                "#   #  #\n" +
                "########\n", engine.toString());
        assertTrue(engine.isGameOver());

        //one more time after game is over
        engine.nextGameStep();
        assertEquals("" +
                "#  ### #\n" +
                "#  ### #\n" +
                "#   #  #\n" +
                "#  ### #\n" +
                "#   #  #\n" +
                "########\n", engine.toString());
        assertTrue(engine.isGameOver());
    }

    public void testSimpleGame() {

        GameEngine engine = new GameEngine(8, 6) {
            @Override
            Tetromino.Type getNextTetrominoType() {
                return Tetromino.Type.T;
            }
        };

        engine.nextGameStep();
        engine.nextGameStep();
        engine.moveLeft();
        assertEquals("" +
                "#      #\n" +
                "# ###  #\n" +
                "#  #   #\n" +
                "#      #\n" +
                "#      #\n" +
                "########\n", engine.toString());

        engine.moveLeft();
        engine.moveLeft();
        assertEquals("" +
                "#      #\n" +
                "####   #\n" +
                "# #    #\n" +
                "#      #\n" +
                "#      #\n" +
                "########\n", engine.toString());

        engine.moveRight();
        engine.moveRight();
        assertEquals("" +
                "#      #\n" +
                "#  ### #\n" +
                "#   #  #\n" +
                "#      #\n" +
                "#      #\n" +
                "########\n", engine.toString());

        engine.moveRight();
        engine.moveRight();
        assertEquals("" +
                "#      #\n" +
                "#   ####\n" +
                "#    # #\n" +
                "#      #\n" +
                "#      #\n" +
                "########\n", engine.toString());

        engine.rotateUp();
        assertEquals("" +
                "#      #\n" +
                "#    # #\n" +
                "#   ## #\n" +
                "#    # #\n" +
                "#      #\n" +
                "########\n", engine.toString());

        engine.rotateDown();
        assertEquals("" +
                "#      #\n" +
                "#   ####\n" +
                "#    # #\n" +
                "#      #\n" +
                "#      #\n" +
                "########\n", engine.toString());

        engine.drop();
        assertEquals("" +
                "#      #\n" +
                "#      #\n" +
                "#      #\n" +
                "#   ####\n" +
                "#    # #\n" +
                "########\n", engine.toString());

        engine.nextGameStep();
        assertEquals("" +
                "#  ### #\n" +
                "#   #  #\n" +
                "#      #\n" +
                "#   ####\n" +
                "#    # #\n" +
                "########\n", engine.toString());

        engine.moveLeft();
        engine.moveLeft();
        engine.drop();

        assertEquals("" +
                "#      #\n" +
                "#      #\n" +
                "#      #\n" +
                "#      #\n" +
                "# #  # #\n" +
                "########\n", engine.toString());

        engine.nextGameStep();
        assertEquals("" +
                "#  ### #\n" +
                "#   #  #\n" +
                "#      #\n" +
                "#      #\n" +
                "# #  # #\n" +
                "########\n", engine.toString());
    }

}
