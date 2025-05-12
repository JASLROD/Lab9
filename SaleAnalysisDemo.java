
import java.util.Scanner;
import java.io.*;

/**
* 
* lab 9 The SaleAnalysisDemo class serves as the driver for the SalesAnalysis application.
* It prompts the user to enter the name of a sales data file, verifies the file exists,
* and then uses the SalesAnalysis class to process the data and display the sales summary.
* This class tests the functionality of SalesAnalysis by interacting with the user
* and demonstrating file input and analysis.
* 
* @author Jasmin Leonrodriguez jleonrodriquez@student.sdccd.edu
* @version v1.1
* @since 5/11/2025
*/
public class SaleAnalysisDemo
{

    /**
     * The main method starts the sales analysis program.
     * It prompts the user for an input file name, checks that the file exists,
     * and then creates a SalesAnalysis object to process and report the data.
     * 
     * @param args command-line arguments (not used)
     * @throws IOException if an error occurs while reading the input file
     */
    public static void main(String[] args) throws IOException{
        String file;

        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the file name: ");
        file = keyboard.nextLine();

        File fileTest = new File(file);
        while(!(fileTest.exists())){
            System.out.print("File does not exist. Enter a file name: ");
            file = keyboard.nextLine();
        }//ends while
        SalesAnalysis object = new SalesAnalysis(file);
        object.processFile();
        object.writeOutput();
    }
}

