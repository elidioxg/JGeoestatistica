/*
 * Copyright (C) 2017 elidioxg
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

import geoestatistica.Matrices.Matrix;
import geoestatistica.Vectors.Vector;
import java.util.ArrayList;

/**
 *
 * @author elidioxg
 */
public class MinimumValue {

    /**
     *
     * @param vector
     * @return
     */
    public static double getMinValue(Vector vector) {
        if (vector.size() != 0) {
            double min = vector.get(0).doubleValue();
            for (int i = 1; i < vector.size(); i++) {
                if (min > vector.get(i).doubleValue()) {
                    min = vector.get(i).doubleValue();
                }
            }
            return min;
        } else {
            return Double.NaN;
        }
    }

    public static double getMinValue(ArrayList<Double> array) {
        if (array.size() != 0) {
            double min = array.get(0);
            for (int i = 1; i < array.size(); i++) {
                if (min > array.get(i).doubleValue()) {
                    min = array.get(i).doubleValue();
                }
            }
            return min;
        } else {
            return Double.NaN;
        }
    }

    public static double getMinValue(Matrix matrix) {
        if (matrix.getColumnsCount() > 0) {
            double result = matrix.get(0, 0).doubleValue();
            for (int i = 0; i < matrix.getColumnsCount(); i++) {
                for (int j = 0; j < matrix.getLinesCount(); j++) {
                    if (result > matrix.get(i, j).doubleValue()) {
                        result = matrix.get(i, j).doubleValue();
                    }
                }
            }
            return result;
        } else {
            return Double.NaN;
        }
    }

}
