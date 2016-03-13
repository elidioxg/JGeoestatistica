package geoestatistica.FrequencyTable;

import java.util.ArrayList;

public class CountFrequency {

    /*
    *Count the number of frequency observed
    */
    public static ArrayList<Integer> getObservationsFrequency(
            ArrayList<Double> array, ArrayList<Double> extremeValues) {
        ArrayList<Integer> result = new ArrayList();
        for (int i = 0; i < array.size(); i++) {
            for (int j = 0; j < extremeValues.size(); j +=2) {
                if (array.get(i) >= extremeValues.get(j)
                        && array.get(i) <= extremeValues.get(j + 1)) {
                    int count = result.get(j);
                    count++;
                    result.add(j, count);
                }
            }
        }
        return result;
    }

}
