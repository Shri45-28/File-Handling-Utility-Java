import java.io.*; 
import java.util.Scanner;

public class UserFileOperations {

    
    public static void writeFile(String filename, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(content);
            System.out.println(" File written successfully.");
        } catch (IOException e) {
            System.out.println(" Error writing to file: " + e.getMessage());
        }
    } 

    
    public static void readFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            System.out.println("\n📖 File Content:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(" Error reading file: " + e.getMessage());
        }
    }

    
    public static void modifyFile(String filename, String oldWord, String newWord) {
        StringBuilder modifiedContent = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                modifiedContent.append(line.replace(oldWord, newWord)).append("\n");
            }
        } catch (IOException e) {
            System.out.println(" Error reading file for modification: " + e.getMessage());
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(modifiedContent.toString());
            System.out.println(" File modified successfully.");
        } catch (IOException e) {
            System.out.println(" Error writing modified content: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       
        System.out.print("Enter file name (with .txt): ");
        String filename = scanner.nextLine();

        
        System.out.println("Enter text to write into the file:");
        String content = scanner.nextLine();

        
        writeFile(filename, content);

       
        readFile(filename);

        
        System.out.print("\nEnter the word to replace: ");
        String oldWord = scanner.nextLine();

        System.out.print("Enter the new word: ");
        String newWord = scanner.nextLine();

        
        modifyFile(filename, oldWord, newWord);

        
        readFile(filename);

        scanner.close();
    }

}
