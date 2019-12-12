//I basically made 2 loaddata because of the Structure of my api
//Grabbing the Json Data and converting them to Gson works. However showing them and getting data on the Fxml is the issue that I have in this program
//I havent used the Initialize and implenting it.
//I have created a skeleton for the FXML and I have issue with Datepicker and getting the Format in (yyyy/mm/dd) format.
//I have created 2 getDatas because of the type of my Api
//only Exit button on FXML works.


package bsu.comp152;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Date;

public class RoneshDataHandler {

    private HttpClient dataGrabber;
    private String webLocation;
    private String webLocation1;

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
        return weatherData.consolidated_weather;
    }
    public int getData1(){
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
        var weatherData =jsonInterpreter.fromJson(usefulData,responseDataType1.class);
        return weatherData.woeid;
    }

    class responseDataType1{
        String title;
        String location_time;
        int woeid;

        @Override
        public String toString() {
            return "responseDataType1{" +
                    "title='" + title + '\'' +
                    ", location_time='" + location_time + '\'' +
                    ", woeid=" + woeid +
                    '}';
        }

        public responseDataType1(String title, String location_time, int woeid) {
            this.title = title;
            this.location_time = location_time;
            this.woeid = woeid;
        }
    }

    class responseDataType{
        ArrayList<weatherData> consolidated_weather;
    }
    class weatherData{
        String id;
        Date applicable_date;
        String weather_state_name;
        String weather_state_abbr;
        float wind_speed;
        float wind_direction;
        int min_temp;
        int max_temp;
        int the_temp;
        float air_pressure;
        float humidity;
        float visibility;
        float predictability;

        @Override
        public String toString() {
            return "weatherData{" +
                    "id='" + id + '\'' +
                    ", applicable_date=" + applicable_date +
                    ", weather_state_name='" + weather_state_name + '\'' +
                    ", weather_state_abbr='" + weather_state_abbr + '\'' +
                    ", wind_speed=" + wind_speed +
                    ", wind_direction=" + wind_direction +
                    ", min_temp=" + min_temp +
                    ", max_temp=" + max_temp +
                    ", the_temp=" + the_temp +
                    ", air_pressure=" + air_pressure +
                    ", humidity=" + humidity +
                    ", visibility=" + visibility +
                    ", predictability=" + predictability +
                    '}';
        }

        public weatherData(String id, Date applicable_date, String weather_state_name, String weather_state_abbr, float wind_speed, float wind_direction, int min_temp, int max_temp, int the_temp, float air_pressure, float humidity, float visibility, float predictability) {
            this.id = id;
            this.applicable_date = applicable_date;
            this.weather_state_name = weather_state_name;
            this.weather_state_abbr = weather_state_abbr;
            this.wind_speed = wind_speed;
            this.wind_direction = wind_direction;
            this.min_temp = min_temp;
            this.max_temp = max_temp;
            this.the_temp = the_temp;
            this.air_pressure = air_pressure;
            this.humidity = humidity;
            this.visibility = visibility;
            this.predictability = predictability;



        }
    }
}
