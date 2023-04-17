package zadanie3;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Movies implements Comparable<Movies>{
    private static HashMap<String,List<String>> mp=new HashMap<>();
    private String name;
    private String year;
    private String description;
    @SerializedName("director")
    private Director director;
    @SerializedName("cast")
    private List<Cast> cast;
    private String dierctorName;
    private String getRole;

    public List<Cast> getCast() {
        return cast;
    }

    public Movies(String name, String year, String description, Director director, List<Cast> cast, String dierctorName) {
        this.name = name;
        this.year = year;
        this.description = description;
        this.director = director;
        this.cast = cast;
        this.dierctorName=director.getFullName();


    }

    public  HashMap<String,List<String>> getMpValue() {
        List<String> list=new ArrayList<>();
        list.add(name);
        for(int i=0;i<cast.size();i++)
        {
                mp.put(cast.get(i).getFullName(), list);
        }

        return mp;
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