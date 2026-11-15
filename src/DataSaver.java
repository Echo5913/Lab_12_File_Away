
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;

public class DataSaver {

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        ArrayList<String> records = new ArrayList<>();

        int idNumber = 1;
        boolean addAnother = true;

        while (addAnother) {

            System.out.println("Enter Student Information");

            String firstName = SafeInput.getRegExString(
                    console, "First Name: ", ".+");

            String lastName = SafeInput.getRegExString(
                    console, "Last Name: ", ".+");

            int yearOfBirth = SafeInput.getRangedInt(
                    console, "Year of Birth: ", 1000, 9999);

            String email = SafeInput.getRegExString(
                    console, "Email: ",
                    "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}");

            String formattedID = String.format("%06d", idNumber);

            String record = firstName + ", " + lastName + ", "
                    + formattedID + ", " + email + ", " + yearOfBirth;

            records.add(record);

            idNumber++;

            addAnother = SafeInput.getYNConfirm(
                    console, "Would you like to enter another record? ");
        }

        String fileName = SafeInput.getRegExString(
                console, "Enter the CSV file name (without extension): ",
                "[A-Za-z0-9_-]+");

        fileName += ".csv";

        File outputFile = new File("src", fileName);

        try {
            BufferedWriter writer = Files.newBufferedWriter(
                    outputFile.toPath());

            for (String record : records) {
                writer.write(record);
                writer.newLine();
            }

            writer.close();

            System.out.println("Records saved successfully!");
            System.out.println("File: " + outputFile.getPath());

        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }

        console.close();
    }
}
