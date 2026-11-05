package Homework9.TextEditor;

public class TextEditorDriver {
    public static void main(String[] args) {
        try {
            StyleFactory factory = new StyleFactory();

            Style arial12Red = factory.getStyle("Arial", "12", "Red");
            Style calibri14Blue = factory.getStyle("Calibri", "14", "Blue");
            Style verdana16Black = factory.getStyle("Verdana", "16", "Black");
            Style arial14Black = factory.getStyle("Arial", "14", "Black");

            TextDocument document = new TextDocument("HelloWorldCS3560");

            document.addCharacter('H', arial12Red);
            document.addCharacter('e', arial14Black);
            document.addCharacter('l', calibri14Blue);
            document.addCharacter('l', calibri14Blue);
            document.addCharacter('o', verdana16Black);
            document.addCharacter('W', verdana16Black);
            document.addCharacter('o', verdana16Black);
            document.addCharacter('r', arial14Black);
            document.addCharacter('l', arial12Red);
            document.addCharacter('d', arial14Black);

            document.display();

            String fileName = "HelloWorldCS3560.dat";
            DocumentFileManager.save(document, fileName);

            System.out.println("\nDocument saved to " + fileName);

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
