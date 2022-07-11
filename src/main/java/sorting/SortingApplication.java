package sorting;

import java.util.Random;

public class SortingApplication {
    public static void main(String[] args) {

        SortingAlgorithm[] algorithms = {
                new BubbleSort(),
                new InsertionSort(),
                new MergeSort(),
                new QuickSort(),
                new SelectionSort()
        };

        int[] bases = {1000, 5000, 10000, 25000, 50000, 100000};
        for (int n : bases) {
            int[] unsorted = randomNumbersArray(n);
            System.out.println(String.format("___Starting sorts with n = %d ___ ", n ));
            for (SortingAlgorithm algorithm : algorithms) {
                int[] copy = unsorted.clone();
                sortTimer(algorithm, copy);
            }
        }

        // After running the algorithms against these data sets,
        // are there some that you would like to test against larger values of n?
        // Be careful, if n is too large it might take minutes, hours, or years for some algorithms to complete

    }

    static int[] randomNumbersArray(int n) {
        int[] numbers = new int[n];
        Random random = new Random();
        for (int i=0;i<n;i++) {
            numbers[i] = random.nextInt(); // unbounded random int
        }
        return numbers;
    }

    static void sortTimer(SortingAlgorithm algorithm, int[] numbers) {
        final long startTime = System.currentTimeMillis();
        algorithm.sort(numbers);
        final long endTime = System.currentTimeMillis();
        System.out.println(String.format("%s execution time: %d ms", algorithm.getClass(), (endTime - startTime)));
    }
}
