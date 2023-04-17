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
	// Задание 1 чтение из файла,преобразование данных в полей обьекта,плюс методы из первого задание КРОМЕ метода котрый должен был находить схожие названия
    String json=readFile();
    ListOfMovies movies=new Gson().fromJson(json,ListOfMovies.class);
    System.out.println(movies);
    System.out.println();
     movies.sortByDate();
     System.out.println();
     movies.sortByName();
     System.out.println();
     movies.sortByDirector();
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
