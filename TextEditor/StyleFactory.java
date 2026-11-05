package Homework9.TextEditor;

import java.util.HashMap;
import java.util.Map;

public class StyleFactory {
    private final Map<String, Style> styles = new HashMap<>();

    public Style getStyle(String font, String size, String color) {

        String key = font + size + color;

        if (!styles.containsKey(key)) {
            styles.put(
                    key,
                    new Style(font, size, color));

            System.out.println("Created new style: " + key);
        }

        return styles.get(key);
    }

    public int getNumberOfStyles() {
        return styles.size();
    }
}
