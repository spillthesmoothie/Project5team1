package bsu.comp152;

import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class armoury {
    private HttpClient client;
    private String url;

    public armoury(String url){
        client = HttpClient.newHttpClient();
        this.url = url;
    }

    public String getData(String type){
        if (!type.equalsIgnoreCase("planets")&& !type.equalsIgnoreCase("people"))
            return "Please enter 'planets' or 'people' in the box-__-";
        var requestBuilder = HttpRequest.newBuilder();
        var dataRequest = requestBuilder.uri(URI.create(url)).build();
        HttpResponse<String> response = null;
        try {
            response = client.send(dataRequest, HttpResponse.BodyHandlers.ofString());
        }catch (IOException | InterruptedException x){
            System.out.println("This site site is BROKEN !");
        }
        if (response == null)
            System.exit(-1);
        var impData = response.body();
        var jsonInterpreter = new Gson();

        var starData = jsonInterpreter.fromJson(impData, responseDataType.class);

        if (type.equalsIgnoreCase("planets")) {
            if (starData.results.isEmpty())
                return "This planet is not in this movie";
            else
                return starData.results.get(0).toStringPlanets();
        }else if (type.equalsIgnoreCase("people"))
            if (starData.results.isEmpty())
                return "This character is not in the movie";
            else
                return starData.results.get(0).toStringPeople();
            else
                return "NOT VALiD";
    }
    public String getDataNoSearch(){
        var requestBuild = HttpRequest.newBuilder();
        var dataRequest = requestBuild.uri(URI.create(url)).build();
        HttpResponse<String> response = null;
        try {
            response = client.send(dataRequest, HttpResponse.BodyHandlers.ofString());
        }catch (IOException | InterruptedException e){
            System.out.println("Connection is poor");
        }
        if (response == null)
            System.exit(-1);
        var useData = response.body();
        var jsonInt = new Gson();
        var data = jsonInt.fromJson(useData, starWarsDataType.class);

        if (data.title != null)
            return data.title;
        else
            return data.name;
    }
    class responseDataType{
        int count;
        String next;
        String prev;
        ArrayList<starWarsDataType> results;
    }
    class starWarsDataType{
        String climate;
        String diameter;
        String[] films;
        String name;
        String population;

        String birth_year;
        String height;
        String homeWorld;
        String[] species;
        String[] starshipz;

        String title;

        public String toStringPlanets(){
            String movies = "";
            for (String film : films){
                armoury arms = new armoury(film);
                movies = movies + "          "  + arms.getDataNoSearch() + "\n";
            }
            return "Planet's name: " + name +
                    "\nClimate: " + climate +
                    "\nDiameter: " + diameter +
                    "\nPopulation: " + population +
                    "\nFilms: \n " + movies;
        }


    public String toStringPeople() {
        String movies = " ";
        for (String film : films){
            armoury zy = new armoury(film);
            movies = movies + "   " + zy.getDataNoSearch() + "\n";
        }

        String spaceShips = " ";
        for (String ship : starshipz){
            armoury op = new armoury(ship);
            spaceShips = spaceShips + "      " + op.getDataNoSearch() + "\n";
        }
        armoury homePlanet = new armoury(homeWorld);
        String home = homePlanet.getDataNoSearch();

        return "Name: " + name +
                "\nBirth year: " + birth_year +
                "\nHome Planet: " + home +
                "\nStarShips: \n" + starshipz +
                "species: \n" + species +
                "Films: \n" + movies;


        }
    }
}
