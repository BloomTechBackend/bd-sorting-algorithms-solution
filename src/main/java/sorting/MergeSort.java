package sorting;

public class MergeSort implements SortingAlgorithm {
    @Override
    public void sort(int[] unsorted) {
        this.sort(unsorted, 0, unsorted.length-1);
    }

    /**
     * The Merge Sort algorithm is a sorting algorithm that is considered as
     * an example of the divide and conquer strategy. In this algorithm, the array
     * is initially divided into two equal halves and then they are combined in a sorted manner.
     * We can think of it as a recursive algorithm that continuously splits
     * the array in half until it cannot be further divided. This means that if the
     * array becomes empty or has only one element left, the dividing will stop,
     * i.e. it is the base case to stop the recursion. If the array has multiple elements,
     * we split the array into halves and recursively invoke the merge sort on each of the halves.
     * Finally, when both the halves are sorted, the merge operation is applied.
     * Merge operation is the process of taking two smaller sorted arrays and
     * combining them to eventually make a larger one.
     * ref: https://www.geeksforgeeks.org/merge-sort/
     */
    private void sort(int arr[], int l, int r)
    {
        if (l < r) {
            // Find the middle point
            int m =l+ (r-l)/2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    private void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}