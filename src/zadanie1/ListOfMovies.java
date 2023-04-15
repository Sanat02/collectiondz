package zadanie1;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListOfMovies {
    @SerializedName("movies")
    private List<Movies> movies;
    public String moviePrint()
    {
        StringBuilder res= new StringBuilder("");
        for(int i=0;i<movies.size();i++)
        {
            res.append(movies.get(i).toString()+"\n");
        }

        return res.toString();
    }

    @Override
    public String toString() {
        return "{" +
                "movies:[" + moviePrint()+"]}";
    }
}
