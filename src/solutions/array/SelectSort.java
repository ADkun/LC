package solutions.array;

import java.util.Iterator;

public class SelectSort {

    public void selectSort(int[] array) {
        for (int i = 0; i < array.length - 1; ++i) {
            int index = i;
            int min = array[i];
            for (int j = i + 1; j < array.length; ++j) {
                if (min > array[j]) {
                    min = array[j];
                    index = j;
                }
            }
            array[index] = array[i];
            array[i] = min;
        }
    }
}
