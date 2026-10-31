import java.io.*;
import java.net.*;
import java.util.*;

class Result {
    public static String ipTracker(String ip) {
        String urlString = "https://hackerrank.com" + ip;
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        
        try {
            URI uri = new URI(urlString);
            URL url = uri.toURL();
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            
            // Critical header to bypass 403 Forbidden authentication blocks
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64)");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            
            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                
                String json = response.toString();
                
                // 1. Check if total records are 0
                if (json.contains("\"total\":0") || json.contains("\"total\" : 0") || json.contains("\"total\": 0")) {
                    return "No Result Found";
                }
                
                // 2. Safely extract country value using native string indexing
                int countryIdx = json.indexOf("\"country\"");
                if (countryIdx != -1) {
                    int colonIdx = json.indexOf(":", countryIdx);
                    int firstQuote = json.indexOf("\"", colonIdx);
                    int secondQuote = json.indexOf("\"", firstQuote + 1);
                    
                    if (firstQuote != -1 && secondQuote != -1) {
                        return json.substring(firstQuote + 1, secondQuote);
                    }
                }
            }
        } catch (Exception e) {
            // Failure safe-fallback
        } finally {
            if (reader != null) {
                try { reader.close(); } catch (Exception e) {}
            }
            if (connection != null) {
                connection.disconnect();
            }
        }
        return "No Result Found";
    }
}

public class solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String ip = bufferedReader.readLine().trim();

        String result = Result.ipTracker(ip);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
