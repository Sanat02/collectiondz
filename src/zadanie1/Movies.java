package zadanie1;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Movies {
    private String name;
    private int year;
    private String description;
    @SerializedName("director")
    private Director director;
    @SerializedName("cast")
    private List<Cast> cast;

    public Movies(String name, int year, String description, Director director, List<Cast> cast) {
        this.name = name;
        this.year = year;
        this.description = description;
        this.director = director;
        this.cast = cast;
    }

    public String listPrint() {
            String res="";
            for(int i=0;i<cast.size();i++)
            {
                res+="{fullName:"+cast.get(i).getFullName()+",role:+"+cast.get(i).getRole()+"}";
            }
            return res;
    }
    public String getName() {
            return name;
    }

    public int getYear() {
            return year;
    }

    public String getDescription() {
            return description;
    }

    public Director getDirector() {
            return director;
    }

    @Override
    public String toString() {
        return "{" +
                "name:'" + name + '\'' +
                ", year:" + year +
                ", description:'" + description + '\'' +
                ", director:" + director.getFullName()+
                ", cast:[" + listPrint()+"]}";
    }
}


