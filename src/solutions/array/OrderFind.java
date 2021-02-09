package solutions.array;

public class OrderFind {

    public int orderFind(int[] array, int x) {
        for (int i = 0; i < array.length; ++i) {
            if (array[i] == x)
                return i;
        }
        return -1;
    }
}
