
import javax.swing.JFileChooser;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileInspector {
    public static void main(String[] args) {

        JFileChooser chooser = new JFileChooser();

        chooser.setCurrentDirectory(new File("src"));

        int result = chooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {

            File selectedFile = chooser.getSelectedFile();

            int lines = 0;
            int words = 0;
            int characters = 0;

            try {
                Path filePath = selectedFile.toPath();

                BufferedReader reader = Files.newBufferedReader(filePath);

                String line;

                while ((line = reader.readLine()) != null) {

                    System.out.println(line);

                    lines++;

                    String trimmedLine = line.trim();

                    if (!trimmedLine.isEmpty()) {
                        words += trimmedLine.split("\\s+").length;
                    }

                    characters += line.length();
                }

                reader.close();

                System.out.println();
                System.out.println("File Summary Report");
                System.out.println("-------------------");
                System.out.println("File Name: " + selectedFile.getName());
                System.out.println("Number of Lines: " + lines);
                System.out.println("Number of Words: " + words);
                System.out.println("Number of Characters: " + characters);

            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
            }

        } else {
            System.out.println("No file was selected.");
        }
    }
}
