package solutions.array;

public class QuickSort {

    public void quickSort(int[] arr) {
        qs2(arr, 0, arr.length - 1);
    }

    private void qs(int[] arr, int start, int end) {

        if (start < end) {
            int i = start;
            int j = end;
            int x = arr[start];
            while (i < j) {
                while (i < j && arr[j] >= x)
                    --j;
                if (i < j) arr[i++] = arr[j];
                while (i < j && arr[i] <= x)
                    ++i;
                if (i < j) arr[j--] = arr[i];
            }
            arr[i] = x;
            qs(arr, start, i - 1);
            qs(arr, i + 1, end);
        }
    }

    private void qs2(int[] arr, int start, int end) {
        if (start < end) {
            int i = start, j = end, x = arr[start];
            while (i < j) {
                while (i < j && arr[j] >= x) --j;
                if (i < j) arr[i++] = arr[j];
                while (i < j && arr[i] <= x) ++i;
                if (i < j) arr[j--] = arr[i];
            }
            arr[i] = x;
            qs2(arr, start, i - 1);
            qs2(arr, i + 1, end);
        }
    }

}
