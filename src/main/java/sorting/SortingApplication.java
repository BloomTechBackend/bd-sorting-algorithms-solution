package sorting;

import java.util.*;

public class SortingApplication {
    public static void main(String[] args) {

        SortingAlgorithm[] algorithms = { // in alphabetical order
//                new BubbleSort(),
                new InsertionSort(),
                new MergeSort(),
                new QuickSort(),
                new SelectionSort()
        };
        Map<SortingAlgorithm, List<Long>> executionTimes = new HashMap<>();
        for (SortingAlgorithm algorithm : algorithms) {
            executionTimes.put(algorithm, new ArrayList<>());
        }

        int[] bases = {10000,20000,30000,40000,50000,60000,70000,80000,90000,100000};
        for (int n : bases) {
            int[] unsorted = randomNumbersArray(n);
            System.out.println(String.format("___Starting sorts with n = %d ___ ", n ));
            for (SortingAlgorithm algorithm : algorithms) {
                int[] copy = unsorted.clone();
                executionTimes.get(algorithm).add(sortTimer(algorithm, copy));
            }
        }

        System.out.println("\nHere are the runtimes for each algorithm:");
        for (SortingAlgorithm algorithm : algorithms) {
            System.out.print(algorithm.getClass() + ": ");
            System.out.println(executionTimes.get(algorithm));
        }

        // After running the algorithms against these data sets,
        // are there some that you would like to test against larger values of n?
        // Be careful! If n is too large it might take minutes, hours, or years for some algorithms to complete

    }

    static int[] randomNumbersArray(int n) {
        int[] numbers = new int[n];
        Random random = new Random();
        for (int i=0;i<n;i++) {
            numbers[i] = random.nextInt(); // unbounded random int
        }
        return numbers;
    }

    static long sortTimer(SortingAlgorithm algorithm, int[] numbers) {
        final long startTime = System.currentTimeMillis();
        algorithm.sort(numbers);
        final long endTime = System.currentTimeMillis();
        final long totalTime = endTime - startTime;
        System.out.println(String.format("%s execution time: %d ms", algorithm.getClass(), totalTime));
        return totalTime;
    }
}
