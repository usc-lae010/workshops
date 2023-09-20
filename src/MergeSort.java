import java.util.Arrays;
import java.util.Random;

public class MergeSort {
    public static void merge(int[] arr, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        for (int i = 0; i < n1; i++)
            leftArr[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            rightArr[j] = arr[middle + 1 + j];

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);
            merge(arr, left, middle, right);
        }
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

    public static void main(String[] args) {
        int[] randomArray = generateRandomArray(100, 0, 10000);
        System.out.println("Generated random array: " + Arrays.toString(randomArray));

        mergeSort(randomArray, 0, randomArray.length - 1);

        System.out.println("Sorted array: " + Arrays.toString(randomArray));
    }
}
