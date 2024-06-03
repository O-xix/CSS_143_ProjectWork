/*
 * 2.5.
 * Selection sort has an overall time complexity of O(n^2), where we have n (outer loop) * n (findSmallest) 
 * Bubble sort has the same overall time complexity, n (outer loop) * (n - i - 1)
 * 
 * 
 */

import java.util.Arrays;

/**
 * This class implements multiple sort algorithms.
 *
 * @author Teja Dasari
 * @version (CSSSKL 143)
 */

public class Sort {
    public static final int SIZE = 10;

    public static void main(String[] args) {
        int[] bubbleArray = new int[SIZE];
        String[] bubbleArrayString = new String[SIZE];
        int[] selectionArray = new int[SIZE];
        int[] insertionArray = new int[SIZE];

        for (int i = 0; i < SIZE; i++) {
            bubbleArray[i] = (int) (Math.random() * 52);
            bubbleArrayString[i] = "abc" + (char) (Math.random() * 52);
            selectionArray[i] = (int) (Math.random() * 52);
            insertionArray[i] = (int) (Math.random() * 52);
        }

        System.out.println("Array before bubble sort:");
        System.out.println(Arrays.toString(bubbleArray));
        bubbleSort(bubbleArray);
        System.out.println("Array after bubble sort:");
        System.out.println(Arrays.toString(bubbleArray));
        System.out.println();

        System.out.println("Array before selection sort:");
        System.out.println(Arrays.toString(selectionArray));
        selectionSort(selectionArray);
        System.out.println("Array after selection sort:");
        System.out.println(Arrays.toString(selectionArray));
        System.out.println();

        System.out.println("Array before insertion sort:");
        System.out.println(Arrays.toString(insertionArray));
        insertionSort(insertionArray);
        System.out.println("Array after insertion sort:");
        System.out.println(Arrays.toString(insertionArray));

        // TODO Test your string sort here
        System.out.println("Array before bubble sort:");
        System.out.println(Arrays.toString(bubbleArrayString));
        bubbleSort(bubbleArrayString);
        System.out.println("Array after bubble sort:");
        System.out.println(Arrays.toString(bubbleArrayString));
        System.out.println();
    }

    /**
     * Sorts an array through value comparisions.
     * @param numbers int array of values.
     */
    public static void bubbleSort(int[] numbers) {
        if (numbers == null || numbers.length <= 1) {
            return;
        }
    
        int n = numbers.length;
        boolean swapped;
    
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
    
            for (int j = 0; j < n - 1; j++) { 
                if (numbers[j] > numbers[j + 1]) {
                    swap(numbers, j, j + 1);
                    swapped = true;
                }
            }
    
            if (!swapped) {
                break;
            }
        }
    }
    /**
     * Sorts an array through value comparisions.
     * @param strings String array of values.
     */
    public static void bubbleSort(String[] strings) {
        if (strings == null || strings.length <= 1) {
            return;
        }
    
        int n = strings.length;
        boolean swapped;
    
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1; j++) {
                if (strings[j].compareTo(strings[j + 1]) > 0) {
                    swap(strings, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    /**
     * Swaps the values in the two indexes of an array.     *
     * @param numbers int array of values.
     * @param indexA one int index.
     * @param indexB second int index.
     */
    public static void swap(int[] numbers, int indexA, int indexB) {
        if (numbers == null || indexA < 0 || indexB < 0 || indexA >= numbers.length || indexB >= numbers.length) {
            System.out.println("Invalid indices or null array.");
            return;
        }
        int temp = numbers[indexA];
        numbers[indexA] = numbers[indexB];
        numbers[indexB] = temp;
    }
    public static void swap(String[] strings, int indexA, int indexB) {
        if (strings == null || indexA < 0 || indexB < 0 || indexA >= strings.length || indexB >= strings.length) {
            System.out.println("Invalid indices or null array.");
            return;
        }
        String temp = strings[indexA];
        strings[indexA] = strings[indexB];
        strings[indexB] = temp;
    }

    // selection sort for ints
    public static void selectionSort(int[] numbers) {
        if (numbers == null || numbers.length <= 1) {
            return;
        }
        int n = numbers.length;
        for (int i = 0; i < n - 1; i++) {
            int smallestIndex = findSmallest(numbers, i, n - 1);
            swap(numbers, i, smallestIndex);
        }
    }

    public static void swapSelection(int[] intList, int i, int nextMin) {
        if (intList == null || i < 0 || nextMin < 0 || i >= intList.length || nextMin >= intList.length) {
            System.out.println("Invalid indices or null array.");
            return;
        }
        int temp = intList[i];
        intList[i] = intList[nextMin];
        intList[nextMin] = temp;
    }


    public static int findSmallest(int[] arr, int begin, int end) {
        int minIndex = begin;
        int minValue = arr[begin];
        for (int i = begin + 1; i < end; i++) {
            if (arr[i] < minValue) {
                minIndex = i;
                minValue = arr[i];
            }
        }
        return minIndex;
    }

    /**
     * Method implement an insertion sort algorithm, taking values and putting them and indexes to sort.
     * @param numbers int array of values.
     */
    public static void insertionSort(int[] numbers) {
        if (numbers == null || numbers.length <= 1) {
            return;
        }
        int n = numbers.length;
        for (int i = 1; i < n; i++) {
            int key = numbers[i];
            int hole = i - 1;
            while (hole >= 0 && numbers[hole] > key) {
                numbers[hole + 1] = numbers[hole];
                hole--;
            }
            numbers[hole + 1] = key;
        }
    }
}
