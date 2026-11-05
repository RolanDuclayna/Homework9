package Homework9.TextEditor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DocumentFileManager {

    public static void save(TextDocument document, String fileName)
            throws IOException {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {

            writer.write(document.getName());
            writer.newLine();

            writer.write(String.valueOf(document.getCharacters().size()));
            writer.newLine();

            for (DocumentCharacter character : document.getCharacters()) {
                Style style = character.getStyle();

                writer.write(
                        character.getCharacter() + "\t" +
                                style.getFont() + "\t" +
                                style.getSize() + "\t" +
                                style.getColor());

                writer.newLine();
            }
        }
    }

    public static TextDocument load(
            String fileName,
            StyleFactory factory) throws IOException {

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            String documentName = reader.readLine();
            int numberOfCharacters = Integer.parseInt(reader.readLine());

            TextDocument document = new TextDocument(documentName);

            for (int i = 0; i < numberOfCharacters; i++) {
                String[] data = reader.readLine().split("\t");

                char character = data[0].charAt(0);
                String font = data[1];
                String size = data[2];
                String color = data[3];

                Style style = factory.getStyle(font, size, color);

                document.addCharacter(character, style);
            }

            return document;
        }
    }
}
