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

    List<Pixel> pixels() {

        List<Pixel> pixelList = new ArrayList<>();

        for (int position = 0; position < text.length(); position++) {
            final char c = text.charAt(position);

            switch (c) {
                case ' ':
                    break;
                case 'A':
                    pixelList.addAll(symbolA(position));
                    break;
                case 'B':
                    pixelList.addAll(symbolB(position));
                    break;
                case 'C':
                    pixelList.addAll(symbolC(position));
                    break;
                case 'D':
                    pixelList.addAll(symbolD(position));
                    break;
                case 'E':
                    pixelList.addAll(symbolE(position));
                    break;
                case 'F':
                    pixelList.addAll(symbolF(position));
                    break;
                case 'G':
                    pixelList.addAll(symbolG(position));
                    break;
                case 'H':
                    pixelList.addAll(symbolH(position));
                    break;
                case 'I':
                    pixelList.addAll(symbolI(position));
                    break;
                case 'J':
                    pixelList.addAll(symbolJ(position));
                    break;
                case 'K':
                    pixelList.addAll(symbolK(position));
                    break;
                case 'L':
                    pixelList.addAll(symbolL(position));
                    break;
                case 'M':
                    pixelList.addAll(symbolM(position));
                    break;
                case 'N':
                    pixelList.addAll(symbolN(position));
                    break;
                case 'O':
                    pixelList.addAll(symbolO(position));
                    break;
                case 'P':
                    pixelList.addAll(symbolP(position));
                    break;
                case 'Q':
                    pixelList.addAll(symbolQ(position));
                    break;
                case 'R':
                    pixelList.addAll(symbolR(position));
                    break;
                case 'S':
                    pixelList.addAll(symbolS(position));
                    break;
                case 'T':
                    pixelList.addAll(symbolT(position));
                    break;
                case 'U':
                    pixelList.addAll(symbolU(position));
                    break;
                case 'V':
                    pixelList.addAll(symbolV(position));
                    break;
                case 'W':
                    pixelList.addAll(symbolW(position));
                    break;
                case 'X':
                    pixelList.addAll(symbolX(position));
                    break;
                case 'Y':
                    pixelList.addAll(symbolY(position));
                    break;
                case 'Z':
                    pixelList.addAll(symbolZ(position));
                    break;

                case '1':
                    pixelList.addAll(symbol1(position));
                    break;
                case '2':
                    pixelList.addAll(symbol2(position));
                    break;
                case '3':
                    pixelList.addAll(symbol3(position));
                    break;
                case '4':
                    pixelList.addAll(symbol4(position));
                    break;
                case '5':
                    pixelList.addAll(symbol5(position));
                    break;
                case '6':
                    pixelList.addAll(symbol6(position));
                    break;
                case '7':
                    pixelList.addAll(symbol7(position));
                    break;
                case '8':
                    pixelList.addAll(symbol8(position));
                    break;
                case '9':
                    pixelList.addAll(symbol9(position));
                    break;
                case '0':
                    pixelList.addAll(symbol0(position));
                    break;

                case '.':
                    pixelList.addAll(symbolDot(position));
                    break;
                case ',':
                    pixelList.addAll(symbolComma(position));
                    break;
                case '!':
                    pixelList.addAll(symbolExclamationMark(position));
                    break;
                case '?':
                    pixelList.addAll(symbolQuestionMark(position));
                    break;
                default:
                    //unknown symbol
                    pixelList.addAll(symbolUnknown(position));
                    break;
            }
        }

        return pixelList;
    }

    //todo: encode symbols by visual matrix

    private List<Pixel> symbol1(int position) {
        List<Pixel> pixelList = new ArrayList<>();
        //row 0
        pixelList.add(pixel(position, 2, 0));
        //row 1
        pixelList.add(pixel(position, 1, 1));
        pixelList.add(pixel(position, 2, 1));
        //row 2
        pixelList.add(pixel(position, 2, 2));
        //row 3
        pixelList.add(pixel(position, 2, 3));
        //row 4
        pixelList.add(pixel(position, 2, 4));
        return pixelList;
    }

    private List<Pixel> symbol2(int position) {
        List<Pixel> pixelList = new ArrayList<>();
        //row 0
        pixelList.add(pixel(position, 0, 0));
        pixelList.add(pixel(position, 1, 0));
        pixelList.add(pixel(position, 2, 0));
        pixelList.add(pixel(position, 3, 0));
        //row 1
        pixelList.add(pixel(position, 4, 1));
        //row 2
        pixelList.add(pixel(position, 1, 2));
        pixelList.add(pixel(position, 2, 2));
        pixelList.add(pixel(position, 3, 2));
        //row 3
        pixelList.add(pixel(position, 0, 3));
        //row 4
        pixelList.add(pixel(position, 0, 4));
        pixelList.add(pixel(position, 1, 4));
        pixelList.add(pixel(position, 2, 4));
        pixelList.add(pixel(position, 3, 4));
        pixelList.add(pixel(position, 4, 4));
        return pixelList;
    }

    private List<Pixel> symbol3(int position) {
        List<Pixel> pixelList = new ArrayList<>();
        //row 0
        pixelList.add(pixel(position, 1, 0));
        pixelList.add(pixel(position, 2, 0));
        pixelList.add(pixel(position, 3, 0));
        //row 1
        pixelList.add(pixel(position, 0, 1));
        pixelList.add(pixel(position, 4, 1));
        //row 2
        pixelList.add(pixel(position, 2, 2));
        pixelList.add(pixel(position, 3, 2));
        //row 3
        pixelList.add(pixel(position, 0, 3));
        pixelList.add(pixel(position, 4, 3));
        //row 4
        pixelList.add(pixel(position, 1, 4));
        pixelList.add(pixel(position, 2, 4));
        pixelList.add(pixel(position, 3, 4));
        return pixelList;
    }

    private List<Pixel> symbol4(int position) {
        List<Pixel> pixelList = new ArrayList<>();
        //row 0
        pixelList.add(pixel(position, 0, 0));
        pixelList.add(pixel(position, 4, 0));
        //row 1
        pixelList.add(pixel(position, 0, 1));
        pixelList.add(pixel(position, 4, 1));
        //row 2
        pixelList.add(pixel(position, 0, 2));
        pixelList.add(pixel(position, 1, 2));
        pixelList.add(pixel(position, 2, 2));
        pixelList.add(pixel(position, 3, 2));
        pixelList.add(pixel(position, 4, 2));
        //row 3
        pixelList.add(pixel(position, 4, 3));
        //row 4
        pixelList.add(pixel(position, 4, 4));
        return pixelList;
    }

    private List<Pixel> symbol5(int position) {
        List<Pixel> pixelList = new ArrayList<>();
        //row 0
        pixelList.add(pixel(position, 0, 0));
        pixelList.add(pixel(position, 1, 0));
        pixelList.add(pixel(position, 2, 0));
        pixelList.add(pixel(position, 3, 0));
        pixelList.add(pixel(position, 4, 0));
        //row 1
        pixelList.add(pixel(position, 0, 1));
        //row 2
        pixelList.add(pixel(position, 0, 2));
        pixelList.add(pixel(position, 1, 2));
        pixelList.add(pixel(position, 2, 2));
        pixelList.add(pixel(position, 3, 2));
        //row 3
        pixelList.add(pixel(position, 4, 3));
        //row 4
        pixelList.add(pixel(position, 0, 4));
        pixelList.add(pixel(position, 1, 4));
        pixelList.add(pixel(position, 2, 4));
        pixelList.add(pixel(position, 3, 4));
        return pixelList;
    }

    private List<Pixel> symbol6(int position) {
        List<Pixel> pixelList = new ArrayList<>();
        //row 0
        pixelList.add(pixel(position, 1, 0));
        pixelList.add(pixel(position, 2, 0));
        pixelList.add(pixel(position, 3, 0));
        pixelList.add(pixel(position, 4, 0));
        //row 1
        pixelList.add(pixel(position, 0, 1));
        //row 2
        pixelList.add(pixel(position, 0, 2));
        pixelList.add(pixel(position, 1, 2));
        pixelList.add(pixel(position, 2, 2));
        pixelList.add(pixel(position, 3, 2));
        //row 3
        pixelList.add(pixel(position, 0, 3));
        pixelList.add(pixel(position, 4, 3));
        //row 4
        pixelList.add(pixel(position, 1, 4));
        pixelList.add(pixel(position, 2, 4));
        pixelList.add(pixel(position, 3, 4));
        return pixelList;
    }

    private List<Pixel> symbol7(int position) {
        List<Pixel> pixelList = new ArrayList<>();
        //row 0
        pixelList.add(pixel(position, 0, 0));
        pixelList.add(pixel(position, 1, 0));
        pixelList.add(pixel(position, 2, 0));
        pixelList.add(pixel(position, 3, 0));
        pixelList.add(pixel(position, 4, 0));
        //row 1
        pixelList.add(pixel(position, 4, 1));
        //row 2
        pixelList.add(pixel(position, 3, 2));
        //row 3
        pixelList.add(pixel(position, 2, 3));
        //row 4
        pixelList.add(pixel(position, 2, 4));
        return pixelList;
    }

    private List<Pixel> symbol8(int position) {
        List<Pixel> pixelList = new ArrayList<>();
        //row 0
        pixelList.add(pixel(position, 1, 0));
        pixelList.add(pixel(position, 2, 0));
        pixelList.add(pixel(position, 3, 0));
        //row 1
        pixelList.add(pixel(position, 0, 1));
        pixelList.add(pixel(position, 4, 1));
        //row 2
        pixelList.add(pixel(position, 1, 2));
        pixelList.add(pixel(position, 2, 2));
        pixelList.add(pixel(position, 3, 2));
        //row 3
        pixelList.add(pixel(position, 0, 3));
        pixelList.add(pixel(position, 4, 3));
        //row 4
        pixelList.add(pixel(position, 1, 4));
        pixelList.add(pixel(position, 2, 4));
        pixelList.add(pixel(position, 3, 4));
        return pixelList;
    }

    private List<Pixel> symbol9(int position) {
        List<Pixel> pixelList = new ArrayList<>();
        //row 0
        pixelList.add(pixel(position, 1, 0));
        pixelList.add(pixel(position, 2, 0));
        pixelList.add(pixel(position, 3, 0));
        //row 1
        pixelList.add(pixel(position, 0, 1));
        pixelList.add(pixel(position, 4, 1));
        //row 2
        pixelList.add(pixel(position, 1, 2));
        pixelList.add(pixel(position, 2, 2));
        pixelList.add(pixel(position, 3, 2));
        pixelList.add(pixel(position, 4, 2));
        //row 3
        pixelList.add(pixel(position, 4, 3));
        //row 4
        pixelList.add(pixel(position, 0, 4));
        pixelList.add(pixel(position, 1, 4));
        pixelList.add(pixel(position, 2, 4));
        pixelList.add(pixel(position, 3, 4));
        return pixelList;
    }

    private List<Pixel> symbol0(int position) {
        return symbolO(position);
    }

    private List<Pixel> symbolA(int position) {
        List<Pixel> pixelList = new ArrayList<>();
        //row 0
        pixelList.add(pixel(position, 1, 0));
        pixelList.add(pixel(position, 2, 0));
        pixelList.add(pixel(position, 3, 0));
        //row 1
        pixelList.add(pixel(position, 0, 1));
        pixelList.add(pixel(position, 4, 1));
        //row 2
        pixelList.add(pixel(position, 0, 2));
        pixelList.add(pixel(position, 1, 2));
        pixelList.add(pixel(position, 2, 2));
        pixelList.add(pixel(position, 3, 2));
        pixelList.add(pixel(position, 4, 2));
        //row 3
        pixelList.add(pixel(position, 0, 3));
        pixelList.add(pixel(position, 4, 3));
        //row 4
        pixelList.add(pixel(position, 0, 4));
        pixelList.add(pixel(position, 4, 4));
        return pixelList;
    }

    private List<Pixel> symbolB(int position) {
        List<Pixel> pixelList = new ArrayList<>();
        //row 0
        pixelList.add(pixel(position, 0, 0));
        pixelList.add(pixel(position, 1, 0));
        pixelList.add(pixel(position, 2, 0));
        pixelList.add(pixel(position, 3, 0));
        //row 1
        pixelList.add(pixel(position, 0, 1));
        pixelList.add(pixel(position, 4, 1));
        //row 2
        pixelList.add(pixel(position, 0, 2));
        pixelList.add(pixel(position, 1, 2));
        pixelList.add(pixel(position, 2, 2));
        pixelList.add(pixel(position, 3, 2));
        //row 3
        pixelList.add(pixel(position, 0, 3));
        pixelList.add(pixel(position, 4, 3));
        //row 4
        pixelList.add(pixel(position, 0, 4));
        pixelList.add(pixel(position, 1, 4));
        pixelList.add(pixel(position, 2, 4));
        pixelList.add(pixel(position, 3, 4));
        return pixelList;
    }

    private List<Pixel> symbolC(int position) {
        List<Pixel> pixelList = new ArrayList<>();
        //row 0
        pixelList.add(pixel(position, 1, 0));
        pixelList.add(pixel(position, 2, 0));
        pixelList.add(pixel(position, 3, 0));
        //row 1
        pixelList.add(pixel(position, 0, 1));
        pixelList.add(pixel(position, 4, 1));
        //row 2
        pixelList.add(pixel(position, 0, 2));
        //row 3
        pixelList.add(pixel(position, 0, 3));
        pixelList.add(pixel(position, 4, 3));
        //row 4
        pixelList.add(pixel(position, 1, 4));
        pixelList.add(pixel(position, 2, 4));
        pixelList.add(pixel(position, 3, 4));
        return pixelList;
    }

    private List<Pixel> symbolD(int position) {
        List<Pixel> pixelList = new ArrayList<>();
        //row 0
        pixelList.add(pixel(position, 0, 0));
        pixelList.add(pixel(position, 1, 0));
        pixelList.add(pixel(position, 2, 0));
        pixelList.add(pixel(position, 3, 0));
        //row 1
        pixelList.add(pixel(position, 0, 1));
        pixelList.add(pixel(position, 4, 1));
        //row 2
        pixelList.add(pixel(position, 0, 2));
        pixelList.add(pixel(position, 4, 2));
        //row 3
        pixelList.add(pixel(position, 0, 3));
        pixelList.add(pixel(position, 4, 3));
        //row 4
        pixelList.add(pixel(position, 0, 4));
        pixelList.add(pixel(position, 1, 4));
        pixelList.add(pixel(position, 2, 4));
        pixelList.add(pixel(position, 3, 4));
        return pixelList;
    }

    private List<Pixel> symbolE(int position) {
        List<Pixel> pixelList = new ArrayList<>();
        //row 0
        pixelList.add(pixel(position, 0, 0));
        pixelList.add(pixel(position, 1, 0));
        pixelList.add(pixel(position, 2, 0));
        pixelList.add(pixel(position, 3, 0));
        pixelList.add(pixel(position, 4, 0));
        //row 1
        pixelList.add(pixel(position, 0, 1));
        //row 2
        pixelList.add(pixel(position, 0, 2));
        pixelList.add(pixel(position, 1, 2));
        pixelList.add(pixel(position, 2, 2));
        pixelList.add(pixel(position, 3, 2));
        //row 3
        pixelList.add(pixel(position, 0, 3));
        //row 4
        pixelList.add(pixel(position, 0, 4));
        pixelList.add(pixel(position, 1, 4));
        pixelList.add(pixel(position, 2, 4));
        pixelList.add(pixel(position, 3, 4));
        pixelList.add(pixel(position, 4, 4));
        return pixelList;
    }

    private List<Pixel> symbolF(int position) {
        List<Pixel> pixelList = new ArrayList<>();
        //row 0
        pixelList.add(pixel(position, 0, 0));
        pixelList.add(pixel(position, 1, 0));
        pixelList.add(pixel(position, 2, 0));
        pixelList.add(pixel(position, 3, 0));
        pixelList.add(pixel(position, 4, 0));
        //row 1
        pixelList.add(pixel(position, 0, 1));
        //row 2
        pixelList.add(pixel(position, 0, 2));
        pixelList.add(pixel(position, 1, 2));
        pixelList.add(pixel(position, 2, 2));
        pixelList.add(pixel(position, 3, 2));
        //row 3
        pixelList.add(pixel(position, 0, 3));
        //row 4
        pixelList.add(pixel(position, 0, 4));
        return pixelList;
    }

    private List<Pixel> symbolG(int position) {
        List<Pixel> pixelList = new ArrayList<>();
        //row 0
        pixelList.add(pixel(position, 1, 0));
        pixelList.add(pixel(position, 2, 0));
        pixelList.add(pixel(position, 3, 0));
        pixelList.add(pixel(position, 4, 0));
        //row 1
        pixelList.add(pixel(position, 0, 1));
        //row 2
        pixelList.add(pixel(position, 0, 2));
        pixelList.add(pixel(position, 2, 2));
        pixelList.add(pixel(position, 3, 2));
        pixelList.add(pixel(position, 4, 2));
        //row 3
        pixelList.add(pixel(position, 0, 3));
        pixelList.add(pixel(position, 4, 3));
        //row 4
        pixelList.add(pixel(position, 1, 4));
        pixelList.add(pixel(position, 2, 4));
        pixelList.add(pixel(position, 3, 4));
        return pixelList;
    }

    private List<Pixel> symbolH(int position) {
        List<Pixel> pixelList = new ArrayList<>();
        //row 0
        pixelList.add(pixel(position, 0, 0));
        pixelList.add(pixel(position, 4, 0));
        //row 1
        pixelList.add(pixel(position, 0, 1));
        pixelList.add(pixel(position, 4, 1));
        //row 2
        pixelList.add(pixel(position, 0, 2));
        pixelList.add(pixel(position, 1, 2));
        pixelList.add(pixel(position, 2, 2));
        pixelList.add(pixel(position, 3, 2));
        pixelList.add(pixel(position, 4, 2));
        //row 3
        pixelList.add(pixel(position, 0, 3));
        pixelList.add(pixel(position, 4, 3));
        //row 4
        pixelList.add(pixel(position, 0, 4));
        pixelList.add(pixel(position, 4, 4));
        return pixelList;
    }

    private List<Pixel> symbolI(int position) {
        List<Pixel> pixelList = new ArrayList<>();
        //row 0
        pixelList.add(pixel(position, 0, 0));
        pixelList.add(pixel(position, 1, 0));
        pixelList.add(pixel(position, 2, 0));
        pixelList.add(pixel(position, 3, 0));
        pixelList.add(pixel(position, 4, 0));
        //row 1
        pixelList.add(pixel(position, 2, 1));
        //row 2
        pixelList.add(pixel(position, 2, 2));
        //row 3
        pixelList.add(pixel(position, 2, 3));
        //row 4
        pixelList.add(pixel(position, 0, 4));
        pixelList.add(pixel(position, 1, 4));
        pixelList.add(pixel(position, 2, 4));
        pixelList.add(pixel(position, 3, 4));
        pixelList.add(pixel(position, 4, 4));
        return pixelList;
    }

    private List<Pixel> symbolJ(int position) {
        List<Pixel> pixelList = new ArrayList<>();
        //row 0
        pixelList.add(pixel(position, 3, 0));
        pixelList.add(pixel(position, 4, 0));
        //row 1
        pixelList.add(pixel(position, 4, 1));
        //row 2
        pixelList.add(pixel(position, 0, 2));
        pixelList.add(pixel(position, 4, 2));
        //row 3
        pixelList.add(pixel(position, 0, 3));
        pixelList.add(pixel(position, 4, 3));
        //row 4
        pixelList.add(pixel(position, 1, 4));
        pixelList.add(pixel(position, 2, 4));
        pixelList.add(pixel(position, 3, 4));
        return pixelList;
    }

    private List<Pixel> symbolK(int position) {
        List<Pixel> pixelList = new ArrayList<>();
        //row 0
        pixelList.add(pixel(position, 0, 0));
        pixelList.add(pixel(position, 4, 0));
        //row 1
        pixelList.add(pixel(position, 0, 1));
        pixelList.add(pixel(position, 3, 1));
        //row 2
        pixelList.add(pixel(position, 0, 2));
        pixelList.add(pixel(position, 1, 2));
        pixelList.add(pixel(position, 2, 2));
        //row 3
        pixelList.add(pixel(position, 0, 3));
        pixelList.add(pixel(position, 3, 3));
        //row 4
        pixelList.add(pixel(position, 0, 4));
        pixelList.add(pixel(position, 4, 4));
        return pixelList;
    }

    private List<Pixel> symbolL(int position) {
        List<Pixel> pixelList = new ArrayList<>();
        //row 0
        pixelList.add(pixel(position, 0, 0));
        //row 1
        pixelList.add(pixel(position, 0, 1));
        //row 2
        pixelList.add(pixel(position, 0, 2));
        //row 3
        pixelList.add(pixel(position, 0, 3));
        //row 4
        pixelList.add(pixel(position, 0, 4));
        pixelList.add(pixel(position, 1, 4));
        pixelList.add(pixel(position, 2, 4));
        pixelList.add(pixel(position, 3, 4));
        pixelList.add(pixel(position, 4, 4));
        return pixelList;
    }

    private List<Pixel> symbolM(int position) {
        List<Pixel> pixelList = new ArrayList<>();
        //row 0
        pixelList.add(pixel(position, 0, 0));
        pixelList.add(pixel(position, 4, 0));
        //row 1
        pixelList.add(pixel(position, 0, 1));
        pixelList.add(pixel(position, 1, 1));
        pixelList.add(pixel(position, 3, 1));
        pixelList.add(pixel(position, 4, 1));
        //row 2
        pixelList.add(pixel(position, 0, 2));
        pixelList.add(pixel(position, 2, 2));
        pixelList.add(pixel(position, 4, 2));
        //row 3
        pixelList.add(pixel(position, 0, 3));
        pixelList.add(pixel(position, 4, 3));
        //row 4
        pixelList.add(pixel(position, 0, 4));
        pixelList.add(pixel(position, 4, 4));
        return pixelList;
    }

    private List<Pixel> symbolN(int position) {
        List<Pixel> pixelList = new ArrayList<>();
        //row 0
        pixelList.add(pixel(position, 0, 0));
        pixelList.add(pixel(position, 4, 0));
        //row 1
        pixelList.add(pixel(position, 0, 1));
        pixelList.add(pixel(position, 1, 1));
        pixelList.add(pixel(position, 4, 1));
        //row 2
        pixelList.add(pixel(position, 0, 2));
        pixelList.add(pixel(position, 2, 2));
        pixelList.add(pixel(position, 4, 2));
        //row 3
        pixelList.add(pixel(position, 0, 3));
        pixelList.add(pixel(position, 3, 3));
        pixelList.add(pixel(position, 4, 3));
        //row 4
        pixelList.add(pixel(position, 0, 4));
        pixelList.add(pixel(position, 4, 4));
        return pixelList;
    }

    private List<Pixel> symbolO(int position) {
        List<Pixel> pixelList = new ArrayList<>();
        //row 0
        pixelList.add(pixel(position, 1, 0));
        pixelList.add(pixel(position, 2, 0));
        pixelList.add(pixel(position, 3, 0));
        //row 1
        pixelList.add(pixel(position, 0, 1));
        pixelList.add(pixel(position, 4, 1));
        //row 2
        pixelList.add(pixel(position, 0, 2));
        pixelList.add(pixel(position, 4, 2));
        //row 3
        pixelList.add(pixel(position, 0, 3));
        pixelList.add(pixel(position, 4, 3));
        //row 4
        pixelList.add(pixel(position, 1, 4));
        pixelList.add(pixel(position, 2, 4));
        pixelList.add(pixel(position, 3, 4));
        return pixelList;
    }

    private List<Pixel> symbolP(int position) {
        List<Pixel> pixelList = new ArrayList<>();
        //row 0
        pixelList.add(pixel(position, 0, 0));
        pixelList.add(pixel(position, 1, 0));
        pixelList.add(pixel(position, 2, 0));
        pixelList.add(pixel(position, 3, 0));
        //row 1
        pixelList.add(pixel(position, 0, 1));
        pixelList.add(pixel(position, 4, 1));
        //row 2
        pixelList.add(pixel(position, 0, 2));
        pixelList.add(pixel(position, 1, 2));
        pixelList.add(pixel(position, 2, 2));
        pixelList.add(pixel(position, 3, 2));
        //row 3
        pixelList.add(pixel(position, 0, 3));
        //row 4
        pixelList.add(pixel(position, 0, 4));
        return pixelList;
    }

    private List<Pixel> symbolQ(int position) {
        List<Pixel> pixelList = new ArrayList<>();
        //row 0
        pixelList.add(pixel(position, 1, 0));
        pixelList.add(pixel(position, 2, 0));
        pixelList.add(pixel(position, 3, 0));
        //row 1
        pixelList.add(pixel(position, 0, 1));
        pixelList.add(pixel(position, 4, 1));
        //row 2
        pixelList.add(pixel(position, 0, 2));
        pixelList.add(pixel(position, 4, 2));
        //row 3
        pixelList.add(pixel(position, 0, 3));
        pixelList.add(pixel(position, 3, 3));
        //row 4
        pixelList.add(pixel(position, 1, 4));
        pixelList.add(pixel(position, 2, 4));
        pixelList.add(pixel(position, 4, 4));
        return pixelList;
    }

    private List<Pixel> symbolR(int position) {
        List<Pixel> pixelList = new ArrayList<>();
        //row 0
        pixelList.add(pixel(position, 0, 0));
        pixelList.add(pixel(position, 1, 0));
        pixelList.add(pixel(position, 2, 0));
        pixelList.add(pixel(position, 3, 0));
        //row 1
        pixelList.add(pixel(position, 0, 1));
        pixelList.add(pixel(position, 4, 1));
        //row 2
        pixelList.add(pixel(position, 0, 2));
        pixelList.add(pixel(position, 1, 2));
        pixelList.add(pixel(position, 2, 2));
        pixelList.add(pixel(position, 3, 2));
        //row 3
        pixelList.add(pixel(position, 0, 3));
        pixelList.add(pixel(position, 4, 3));
        //row 4
        pixelList.add(pixel(position, 0, 4));
        pixelList.add(pixel(position, 4, 4));
        return pixelList;
    }

    private List<Pixel> symbolS(int position) {
        List<Pixel> pixelList = new ArrayList<>();
        //row 0
        pixelList.add(pixel(position, 1, 0));
        pixelList.add(pixel(position, 2, 0));
        pixelList.add(pixel(position, 3, 0));
        pixelList.add(pixel(position, 4, 0));
        //row 1
        pixelList.add(pixel(position, 0, 1));
        //row 2
        pixelList.add(pixel(position, 1, 2));
        pixelList.add(pixel(position, 2, 2));
        pixelList.add(pixel(position, 3, 2));
        //row 3
        pixelList.add(pixel(position, 4, 3));
        //row 4
        pixelList.add(pixel(position, 0, 4));
        pixelList.add(pixel(position, 1, 4));
        pixelList.add(pixel(position, 2, 4));
        pixelList.add(pixel(position, 3, 4));
        return pixelList;
    }

    private List<Pixel> symbolT(int position) {
        List<Pixel> pixelList = new ArrayList<>();
        //row 0
        pixelList.add(pixel(position, 0, 0));
        pixelList.add(pixel(position, 1, 0));
        pixelList.add(pixel(position, 2, 0));
        pixelList.add(pixel(position, 3, 0));
        pixelList.add(pixel(position, 4, 0));
        //row 1
        pixelList.add(pixel(position, 2, 1));
        //row 2
        pixelList.add(pixel(position, 2, 2));
        //row 3
        pixelList.add(pixel(position, 2, 3));
        //row 4
        pixelList.add(pixel(position, 2, 4));
        return pixelList;
    }

    private List<Pixel> symbolU(int position) {
        List<Pixel> pixelList = new ArrayList<>();
        //row 0
        pixelList.add(pixel(position, 0, 0));
        pixelList.add(pixel(position, 4, 0));
        //row 1
        pixelList.add(pixel(position, 0, 1));
        pixelList.add(pixel(position, 4, 1));
        //row 2
        pixelList.add(pixel(position, 0, 2));
        pixelList.add(pixel(position, 4, 2));
        //row 3
        pixelList.add(pixel(position, 0, 3));
        pixelList.add(pixel(position, 4, 3));
        //row 4
        pixelList.add(pixel(position, 1, 4));
        pixelList.add(pixel(position, 2, 4));
        pixelList.add(pixel(position, 3, 4));
        return pixelList;
    }

    private List<Pixel> symbolV(int position) {
        List<Pixel> pixelList = new ArrayList<>();
        //row 0
        pixelList.add(pixel(position, 0, 0));
        pixelList.add(pixel(position, 4, 0));
        //row 1
        pixelList.add(pixel(position, 0, 1));
        pixelList.add(pixel(position, 4, 1));
        //row 2
        pixelList.add(pixel(position, 0, 2));
        pixelList.add(pixel(position, 4, 2));
        //row 3
        pixelList.add(pixel(position, 1, 3));
        pixelList.add(pixel(position, 3, 3));
        //row 4
        pixelList.add(pixel(position, 2, 4));
        return pixelList;
    }

    private List<Pixel> symbolW(int position) {
        List<Pixel> pixelList = new ArrayList<>();
        //row 0
        pixelList.add(pixel(position, 0, 0));
        pixelList.add(pixel(position, 4, 0));
        //row 1
        pixelList.add(pixel(position, 0, 1));
        pixelList.add(pixel(position, 4, 1));
        //row 2
        pixelList.add(pixel(position, 0, 2));
        pixelList.add(pixel(position, 2, 2));
        pixelList.add(pixel(position, 4, 2));
        //row 3
        pixelList.add(pixel(position, 0, 3));
        pixelList.add(pixel(position, 1, 3));
        pixelList.add(pixel(position, 3, 3));
        pixelList.add(pixel(position, 4, 3));
        //row 4
        pixelList.add(pixel(position, 0, 4));
        pixelList.add(pixel(position, 4, 4));
        return pixelList;
    }

    private List<Pixel> symbolX(int position) {
        List<Pixel> pixelList = new ArrayList<>();
        //row 0
        pixelList.add(pixel(position, 0, 0));
        pixelList.add(pixel(position, 4, 0));
        //row 1
        pixelList.add(pixel(position, 1, 1));
        pixelList.add(pixel(position, 3, 1));
        //row 2
        pixelList.add(pixel(position, 2, 2));
        //row 3
        pixelList.add(pixel(position, 1, 3));
        pixelList.add(pixel(position, 3, 3));
        //row 4
        pixelList.add(pixel(position, 0, 4));
        pixelList.add(pixel(position, 4, 4));
        return pixelList;
    }

    private List<Pixel> symbolY(int position) {
        List<Pixel> pixelList = new ArrayList<>();
        //row 0
        pixelList.add(pixel(position, 0, 0));
        pixelList.add(pixel(position, 4, 0));
        //row 1
        pixelList.add(pixel(position, 1, 1));
        pixelList.add(pixel(position, 3, 1));
        //row 2
        pixelList.add(pixel(position, 2, 2));
        //row 3
        pixelList.add(pixel(position, 2, 3));
        //row 4
        pixelList.add(pixel(position, 2, 4));
        return pixelList;
    }

    private List<Pixel> symbolZ(int position) {
        List<Pixel> pixelList = new ArrayList<>();
        //row 0
        pixelList.add(pixel(position, 0, 0));
        pixelList.add(pixel(position, 1, 0));
        pixelList.add(pixel(position, 2, 0));
        pixelList.add(pixel(position, 3, 0));
        pixelList.add(pixel(position, 4, 0));
        //row 1
        pixelList.add(pixel(position, 3, 1));
        //row 2
        pixelList.add(pixel(position, 2, 2));
        //row 3
        pixelList.add(pixel(position, 1, 3));
        //row 4
        pixelList.add(pixel(position, 0, 4));
        pixelList.add(pixel(position, 1, 4));
        pixelList.add(pixel(position, 2, 4));
        pixelList.add(pixel(position, 3, 4));
        pixelList.add(pixel(position, 4, 4));
        return pixelList;
    }

    private List<Pixel> symbolDot(int position) {
        List<Pixel> pixelList = new ArrayList<>();
        //row 0
        //row 1
        //row 2
        //row 3
        pixelList.add(pixel(position, 2, 3));
        pixelList.add(pixel(position, 3, 3));
        //row 4
        pixelList.add(pixel(position, 2, 4));
        pixelList.add(pixel(position, 3, 4));
        return pixelList;
    }

    private List<Pixel> symbolComma(int position) {
        List<Pixel> pixelList = new ArrayList<>();
        //row 3
        pixelList.add(pixel(position, 2, 3));
        pixelList.add(pixel(position, 3, 3));
        //row 4
        pixelList.add(pixel(position, 3, 4));
        return pixelList;
    }

    private List<Pixel> symbolExclamationMark(int position) {
        List<Pixel> pixelList = new ArrayList<>();
        //row 0
        pixelList.add(pixel(position, 2, 0));
        //row 1
        pixelList.add(pixel(position, 2, 1));
        //row 2
        pixelList.add(pixel(position, 2, 2));
        //row 3
        //row 4
        pixelList.add(pixel(position, 2, 4));
        return pixelList;
    }

    private List<Pixel> symbolQuestionMark(int position) {
        List<Pixel> pixelList = new ArrayList<>();
        //row 0
        pixelList.add(pixel(position, 1, 0));
        pixelList.add(pixel(position, 2, 0));
        pixelList.add(pixel(position, 3, 0));
        //row 1
        pixelList.add(pixel(position, 0, 1));
        pixelList.add(pixel(position, 4, 1));
        //row 2
        pixelList.add(pixel(position, 2, 2));
        pixelList.add(pixel(position, 3, 2));
        //row 3
        //row 4
        pixelList.add(pixel(position, 2, 4));
        return pixelList;
    }

    private List<Pixel> symbolUnknown(int position) {
        List<Pixel> pixelList = new ArrayList<>();
        //row 0
        pixelList.add(pixel(position, 0, 0));
        pixelList.add(pixel(position, 1, 0));
        pixelList.add(pixel(position, 2, 0));
        pixelList.add(pixel(position, 3, 0));
        pixelList.add(pixel(position, 4, 0));
        //row 1
        pixelList.add(pixel(position, 0, 1));
        pixelList.add(pixel(position, 1, 1));
        pixelList.add(pixel(position, 2, 1));
        pixelList.add(pixel(position, 3, 1));
        pixelList.add(pixel(position, 4, 1));
        //row 2
        pixelList.add(pixel(position, 0, 2));
        pixelList.add(pixel(position, 1, 2));
        pixelList.add(pixel(position, 2, 2));
        pixelList.add(pixel(position, 3, 2));
        pixelList.add(pixel(position, 4, 2));
        //row 3
        pixelList.add(pixel(position, 0, 3));
        pixelList.add(pixel(position, 1, 3));
        pixelList.add(pixel(position, 2, 3));
        pixelList.add(pixel(position, 3, 3));
        pixelList.add(pixel(position, 4, 3));
        //row 4
        pixelList.add(pixel(position, 0, 4));
        pixelList.add(pixel(position, 1, 4));
        pixelList.add(pixel(position, 2, 4));
        pixelList.add(pixel(position, 3, 4));
        pixelList.add(pixel(position, 4, 4));
        return pixelList;
    }

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
}
