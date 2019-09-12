package net.box256.tetris.client;

import java.util.ArrayList;
import java.util.List;

class PixelText {

    private static final int SYMBOL_LENGTH = 6;

    private final String text;

    private final String color;
    private final double alpha;


    PixelText(String text, String color, double alpha) {
        this.text = text;
        this.color = color;
        this.alpha = alpha;
    }

    int height() {
        return 5;
    }

    int width() {
        return text.length() * SYMBOL_LENGTH;
    }

    private static final String symbol_A = "" +
            " ###  " +
            "#   # " +
            "##### " +
            "#   # " +
            "#   # ";
    private static final String symbol_B = "" +
            "####  " +
            "#   # " +
            "####  " +
            "#   # " +
            "####  ";

    private Pixel pixel(int symbolPosition, int xOffset, int yOffset) {
        return new Pixel(color, alpha, symbolPosition * SYMBOL_LENGTH + xOffset, yOffset);
    }

    @Override
    public String toString() {
        final List<Pixel> pixelList = pixels();

        final StringBuilder builder = new StringBuilder();

        for (int y = 0; y < height(); y++) {
            for (int x = 0; x < width(); x++) {
                if (pixelList.contains(new Pixel("", 1, x, y))) {
                    builder.append("#");
                } else {
                    builder.append(" ");
                }
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    private static final String symbol_C = "" +
            " ###  " +
            "#   # " +
            "#     " +
            "#   # " +
            " ###  ";
    private static final String symbol_D = "" +
            "####  " +
            "#   # " +
            "#   # " +
            "#   # " +
            "####  ";
    private static final String symbol_E = "" +
            "##### " +
            "#     " +
            "####  " +
            "#     " +
            "##### ";
    private static final String symbol_F = "" +
            "##### " +
            "#     " +
            "####  " +
            "#     " +
            "#     ";
    private static final String symbol_G = "" +
            " #### " +
            "#     " +
            "# ### " +
            "#   # " +
            " ###  ";
    private static final String symbol_H = "" +
            "#   # " +
            "#   # " +
            "##### " +
            "#   # " +
            "#   # ";
    private static final String symbol_I = "" +
            "##### " +
            "  #   " +
            "  #   " +
            "  #   " +
            "##### ";
    private static final String symbol_J = "" +
            "   ## " +
            "    # " +
            "#   # " +
            "#   # " +
            " ###  ";
    private static final String symbol_K = "" +
            "#   # " +
            "#  #  " +
            "###   " +
            "#  #  " +
            "#   # ";
    private static final String symbol_L = "" +
            "#     " +
            "#     " +
            "#     " +
            "#     " +
            "##### ";
    private static final String symbol_M = "" +
            "#   # " +
            "## ## " +
            "# # # " +
            "#   # " +
            "#   # ";
    private static final String symbol_N = "" +
            "#   # " +
            "##  # " +
            "# # # " +
            "#  ## " +
            "#   # ";
    private static final String symbol_O = "" +
            " ###  " +
            "#   # " +
            "#   # " +
            "#   # " +
            " ###  ";
    private static final String symbol_P = "" +
            "####  " +
            "#   # " +
            "####  " +
            "#     " +
            "#     ";
    private static final String symbol_Q = "" +
            " ###  " +
            "#   # " +
            "#   # " +
            "#  #  " +
            " ## # ";
    private static final String symbol_R = "" +
            "####  " +
            "#   # " +
            "####  " +
            "#   # " +
            "#   # ";
    private static final String symbol_S = "" +
            " #### " +
            "#     " +
            " ###  " +
            "    # " +
            "####  ";
    private static final String symbol_T = "" +
            "##### " +
            "  #   " +
            "  #   " +
            "  #   " +
            "  #   ";
    private static final String symbol_U = "" +
            "#   # " +
            "#   # " +
            "#   # " +
            "#   # " +
            " ###  ";
    private static final String symbol_V = "" +
            "#   # " +
            "#   # " +
            "#   # " +
            " # #  " +
            "  #   ";
    private static final String symbol_W = "" +
            "#   # " +
            "#   # " +
            "# # # " +
            "## ## " +
            "#   # ";
    private static final String symbol_X = "" +
            "#   # " +
            " # #  " +
            "  #   " +
            " # #  " +
            "#   # ";
    private static final String symbol_Y = "" +
            "#   # " +
            " # #  " +
            "  #   " +
            "  #   " +
            "  #   ";
    private static final String symbol_Z = "" +
            "##### " +
            "   #  " +
            "  #   " +
            " #    " +
            "##### ";
    private static final String symbol_SPACE = "" +
            "      " +
            "      " +
            "      " +
            "      " +
            "      ";
    private static final String symbol_DOT = "" +
            "      " +
            "      " +
            "      " +
            "  ##  " +
            "  ##  ";
    private static final String symbol_COMMA = "" +
            "      " +
            "      " +
            "      " +
            "  ##  " +
            "   #  ";
    private static final String symbol_EXCLAMATION = "" +
            "  #   " +
            "  #   " +
            "  #   " +
            "      " +
            "  #   ";
    private static final String symbol_QUESTION = "" +
            " ###  " +
            "#   # " +
            "  ##  " +
            "      " +
            "  #   ";
    private static final String symbol_UNKNOWN = "" +
            "######" +
            "#    #" +
            "#    #" +
            "#    #" +
            "######";
    private static final String symbol_1 = "" +
            "  #   " +
            " ##   " +
            "  #   " +
            "  #   " +
            "  #   ";
    private static final String symbol_2 = "" +
            "####  " +
            "    # " +
            " ###  " +
            "#     " +
            "##### ";
    private static final String symbol_3 = "" +
            " ###  " +
            "#   # " +
            "  ##  " +
            "#   # " +
            " ###  ";
    private static final String symbol_4 = "" +
            "#   # " +
            "#   # " +
            "##### " +
            "    # " +
            "    # ";
    private static final String symbol_5 = "" +
            "##### " +
            "#     " +
            "####  " +
            "    # " +
            "####  ";
    private static final String symbol_6 = "" +
            " #### " +
            "#     " +
            "####  " +
            "#   # " +
            " ###  ";
    private static final String symbol_7 = "" +
            "##### " +
            "    # " +
            "   #  " +
            "  #   " +
            "  #   ";
    private static final String symbol_8 = "" +
            " ###  " +
            "#   # " +
            " ###  " +
            "#   # " +
            " ###  ";
    private static final String symbol_9 = "" +
            " ###  " +
            "#   # " +
            " #### " +
            "    # " +
            "####  ";
    private static final String symbol_0 = "" +
            " ###  " +
            "#   # " +
            "#   # " +
            "#   # " +
            " ###  ";

    List<Pixel> pixels() {

        List<Pixel> pixelList = new ArrayList<>();

        for (int position = 0; position < text.length(); position++) {
            final char c = text.charAt(position);

            String matrix = symbol_UNKNOWN;

            switch (c) {
                case ' ':
                    matrix = symbol_SPACE;
                    break;
                case 'A':
                    matrix = symbol_A;
                    break;
                case 'B':
                    matrix = symbol_B;
                    break;
                case 'C':
                    matrix = symbol_C;
                    break;
                case 'D':
                    matrix = symbol_D;
                    break;
                case 'E':
                    matrix = symbol_E;
                    break;
                case 'F':
                    matrix = symbol_F;
                    break;
                case 'G':
                    matrix = symbol_G;
                    break;
                case 'H':
                    matrix = symbol_H;
                    break;
                case 'I':
                    matrix = symbol_I;
                    break;
                case 'J':
                    matrix = symbol_J;
                    break;
                case 'K':
                    matrix = symbol_K;
                    break;
                case 'L':
                    matrix = symbol_L;
                    break;
                case 'M':
                    matrix = symbol_M;
                    break;
                case 'N':
                    matrix = symbol_N;
                    break;
                case 'O':
                    matrix = symbol_O;
                    break;
                case 'P':
                    matrix = symbol_P;
                    break;
                case 'Q':
                    matrix = symbol_Q;
                    break;
                case 'R':
                    matrix = symbol_R;
                    break;
                case 'S':
                    matrix = symbol_S;
                    break;
                case 'T':
                    matrix = symbol_T;
                    break;
                case 'U':
                    matrix = symbol_U;
                    break;
                case 'V':
                    matrix = symbol_V;
                    break;
                case 'W':
                    matrix = symbol_W;
                    break;
                case 'X':
                    matrix = symbol_X;
                    break;
                case 'Y':
                    matrix = symbol_Y;
                    break;
                case 'Z':
                    matrix = symbol_Z;
                    break;

                case '1':
                    matrix = symbol_1;
                    break;
                case '2':
                    matrix = symbol_2;
                    break;
                case '3':
                    matrix = symbol_3;
                    break;
                case '4':
                    matrix = symbol_4;
                    break;
                case '5':
                    matrix = symbol_5;
                    break;
                case '6':
                    matrix = symbol_6;
                    break;
                case '7':
                    matrix = symbol_7;
                    break;
                case '8':
                    matrix = symbol_8;
                    break;
                case '9':
                    matrix = symbol_9;
                    break;
                case '0':
                    matrix = symbol_0;
                    break;

                case '.':
                    matrix = symbol_DOT;
                    break;
                case ',':
                    matrix = symbol_COMMA;
                    break;
                case '!':
                    matrix = symbol_EXCLAMATION;
                    break;
                case '?':
                    matrix = symbol_QUESTION;
                    break;
            }

            pixelList.addAll(matrixToPixels(position, matrix));
        }

        return pixelList;
    }

    private List<Pixel> matrixToPixels(int position, String matrix) {
        List<Pixel> pixelList = new ArrayList<>();

        for (int row = 0; row < height(); row++) {
            for (int col = 0; col < SYMBOL_LENGTH; col++) {
                if (matrix.charAt((row * SYMBOL_LENGTH) + col) == '#') {
                    pixelList.add(pixel(position, col, row));
                }
            }
        }

        return pixelList;
    }

}
