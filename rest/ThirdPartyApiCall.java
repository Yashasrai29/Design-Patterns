package rest;

//import org.json.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ThirdPartyApiCall {

    private static final String DUMMY_URL = "https://dummyjson.com/products";

//    public static String getHighestProduct(String response){
//        Jso
//    }

    public static String hitApi() throws IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(DUMMY_URL)).build();
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public static String hitApi2() throws IOException {
        URL url = new URL(DUMMY_URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
//        return (String) connection.getContent();
        if(connection.getResponseCode() != HttpURLConnection.HTTP_OK){
            throw new RuntimeException("Not Found");
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String input;
        while((input = bufferedReader.readLine()) != null){
            sb.append(input);
        }
        bufferedReader.close();
        return sb.toString();
    }

    public static void main(String [] args) throws IOException, InterruptedException {
        String response = hitApi2();
        System.out.println("response "+response);
    }
}
