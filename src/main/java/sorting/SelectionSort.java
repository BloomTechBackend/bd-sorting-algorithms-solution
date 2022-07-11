package sorting;

public class SelectionSort implements SortingAlgorithm {
    /** The selection sort algorithm sorts an array by repeatedly finding the minimum element
     * (considering ascending order) from unsorted part and putting it at the beginning.
     * The algorithm maintains two subarrays in a given array.
     *  * The subarray which is already sorted.
     *  * Remaining subarray which is unsorted.
     * In every iteration of selection sort, the minimum element
     * (considering ascending order) from the unsorted subarray is picked and moved to the sorted subarray.
     * ref: https://www.geeksforgeeks.org/selection-sort/
     * @param unsorted array of unsorted values to be ordered
     */
    @Override
    public void sort(int[] unsorted) {
        int n = unsorted.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int iMin = i;
            for (int j = i+1; j < n; j++)
                if (unsorted[j] < unsorted[iMin])
                    iMin = j;

            // Swap the found minimum element with the first element
            int temp = unsorted[iMin];
            unsorted[iMin] = unsorted[i];
            unsorted[i] = temp;
        }
    }
}