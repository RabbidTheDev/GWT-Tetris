package net.box256.tetris.client;

import junit.framework.TestCase;

import java.util.List;

public class TextTest extends TestCase {

    public void testTextOutput() {

        PixelText text = new PixelText("AB C12", "#CCCCCC", 1);

        assertEquals(text.height(), 5);
        assertEquals(text.width(), 6 * 6);

        assertEquals("" +
                        " ###  ####         ###    #   ####  \n" +
                        "#   # #   #       #   #  ##       # \n" +
                        "##### ####        #       #    ###  \n" +
                        "#   # #   #       #   #   #   #     \n" +
                        "#   # ####         ###    #   ##### \n",
                text.toString());

        text = new PixelText("ABCDEFGHIJKLMNOPQRSTUVWXYZ 1234567890 ., !?", "#CCCCCC", 1);

        System.out.print(text);

        int controlSum = 0;
        final List<Pixel> pixels = text.pixels();
        for (Pixel pixel : pixels) {
            controlSum = controlSum + pixel.x + pixel.y;
        }
        assertEquals("Control sum check failed", 51298, controlSum);
    }

}
