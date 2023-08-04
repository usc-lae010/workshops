import java.util.HashSet;

public class MultiplayerGame {
    private final int n; // Number of players
    private final boolean[][] meetings; // 2D array to track meetings
    private final HashSet[] playerMeetings; // HashSet to track meetings for each player
    private final int[] meetingCounts; // Array to keep track of the number of meetings for each player

    public MultiplayerGame(int n) {
        this.n = n;
        meetings = new boolean[n + 1][n + 1]; // Index 0 is not used to make player numbers 1 to n
        playerMeetings = new HashSet[n + 1];
        meetingCounts = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            playerMeetings[i] = new HashSet<>();
        }
    }

    public void meet(int i, int j) {
        if (i == j) {
            return; // Players cannot meet themselves
        }

        // If the meeting is not already recorded, update the data structures
        if (!meetings[i][j]) {
            meetings[i][j] = true;
            meetings[j][i] = true;

            playerMeetings[i].add(j);
            playerMeetings[j].add(i);

            meetingCounts[i]++;
            meetingCounts[j]++;
        }
    }

    public int getMeetingCount(int playerNumber) {
        return meetingCounts[playerNumber];
    }

    public boolean isWinner(int playerNumber) {
        return meetingCounts[playerNumber] == n - 1;
    }

    public static void main(String[] args) {
        int n = 1000; // Number of players
        MultiplayerGame game = new MultiplayerGame(n);

        // Simulate player meetings (replace this with the actual game logic)
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                game.meet(i, j);
            }
        }

        // Find and print the winner
        for (int i = 1; i <= n; i++) {
            if (game.isWinner(i)) {
                System.out.println("Player " + i + " is the winner!");
                break;
            }
        }
    }
}
