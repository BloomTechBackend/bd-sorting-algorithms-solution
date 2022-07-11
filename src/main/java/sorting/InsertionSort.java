package sorting;

public class InsertionSort implements SortingAlgorithm {
    /**
     * Insertion sort is a simple sorting algorithm that works similar to the way you sort playing cards in your hands.
     * The array is virtually split into a sorted and an unsorted part.
     * Values from the unsorted part are picked and placed at the correct position in the sorted part.
     * ref: https://www.geeksforgeeks.org/insertion-sort/
     * @param unsorted
     */
    @Override
    public void sort(int[] unsorted) {
        int n = unsorted.length;
        for (int i = 1; i < n; ++i) {
            int key = unsorted[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && unsorted[j] > key) {
                unsorted[j + 1] = unsorted[j];
                j = j - 1;
            }
            unsorted[j + 1] = key;
        }
    }
}