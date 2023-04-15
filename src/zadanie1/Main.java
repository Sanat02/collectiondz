package zadanie1;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
    String json=readFile();
    ListOfMovies movies=new Gson().fromJson(json,ListOfMovies.class);
    System.out.println(movies);



    }
    public static String readFile()
    {
        String json="";
        try{
            Path path= Paths.get("practice.json");
            json= Files.readString(path);
            System.out.println(json);

        }catch (IOException e)
        {
            e.printStackTrace();
        }
        return  json;

    }


}
