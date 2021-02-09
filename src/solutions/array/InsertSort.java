package solutions.array;

public class InsertSort {

    public void insertSort(int[] array) {
        for (int i = 0; i < array.length - 1; ++i) {
            if (array[i + 1] < array[i]) {
                // 插入到已排序好的数组里
                for (int j = i + 1; j > 0; --j) {
                    if (array[j - 1] > array[j]) {
                        int temp = array[j - 1];
                        array[j - 1] = array[j];
                        array[j] = temp;
                    } else {
                        break;
                    }
                }
            }
        }
    }
}
