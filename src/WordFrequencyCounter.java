import java.util.*;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder inputBuilder = new StringBuilder();

        System.out.println("Enter lines of words separated by whitespace (type 'exit' to stop input):");
        String line;
        while (true) {
            line = scanner.nextLine();
            if (line.trim().equalsIgnoreCase("exit") || line.isEmpty()) {
                break;
            }
            inputBuilder.append(line).append(" ");
        }

        long startTime = System.nanoTime();

        // Split the input string into words based on whitespace
        String input = inputBuilder.toString().trim();
        String[] words = input.split("\\s+");

        // Create a HashMap to store word counts
        Map<String, Integer> wordCounts = new HashMap<>();

        // Count the occurrences of each word and update the HashMap
        for (String word : words) {
            wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
        }

        long endTime = System.nanoTime();
        double totalTime = (endTime - startTime) / 1_000_000.0; // Convert to milliseconds

        // Print the word counts
        System.out.println("Word Frequencies:");
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("Time taken: " + totalTime + " milliseconds");
    }
}
