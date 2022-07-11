package sorting;

public class BubbleSort implements SortingAlgorithm {
    /**
     * Bubble Sort is the simplest sorting algorithm that works by
     * repeatedly swapping the adjacent elements if they are in the wrong order.
     * This algorithm is not suitable for large data sets as its average and worst case time complexity is quite high.
     * ref: https://www.geeksforgeeks.org/bubble-sort/
     * @param unsorted array of unsorted values to be ordered
     */
    @Override
    public void sort(int[] unsorted) {
        int n = unsorted.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (unsorted[j] > unsorted[j + 1]) {
                    // swap arr[j+1] and arr[j]
                    int temp = unsorted[j];
                    unsorted[j] = unsorted[j + 1];
                    unsorted[j + 1] = temp;
                }
    }
}