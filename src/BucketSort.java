import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class BucketSort {
    public static void bucketSort(int[] arr, int maxRange) {
        if (arr == null || arr.length == 0) {
            return;
        }

        int min = Arrays.stream(arr).min().getAsInt();
        int max = Arrays.stream(arr).max().getAsInt();

        int bucketCount = (max - min) / maxRange + 1;
        List<List<Integer>> buckets = new ArrayList<>(bucketCount);

        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }

        for (int num : arr) {
            int bucketIndex = (num - min) / maxRange;
            buckets.get(bucketIndex).add(num);
        }

        int currentIndex = 0;
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
            for (int num : bucket) {
                arr[currentIndex] = num;
                currentIndex++;
            }
        }
    }

    public static void main(String[] args) {
        int[] randomArray = generateRandomArray(100, 1, 1000);
        System.out.println("Generated random array: " + Arrays.toString(randomArray));

        bucketSort(randomArray, 1000);

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

