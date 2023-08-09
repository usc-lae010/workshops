public class BinarySearchRecursive {

    public static int binarySearch(int[] array, int target) {
        return binarySearch(array, target, 0, array.length - 1);
    }

    private static int binarySearch(int[] array, int target, int left, int right) {
        if (left > right) {
            return -1; // Element not found
        }

        int mid = left + (right - left) / 2;

        if (array[mid] == target) {
            return mid; // Element found at mid-index
        } else if (array[mid] < target) {
            return binarySearch(array, target, mid + 1, right); // Search in the right half
        } else {
            return binarySearch(array, target, left, mid - 1); // Search in the left half
        }
    }

    public static void main(String[] args) {
        int[] sortedArray = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        int target = 23;

        int resultIndex = binarySearch(sortedArray, target);

        if (resultIndex != -1) {
            System.out.println("Element found at index " + resultIndex);
        } else {
            System.out.println("Element not found in the array");
        }
    }
}

