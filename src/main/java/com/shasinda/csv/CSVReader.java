package com.shasinda.csv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Shasinda on 11/08/2015.
 */
public class CSVReader {

    private BufferedReader bufferedReader;

    private static final String DELIMITER = ",";


    /**
     * Readers the given CSV file
     *
     * @param csvFile path to the CSV file
     */
    public void readFile(String csvFile) {
        String row = "";
        try {
            bufferedReader = new BufferedReader(new FileReader(csvFile));
            while ((row = bufferedReader.readLine()) != null) {
                String[] rowData = row.split(DELIMITER);
                printOutput(rowData);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Prints the output data
     *
     * @param data
     * @throws Exception
     */
    private void printOutput(String[] data) throws Exception {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(data[0]);
        stringBuffer.append(" ");
        stringBuffer.append(data[1]);
        stringBuffer.append(" ");
        stringBuffer.append(data[2]);
        stringBuffer.append(" ");
        appendLocationAndTime(data, stringBuffer);
        System.out.println(stringBuffer.toString());
    }

    /**
     * Appends location data and time to the StringBuffer
     * @param data row data
     * @param stringBuf StringBuffer
     * @throws Exception
     */
    public void appendLocationAndTime(String[] data, StringBuffer stringBuf) throws Exception {
        double lat = Double.parseDouble(data[1]);
        double lng = Double.parseDouble(data[2]);
        TimeZone tz = LocationUtils.findTimeZone(lat, lng);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        format.setTimeZone(tz.getDefault());
        Date utcDate = format.parse(data[0]);
        stringBuf.append(tz.getID());
        stringBuf.append(" ");
        String localDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(utcDate);
        stringBuf.append(localDate);
    }
}
