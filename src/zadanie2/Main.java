package zadanie2;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
	// Были добавлены методы,которые указывались во втором задании
    String json=readFile();
    ListOfMovies movies=new Gson().fromJson(json, ListOfMovies.class);
    System.out.println(movies);
    System.out.println();
     movies.sortByDate();
     System.out.println();
     movies.sortByName();
     System.out.println();
     movies.sortByDirector();
     System.out.println();
     movies.getActor();
     System.out.println();
     movies.getDirector();
     System.out.println("---------------------------");
     movies.getByDate();
     System.out.println("---------------------------");
     movies.getActorRole();
     System.out.println("---------------------------");
     movies.getActorRoleList2();
    }
    public static String readFile()
    {
        String json="";
        try{
            Path path= Paths.get("practice.json");
            json= Files.readString(path);
        }catch (IOException e)
        {
            e.printStackTrace();
        }
        return  json;

    }


}
