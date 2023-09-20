import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] randomArray = generateRandomArray(100, 1, 1000);
        System.out.println("Generated random array: " + Arrays.toString(randomArray));

        quickSort(randomArray, 0, randomArray.length - 1);

        System.out.println("Sorted array: " + Arrays.toString(randomArray));
    }

    public static int[] generateRandomArray(int size, int minValue, int maxValue) {
        if (size <= 0 || maxValue < minValue) {
            throw new IllegalArgumentException("Invalid input parameters.");
        }

        int[] randomArray = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            randomArray[i] = random.nextInt(maxValue - minValue + 1) + minValue;
        }

        return randomArray;
    }
}

