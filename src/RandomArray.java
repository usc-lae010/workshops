// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.Arrays;
import java.util.Random;
import java.util.HashMap;
import java.util.Map;
public class RandomArray {

    public static int[] generateRandomArray(int size, int minValue, int maxValue) {
        if (size <= 0 || maxValue < minValue) {
            throw new IllegalArgumentException("Invalid input parameters.");
        }

        int[] randomArray = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            randomArray[i] =  random.nextInt(maxValue - minValue + 1) + minValue;
        }

        return randomArray;
    }
    public static boolean areAllDistinct(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return true;
        }

        // Create a HashMap to store the frequency of each element
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Check for duplicate elements
        boolean allDistinct = true;
        for (int num : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(num);
            if (frequency > 1) {
                allDistinct = false;
                System.out.println("Duplicate element: " + num + " (Frequency: " + frequency + ")");
            }
        }

        return allDistinct;
    }


    public static void main(String[] args) {
        int[] randomArray = generateRandomArray(100, 1, 1000);
        System.out.println("Generated array: " + Arrays.toString(randomArray));

        boolean allDistinct = areAllDistinct(randomArray);
        System.out.println("Are all elements distinct? " + allDistinct);
    }
}
