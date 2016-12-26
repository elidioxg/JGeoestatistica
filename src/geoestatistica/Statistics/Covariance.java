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
package geoestatistica.Statistics;

import geoestatistica.Vectors.Vector;
import java.util.ArrayList;

public class Covariance {
    
    /**
     * Calculate covariance of two vectors
     * @param vector1
     * @param vector2
     * @return
     * @throws Exception 
     */
    public static double covariance(Vector vector1, Vector vector2) throws Exception {
        double result = 0.;
        if(vector1.size()!=vector2.size()){
            throw new Exception("The arrays must have same size");
        } else {            
            double avg1 = Average.arithmeticAverage(vector1);
            double avg2 = Average.arithmeticAverage(vector2);
            for(int i = 0; i <vector1.size(); i++){
                result += (vector1.get(i).doubleValue() -
                        avg1)*(vector2.get(i).doubleValue()- avg2);
            }
        }               
        return result/vector1.size();
    }    
    
    /**
     * 
     * @param array1
     * @param array2
     * @return
     * @throws Exception 
     */
    public static double covariance(ArrayList<Double> array1, 
            ArrayList<Double> array2) throws Exception {
        double result = 0.;
        if(array1.size()!=array2.size()){
            throw new Exception("The arrays must have same size");
        } else {            
            double avg1 = Average.arithmeticAverage(array1);
            double avg2 = Average.arithmeticAverage(array2);
            for(int i = 0; i <array1.size()-1; i++){
                result += (array1.get(i) - avg1)*(array2.get(i) - avg2);
            }
        }               
        return result/array1.size();
    }    
    
    /**     
     * @param array1
     * @param array2
     * @param average1
     * @param average2
     * @return
     * @throws Exception 
     */
    public static double covariance(ArrayList<Double> array1, ArrayList<Double> array2,
            double average1, double average2) throws Exception {
        double result = 0.;
        if(array1.size()!=array2.size()){
            throw new Exception("The arrays must have same size");
        } else {
            for(int i = 0; i <array1.size()-1; i++){
                result += (array1.get(i) - average1)*(array2.get(i) - average2);
            }
        }               
        return result/array1.size();
    }
    
}
