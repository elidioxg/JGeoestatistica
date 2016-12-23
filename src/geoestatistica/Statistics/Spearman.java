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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author elidioxg
 */
public class Spearman {

    //TODO: eliminate ArrayList and ObservableList, substitute for vector, use Comparator
    /**
     *
     * @param a
     * @param b
     * @return
     * @throws Exception
     */
    public static double calc(ArrayList<Double> a, ArrayList<Double> b) throws Exception {
        double result = Double.NaN;
        if (a.size() != b.size()) {
            throw new Exception("Arrays must have same size.");
        } else {
            ObservableList<Double> olA = FXCollections.observableArrayList(a);
            ObservableList<Double> olB = FXCollections.observableArrayList(b);

            ArrayList<Row> table = new ArrayList();
            for (int i = 0; i < a.size(); i++) {
                Row row = new Row(olA.get(i), olB.get(i));
                table.add(row);
            }

            FXCollections.sort(olA);
            for (int i = 0; i < a.size(); i++) {
                for (int j = 0; j < a.size(); j++) {
                    if (Objects.equals(table.get(i).getX(), olA.get(j))) {
                        // if (table.get(i).getX() == olA.get(j)) {
                        table.get(i).setXRank(Double.valueOf(j + 1));
                        break;
                    }
                }
            }
            FXCollections.sort(olB);
            for (int i = 0; i < b.size(); i++) {
                for (int j = 0; j < b.size(); j++) {
                    if (Objects.equals(table.get(i).getY(), olB.get(j))) {
                        table.get(i).setYRank(Double.valueOf(j + 1));
                        break;
                    }
                }
            }
            for (int k = 0; k < a.size(); k++) {
                System.out.println("x: " + table.get(k).getX() + "  y: " + table.get(k).getY()
                        + "  xi: " + table.get(k).getXRank() + "  yi: " + table.get(k).getYRank());
            }
            System.out.println();
            //TODO: aqui ficarão os procedimentos que procuram por valores repetidos e modificam    

            /////////// Modifica o ranking dos valores de X repetidos
            Double sum_rep = 0.;
            Double num_rep = 0.;
            for (int i = 1; i < a.size(); i++) {
                //if (table.get(i - 1).getXRank() == table.get(i).getXRank()) {                    
                if (Objects.equals(table.get(i - 1).getXRank(), table.get(i).getXRank())) {
                    num_rep++;
                    sum_rep += table.get(i).getXRank() + num_rep;
                    if (i == a.size() - 1) {
                        if (num_rep > 0) {
                            num_rep++;
                            sum_rep += table.get(i - 1).getXRank();
                            for (int j = 0; j < num_rep; j++) {
                                table.get(i - j).setXRank(sum_rep / (num_rep));
                            }
                        }
                    }
                } else {
                    if (num_rep > 0) {
                        num_rep++;
                        sum_rep += table.get(i - 1).getXRank();
                        for (int j = 1; j <= num_rep; j++) {
                            table.get(i - j).setXRank(sum_rep / (num_rep));
                        }
                    }
                    sum_rep = 0.;
                    num_rep = 0.;
                }
            }

            // Modifica os rankings de Y para valores repetidos
            System.out.println(olB);
//            Repeated r = new Repeated();
//            ArrayList<Repeated> array = new ArrayList<>();
            HashMap<Integer, Double> mapValue = new HashMap<>();
            HashMap<Integer, Integer> mapRep = new HashMap<>();
            for (int i = 1; i < olB.size(); i++) {
                System.out.println("olB: " + olB.get(i));
                int rep = 0;
                if (Objects.equals(olB.get(i - 1), olB.get(i))) {
                    if (mapValue.containsValue(olB.get(i))) {
                        rep++;
                        System.out.println("not repeated,  rep: "+rep);
                    } else {
                        //r = new Repeated(i - 1, olB.get(i));
                        rep++;
                        System.out.println("Repeated: " + olB.get(i)+" rep: "+rep);                        
                        mapValue.put(i, olB.get(i));
                    }
                } else {
                    System.out.println("Diff values, rep="+rep);
                    if (rep > 0) {
                        double newRank = 0;
                        for (int j = i; j >= i - rep; j--) {
                            newRank = table.get(i - 1).getYRank()+ j;
                            System.out.println("Setting new rank");
                        }
                        newRank/=rep;
                        System.out.println("newRank: "+newRank);
                        for (int j = i; j >= i - rep; j--) {
                            table.get(j).setYRank(newRank);
                        }
                        
                    }
                    rep = 0;
                }

            }

            System.out.println("Map size: " + mapValue.size());
//
//            for (int i = 0; i < olB.size(); i++) {
//                if (mapValue.containsKey(i)) {
//                    double newRank = table.get(i).getY();
//                    for (int j = 1; j <= table.get(i).getY(); j++) {
//                        newRank += table.get(i).getY() + j;
//                    }
//                    newRank /= table.get(i).getN();
//                    for (int k = 0; k < table.get(i).getN(); k++) {
//                        table.get(i + k).setYRank(newRank);
//                    }
//                }
//
//            }

//            /////////////////////////////////////
            for (int k = 0; k < a.size(); k++) {
                System.out.println("x: " + table.get(k).getX() + "  y: " + table.get(k).getY()
                        + "  xi: " + table.get(k).getXRank() + "  yi: " + table.get(k).getYRank());
            }
            double sum = 0.;
            for (int k = 0; k < a.size(); k++) {
                sum += Math.pow(table.get(k).getXRank() - table.get(k).getYRank(), 2);
            }
            result = 1 - ((6 * sum) / (Math.pow(a.size(), 3) - a.size()));
        }
        return result;
    }

    private static class Repeated {

        private int index = -1;
        private double num;
        private int n;

        public Repeated() {

        }

        public Repeated(int index, double num) {
            this.index = index;
            this.num = num;
            this.n++;
        }

        public void inc() {
            this.n++;
        }

        public int getIndex() {
            return this.index;
        }

        public int getN() {
            return n;
        }

        public double getValue() {
            return num;
        }
    }

    private static class Row {

        private final Double xValue;
        private final Double yValue;
        private Double xRank;
        private Double yRank;
        private int yRep = 0;

        public Row(Double x, Double y) {
            xValue = x;
            yValue = y;
        }

        public Double getX() {
            return this.xValue;
        }

        public Double getY() {
            return this.yValue;
        }

        public Double getXRank() {
            return this.xRank;
        }

        public Double getYRank() {
            return this.yRank;
        }

        public void setXRank(Double rank) {
            this.xRank = rank;
        }

        public void setYRank(Double rank) {
            this.yRank = rank;
        }

        public int getYRep() {
            return this.yRep;
        }
    }
}
