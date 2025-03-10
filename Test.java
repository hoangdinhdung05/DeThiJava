import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws IOException {
        
        Scanner sc = new Scanner(System.in);

        //Tao file input va output
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        File file = new File(inputFile);
        //check loi 
        if(!file.exists() || file.length() == 0) {
            try {
                FileWriter writer = new FileWriter(file);
                writer.write("Hello World!");
                writer.flush();
                System.out.println("File create successfully!");
                writer.close();
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        //Doc file input chuyen qua output
        try (FileInputStream input = new FileInputStream(inputFile);
            FileOutputStream output = new FileOutputStream(outputFile)) {

            int c;
            while ((c = input.read()) != -1) {
                output.write(c);
            }
            output.flush(); //dam bao du lieu duoc ghi vao file

            System.out.println("File copied successfully!");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        //Hien thi noi dung file output
        System.out.println("Content of " + outputFile + ":");
        try {
            String line;
            while((line = sc.nextLine()) != null) {
                System.out.println(line);
            }

        } catch (InputMismatchException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();


    }

}