package edu.isu.cs2235;

import edu.isu.cs2235.algorithms.impl.BinarySearch;
import edu.isu.cs2235.algorithms.impl.LinearSearch;
import edu.isu.cs2235.algorithms.impl.RecursiveBinarySearch;
import edu.isu.cs2235.algorithms.impl.RecursiveLinearSearch;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * @author Katherine Wilsdon
 */
public class Driver {
    enum Algorithm{
        N(0), IterLin(1) , RecLin(2) , IterBin(3) , RecBin(4);
        private int value;
        private Algorithm(int value) {
            this.value = value;
        }
        private int getValue(){
            return value;
        }
    }

    public static void main(String[] args)
    {
        try {
            // Create csv file
            File file = new File("data.csv");
            file.createNewFile();
            FileWriter csvWriter = new FileWriter(file);
            csvWriter.write("N, IterLin , RecLin , IterBin , RecBin\r\n");
            System.out.print("N, IterLin , RecLin , IterBin , RecBin\r\n");

            Integer[] array;
            long[][] averageTime = new long[10][5];
            int numOfIterations = 2000;
            int increment = 1000;
            Integer item;
            long start = 0;
            long stop = 0;
            long difference = 0;
            int value;

            Random rand = new Random();
            for (int i = 0; i < numOfIterations; ++i){
                for (int j = 0; j < 10; ++j){
                    // Create and populate the array
                    array = new Integer[numOfIterations + (j * increment)];
                    for (int k = 0; k < array.length; ++k)
                    {
                        array[k] = rand.nextInt(10000);
                    }
                    item = array[rand.nextInt(array.length)];
                    // Run each array search algorithm
                    for (Algorithm algrthm : Algorithm.values()){
                        switch (algrthm){
                            case N:
                                averageTime[j][0] = numOfIterations + (j * increment);
                                break;
                            case IterLin:
                                LinearSearch iterLin = new LinearSearch();
                                start = System.nanoTime();
                                value = iterLin.search(array, item);
                                stop = System.nanoTime();
                                difference = stop - start;
                                averageTime[j][Algorithm.IterLin.getValue()] += difference;
                                break;
                            case RecLin:
                                RecursiveLinearSearch recLin = new RecursiveLinearSearch();
                                start = System.nanoTime();
                                value = recLin.search(array, item);
                                stop = System.nanoTime();
                                difference = stop - start;
                                averageTime[j][Algorithm.RecLin.getValue()] += difference;
                                break;
                            case IterBin:
                                BinarySearch iterBin = new BinarySearch();
                                start = System.nanoTime();
                                value = iterBin.search(array, item);
                                stop = System.nanoTime();
                                difference = stop - start;
                                averageTime[j][Algorithm.IterBin.getValue()] += difference;
                                break;
                            case RecBin:
                                RecursiveBinarySearch recBin = new RecursiveBinarySearch();
                                start = System.nanoTime();
                                value = recBin.search(array, item);
                                stop = System.nanoTime();
                                difference = stop - start;
                                averageTime[j][Algorithm.RecBin.getValue()] += difference;
                                break;
                        }
                    }
                }
            }
            for (int i = 0; i < averageTime.length; ++i){
                for (int j = 0; j < averageTime[0].length; ++j) {
                    // Get average
                    if (j != 0)
                        averageTime[i][j] = averageTime[i][j] / numOfIterations;
                    // Write to csv and print to screen
                    csvWriter.write(Long.toString(averageTime[i][j]));
                    System.out.println(averageTime[i][j]);
                    // Separate by a comma
                    if (j != Algorithm.RecBin.getValue()) {
                        csvWriter.write(",");
                        System.out.print(",");
                    } // If last item, insert a new line
                    else if (j == Algorithm.RecBin.getValue()) {
                        csvWriter.write("\r\n");
                        System.out.print("\r\n");
                    }
                }
            }
            System.out.println(file.getAbsolutePath());
            csvWriter.flush();
            csvWriter.close();
        } catch (IOException e){
            System.err.println("An IOException was caught : " + e.getMessage());
        }
    }
}
