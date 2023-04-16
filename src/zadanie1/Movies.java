package zadanie1;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Movies implements Comparable<Movies>{
    private int lastName;
    private String name;
    private String year;
    private String description;
    @SerializedName("director")
    private Director director;
    @SerializedName("cast")
    private List<Cast> cast;
    private String dierctorName;

    public Movies(String name, String year, String description, Director director, List<Cast> cast,String dierctorName) {
        this.name = name;
        this.year = year;
        this.description = description;
        this.director = director;
        this.cast = cast;
        this.dierctorName=director.getFullName();

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

    public String getYear() {
        return year;
    }

    public String getDescription() {
        return description;
    }

    public Director getDirector() {
        return director;
    }

    public String getDierctorName() {
        return director.getFullName();
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


    @Override
    public int compareTo(Movies o) {
        if(o.equals(this.getYear())) {
            return this.getYear().compareTo(o.getYear());
        }
        else if(o.equals(this.getName()))
        {
            return this.getName().compareTo(o.getName());
        }
        else
        {
            return this.director.getFullName().compareTo(o.director.getFullName());
        }
    }


}