import javax.swing.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            String fileName = file.getName();
            int lineCount = 0;
            int wordCount = 0;
            int charCount = 0;
            int fileLength = 0;

            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    lineCount++;
                    String[] words = line.split("\\s+");
                    wordCount += words.length;
                    charCount += line.length();
                    fileLength += line.length() + 1; // +1 for line separator
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("File Name: " + fileName);
            System.out.println("Number of Lines: " + lineCount);
            System.out.println("Number of Words: " + wordCount);
            System.out.println("Number of Characters: " + charCount);
            System.out.println("File Length: " + fileLength);
        }
    }
}
