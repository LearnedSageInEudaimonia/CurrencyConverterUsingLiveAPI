import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiHandler {
    public static String getRates(String baseCurrency) throws IOException{
        String url_str = "https://api.exchangerate-api.com/v4/latest/" + baseCurrency;
        URL url = new URL(url_str);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();

        while((inputLine = in .readLine()) != null){
            content.append(inputLine);
        }
        in.close();
        return content.toString();
    }
}
