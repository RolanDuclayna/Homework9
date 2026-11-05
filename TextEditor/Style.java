package Homework9.TextEditor;

public class Style {

    private String font;
    private String size;
    private String color;

    public Style(String font, String size, String color) {

        this.font = font;
        this.size = size;
        this.color = color;

    }

    public String getFont() {
        return font;
    }

    public String getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    public void display(char character, int position) {
        System.out.println("Character: " + character + ", Position: " + position + ", Font: " + font + ", Size: " + size
                + ", Color: " + color);
    }

}
