import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TrueRandomGenerator {
    public static void main(String[] args) throws IOException {
        int randomNumber = generateTrueRandomNumber();
        System.out.println("True Random Number: " + randomNumber);
    }

    public static int generateTrueRandomNumber() throws IOException {
        String apiUrl = "https://www.random.org/integers/?num=1&min=0&max=100&col=1&base=10&format=plain&rnd=new";

        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String response = reader.readLine();

        reader.close();
        connection.disconnect();

        return Integer.parseInt(response.trim());
    }
}

