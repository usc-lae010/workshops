import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class BoyerMooreSearch {

    // Preprocessing function to compute the bad character heuristic table
    private static int[] badCharHeuristic(char[] pattern) {
        int[] badChar = new int[256]; // Assuming ASCII characters

        for (int i = 0; i < badChar.length; i++) {
            badChar[i] = -1; // Initialize all entries as -1
        }

        for (int i = 0; i < pattern.length; i++) {
            badChar[(int) pattern[i]] = i;
        }

        return badChar;
    }

    // Boyer-Moore search algorithm
    public static void search(String text, String pattern) {
        char[] textChars = text.toCharArray();
        char[] patternChars = pattern.toCharArray();
        int n = text.length();
        int m = pattern.length();
        int[] badChar = badCharHeuristic(patternChars);

        int s = 0;
        while (s <= n - m) {
            int j = m - 1;

            // Keep moving until mismatch or end of pattern
            while (j >= 0 && patternChars[j] == textChars[s + j]) {
                j--;
            }

            if (j < 0) {
                System.out.println("Pattern found at index " + s);
                s += (s + m < n) ? m - badChar[textChars[s + m]] : 1;
            } else {
                // Shift the pattern based on the bad character heuristic
                s += Math.max(1, j - badChar[textChars[s + j]]);
            }
        }
    }

    public static void main(String[] args) {
        try {
            // Load the text file
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\User\\Desktop\\Tor Browser\\Browser\\TorBrowser\\Data\\Browser\\profile.default\\AlternateServices.txt" +
                    ""));
            StringBuilder textBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                textBuilder.append(line).append("\n");
            }
            reader.close();
            String text = textBuilder.toString();

            // Take user input for the pattern to search
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the pattern to search for: ");
            String pattern = scanner.nextLine();

            // Perform the Boyer-Moore search
            search(text, pattern);
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}
