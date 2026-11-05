package Homework9.TextEditor;

import java.util.ArrayList;
import java.util.List;

public class TextDocument {
    private final String name;
    private final List<DocumentCharacter> characters;

    public TextDocument(String name) {
        this.name = name;
        this.characters = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addCharacter(char character, Style style) {

        int position = characters.size();

        characters.add(new DocumentCharacter(character, position, style));
    }

    public List<DocumentCharacter> getCharacters() {
        return characters;
    }

    public void display() {
        System.out.println("\nDocument: " + name);

        for (DocumentCharacter character : characters) {
            character.display();
        }
    }

    public String getText() {
        StringBuilder result = new StringBuilder();

        for (DocumentCharacter character : characters) {
            result.append(character.getCharacter());
        }

        return result.toString();
    }
}
