package bsu.comp152;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class RoneshDataHandler {

    private HttpClient dataGrabber;
    private String webLocation;

    public RoneshDataHandler (String webLocation){
        dataGrabber = HttpClient.newHttpClient();
     this.webLocation = webLocation;}
     public ArrayList<weatherData> getData(){
    var requestBuilder = HttpRequest.newBuilder();
    var dataRequest = requestBuilder.uri(
            URI.create(webLocation)).build();
    HttpResponse<String> response = null;
        try
    {
        response = dataGrabber.send(dataRequest, HttpResponse.BodyHandlers.ofString());
    }catch(
    IOException e)
    {
        System.out.println("Error connecting to network or site");
    }
        catch(
    InterruptedException e)

    {
        System.out.println("Connection to site broken");
    }
        if(response ==null)

    {
        System.out.println("Something went terribly wrong, ending program");
        System.exit(-1);
    }
        System.out.println(response);
    var usefulData = response.body();
    var jsonInterpreter =new Gson();
    var weatherData =jsonInterpreter.fromJson(usefulData,responseDataType.class);
        return weatherData.results;
}
class responseDataType{
        ArrayList<weatherData> results;
}
class weatherData{
        String id;
}
}

