/*
 * Copyright (C) 2016 elidioxg
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package geoestatistica.FileUtils;

import geoestatistica.model.Separator;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author elidioxg
 */
public class DatasetProperties {

    //TODO: um único procedimento para pegar todas as propriedades
    /**
     * Get the number of columns on the dataset
     * @param filename
     * @param separator
     * @return Number of columns in dataset file
     */
    public static int getColumnsCount(String filename, String separator) {
        BufferedReader br = null;
        ArrayList<Double> values = new ArrayList<>();
        String line = null;
        String[] lineValues = null;
        try {
            br = new BufferedReader(new FileReader(filename));
            line = br.readLine();
            lineValues = line.split(separator);
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                }
            }
        }
        if (lineValues != null) {
            return lineValues.length;
        } else {
            return 0;
        }
    }

    /**
     * Get the number of columns 
     * @param filename
     * @param separator 
     * @return 
     */
    public static int getColumnsCount(String filename, Separator separator) {
        BufferedReader br = null;
        ArrayList<Double> values = new ArrayList<>();
        String line = null;
        String[] lineValues = null;
        try {
            br = new BufferedReader(new FileReader(filename));
            line = br.readLine();
            lineValues = line.split(separator.getChar());
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                }
            }
        }
        if (lineValues != null) {
            return lineValues.length;
        } else {
            return 0;
        }
    }
    
    /**
     *
     * @param filename
     * @param separator
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static ArrayList<String> getHeaders(String filename, String separator)
            throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        final String headerLine = br.readLine();
        final String[] headerValues = headerLine.split(separator);
        ArrayList<String> result = new ArrayList();
        result.addAll(Arrays.asList(headerValues));
        return result;
    }

    public static ArrayList<String> getHeaders(String filename, Separator separator)
            throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        final String headerLine = br.readLine();
        final String[] headerValues = headerLine.split(separator.getChar());
        ArrayList<String> result = new ArrayList();
        result.addAll(Arrays.asList(headerValues));
        return result;
    }
    
    /**
     * Get the number of rows on dataset
     * @param filename
     * @return 
     */
    public static int getRowCount(String filename) {
        BufferedReader br = null;
        int count = 0;
        String line = null;
        try {
            br = new BufferedReader(new FileReader(filename));
            while ((line = br.readLine()) != null) {
                count += 1;
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                }
            }
        }
        return count;
    }
    
}
