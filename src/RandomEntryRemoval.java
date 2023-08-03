import java.util.Random;

public class RandomEntryRemoval {
    public static void main(String[] args) {
        // Sample array for demonstration
        Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        removeRandomEntries(array);
    }

    public static <T> void removeRandomEntries(T[] array) {
        Random rand = new Random();

        while (array.length > 0) {
            int randomIndex = rand.nextInt(array.length);
            T removedEntry = array[randomIndex];

            // Move the last element to the position of the removed element
            array[randomIndex] = array[array.length - 1];

            // Create a new array with one less element
            T[] newArray = (T[]) new Object[array.length - 1];
            System.arraycopy(array, 0, newArray, 0, array.length - 1);

            array = newArray;

            System.out.println("Removed: " + removedEntry);
        }
    }
}

