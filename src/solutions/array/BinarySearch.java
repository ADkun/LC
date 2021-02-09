package solutions.array;

import java.lang.reflect.Array;
import java.util.Arrays;

public class BinarySearch {

    public static int bs(int[] arr, int x) {
        Arrays.sort(arr);
        int max = arr.length - 1, min = 0;
        int mid = mid = min + (x - arr[min]) / (arr[max] - arr[min] * (max - min));
        while (arr[mid] != x && min < max - 1) {
            if (x < arr[mid]) {
                max = mid;
                mid = mid = min + (x - arr[min]) / (arr[max] - arr[min] * (max - min));
            } else {
                min = mid;
                mid = mid = min + (x - arr[min]) / (arr[max] - arr[min] * (max - min));
            }
        }
        if (arr[mid] == x) {
            return mid;
        } else {
            return -1;
        }
    }
}
