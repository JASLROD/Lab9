import java.util.Scanner;
import java.io.*;

/**
 * Lab9
 * The SalesAnalysis class reads weekly sales data from a file,
 * processes it to calculate weekly totals, and outputs a summary
 * including total sales, average weekly sales, and the weeks with 
 * highest and lowest sales. 
 * Input file should contain one week's worth of daily sales per line,
 * with values separated by commas.
 * 
 * @author Jasmin Leonrodriguez jleonrodriquez@student.sdccd.edu
 * @version v1.1
 * @since 5/11/2025
 */
public class SalesAnalysis
{
    // instance variables 
    private double [] weeklyNumber; //double [] weeklyNumber
    private String inputFile; //String inputFile
    private int lineNumber = 0;
    public final int DAYS_OF_THE_WEEK = 7;

    /**
     * Constructs a SalesAnalysis object using the specified input file.
     * 
     * @param inFile the name of the input file containing sales data
     */
    public SalesAnalysis(String inFile)
    {
        inputFile = inFile;
        weeklyNumber = new double[4];
    }

    /**
     * Reads sales data from the input file and processes each line.
     * Each line represents one week's sales figures, separated by commas.
     * Passes parsed data to setArrayElement for weekly total calculation.
     * 
     * @throws IOException if there is an error reading the file
     */
    public void processFile()throws IOException
    {
        String line;
        File file = new File(inputFile);
        Scanner inputFile = new Scanner(file);
        while(inputFile.hasNextLine()){
            line = inputFile.nextLine();
            String[] tokens = line.split(",");
            setArrayElement(tokens);
        }//ends while
        inputFile.close();
    }

    /**
     * Calculates the total sales for a week based on the input array of daily sales.
     * Stores the total in the weeklyNumber array at the appropriate index.
     * 
     * @param inArray an array of strings representing daily sales values for a week
     */
    public void setArrayElement(String[] inArray)
    {
        double total = 0;
        for(String s :inArray){
            total +=Double.parseDouble(s);
        }// ends for
        weeklyNumber[lineNumber] = total;
        lineNumber++;
    }

    /**
     * Displays a summary of weekly sales statistics including:
     * total weekly sales, average daily sales per week,
     * total sales for all weeks, average weekly sales,
     * and weeks with the highest and lowest sales.
     */
    public void writeOutput()
    {
        double totalSales = 0;
        double min = weeklyNumber[0];
        double max = weeklyNumber[0];
        int minWeek = 0, maxWeek = 0;
        for(int i=0; i<weeklyNumber.length; i++){
            totalSales += weeklyNumber[i];
            if(weeklyNumber[i]<min){
                min = weeklyNumber[i];
                minWeek = i;
            }
            if(weeklyNumber[i]>max){
                max = weeklyNumber[i];
                maxWeek = i;
            }
            System.out.print("\nWeek "+(i+1) + " Info");
            System.out.printf("\nTotal Sales: $%,.2f", weeklyNumber[i]);
            System.out.printf("\nAvg Daily Sales for Week: $%,.2f\n", weeklyNumber[i]/DAYS_OF_THE_WEEK);
        }//ends for
        System.out.printf("\nTotal Sales for all Weeks: $%,.2f\n", totalSales);
        System.out.printf("Avg Weekly Sales: $%,.2f\n", totalSales/weeklyNumber.length);
        System.out.printf("Week %d had the highest amount of sales\n", maxWeek +1);
        System.out.printf("Week %d had the lowest amount of sales\n", minWeek +1);

    }
}//end

