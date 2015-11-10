package com.shasinda.csv;

/**
 * Created by Shasinda on 11/08/2015.
 */
public class CSVReaderDriver {

    public static void main(String[] args){
        String csvFile = "C:/Files/data.csv";
        CSVReader reader = new CSVReader();
        reader.readFile(csvFile);
    }
}
