package Homework9.TextEditor;

public class DocumentCharacter {
    private final char character;
    private final int position;
    private final Style style;

    public DocumentCharacter(char character, int position, Style style) {

        this.character = character;
        this.position = position;
        this.style = style;
    }

    public char getCharacter() {
        return character;
    }

    public int getPosition() {
        return position;
    }

    public Style getStyle() {
        return style;
    }

    public void display() {
        style.display(character, position);
    }
}
