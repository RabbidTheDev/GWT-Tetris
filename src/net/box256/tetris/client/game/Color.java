package net.box256.tetris.client.game;


public enum Color {

    GREY("#A9A9A9"), CYAN("#00FFFF"), BLUE("#0000FF"), ORANGE("#FFA500"), YELLOW("#FFFF00"), LIME("#00FF00"), PURPLE("#800080"), RED("#FF0000");

    public final String code;

    Color(String code) {
        this.code = code;
    }
}
