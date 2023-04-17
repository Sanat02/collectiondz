package zadanie2;

import com.google.gson.annotations.SerializedName;

import java.util.*;

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
    public void sortByDate()
    {
        List<Movies> sortedList=new ArrayList<>();
        sortedList=movies;
        Comparator cmp=Comparator.comparing(Movies::getYear);
        sortedList.sort(cmp);
        StringBuilder res= new StringBuilder("");
        StringBuilder res2= new StringBuilder("");
        for(int i=0;i<sortedList.size();i++)
        {
            res.append(sortedList.get(i).toString()+"\n");
        }
        sortedList.sort(cmp.reversed());
        for(int i=0;i<sortedList.size();i++)
        {
            res2.append(sortedList.get(i).toString()+"\n");
        }
        System.out.printf("Сортировка по ГОДУ выпуска фильма(по увеличению):%n%s%nСортировка по ГОДУ выпуска фильма(по убыванию):%n%s%n",res,res2);
    }
    public void sortByName()
    {
        List<Movies> sortedList=new ArrayList<>();
        sortedList=movies;
        Comparator cmp=Comparator.comparing(Movies::getName);
        sortedList.sort(cmp);
        StringBuilder res= new StringBuilder("");
        StringBuilder res2= new StringBuilder("");
        for(int i=0;i<sortedList.size();i++)
        {
            res.append(sortedList.get(i).toString()+"\n");
        }
        sortedList.sort(cmp.reversed());
        for(int i=0;i<sortedList.size();i++)
        {
            res2.append(sortedList.get(i).toString()+"\n");
        }
        System.out.printf("Сортировка по НАЗВАНИЮ фильма(по увеличению):%n%s%nСортировка по НАЗВАНИЮ фильма(по убыванию):%n%s%n",res,res2);
    }
    public void sortByDirector()
    {
        List<Movies> sortedList=new ArrayList<>();
        sortedList=movies;
        Comparator cmp=Comparator.comparing(Movies::getDierctorName);
        sortedList.sort(cmp);
        StringBuilder res= new StringBuilder("");
        StringBuilder res2= new StringBuilder("");
        for(int i=0;i<sortedList.size();i++)
        {
            res.append(sortedList.get(i).toString()+"\n");
        }
        sortedList.sort(cmp.reversed());
        for(int i=0;i<sortedList.size();i++)
        {
            res2.append(sortedList.get(i).toString()+"\n");
        }
        System.out.printf("Сортировка по РЕЖИССЕРУ фильма(по увеличению):%n%s%nСортировка по РЕЖИССОРУ фильма(по убыванию):%n%s%n",res,res2);
    }
    public void getActor()
    {
          Map<String,String> mp1=new HashMap<>();

          for(int i=0;i< movies.size();i++)
          {
             String str=String.valueOf(movies.get(i).getName());
              for(int j=0;j<movies.get(i).getCast().size();j++)
              {
                  if(!mp1.isEmpty()&&mp1.containsKey(movies.get(i).getCast().get(j).getFullName()))
                  {
                      String newStr=","+String.valueOf(movies.get(i).getName());
                       mp1.put(movies.get(i).getCast().get(j).getFullName(),mp1.get(movies.get(i).getCast().get(j).getFullName())+newStr);
                  }
                  else {
                      mp1.put(movies.get(i).getCast().get(j).getFullName(),str);
                  }
              }
          }
          for(Map.Entry<String,String> entry:mp1.entrySet())
          {
              System.out.println("Actor:"+entry.getKey());
              System.out.println("MOVIES:["+entry.getValue()+"]");
              System.out.println();
              System.out.println();

          }
    }

    public void getDirector()
    {
        Map<String,String> mp1=new HashMap<>();

        for(int i=0;i< movies.size();i++)
        {
            String str=String.valueOf(movies.get(i).getName());
            if(!mp1.isEmpty()&&mp1.containsKey(movies.get(i).getDierctorName()))
            {
                String newStr=","+String.valueOf(movies.get(i).getName());
                mp1.put(movies.get(i).getDierctorName(),mp1.get(movies.get(i).getDierctorName())+newStr);
            }
            else {
                mp1.put(movies.get(i).getDierctorName(), str);
            }


        }
        for(Map.Entry<String,String> entry:mp1.entrySet())
        {
            System.out.println("Director:"+entry.getKey());
            System.out.println("MOVIES:["+entry.getValue()+"]");
            System.out.println();
            System.out.println();

        }
    }
    public void getByDate()
    {
        Map<String,String> mp1=new HashMap<>();

        for(int i=0;i< movies.size();i++)
        {
            String str=String.valueOf(movies.get(i).getName());
            if(!mp1.isEmpty()&&mp1.containsKey(movies.get(i).getYear()))
            {
                String newStr=","+String.valueOf(movies.get(i).getName());
                mp1.put(movies.get(i).getYear(),mp1.get(movies.get(i).getYear())+newStr);
            }
            else {
                mp1.put(movies.get(i).getYear(), str);
            }

        }
        for(Map.Entry<String,String> entry:mp1.entrySet())
        {
            System.out.println("YEAR :"+entry.getKey());
            System.out.println("MOVIES:["+entry.getValue()+"]");
            System.out.println();
            System.out.println();

        }
    }

    public void getActorRole()
    {
        Map<String,String> mp1=new HashMap<>();

        for(int i=0;i< movies.size();i++)
        {
            String str=String.valueOf(movies.get(i).getName());
            for(int j=0;j<movies.get(i).getCast().size();j++)
            {
                if(!mp1.isEmpty()&&mp1.containsKey(movies.get(i).getCast().get(j).getFullName()))
                {
                    String newStr=","+String.valueOf(movies.get(i).getName())+String.valueOf("(role:"+movies.get(i).getCast().get(j).getRole()+")");
                    mp1.put(movies.get(i).getCast().get(j).getFullName(),mp1.get(movies.get(i).getCast().get(j).getFullName())+newStr);
                }
                else {
                    mp1.put(movies.get(i).getCast().get(j).getFullName(),str+"(role:"+movies.get(i).getCast().get(j).getRole()+")");
                }
            }
        }
        for(Map.Entry<String,String> entry:mp1.entrySet())
        {
            System.out.println("Actor:"+entry.getKey());
            System.out.println("MOVIES:["+entry.getValue()+"]");
            System.out.println();
            System.out.println();
        }
    }
    public void getActorRoleList2()
    {
        Map<String,String> mp1=new HashMap<>();

        for(int i=0;i< movies.size();i++)
        {
            String str="";
            for(int j=0;j<movies.get(i).getCast().size();j++)
            {
                if(!mp1.isEmpty()&&mp1.containsKey(movies.get(i).getCast().get(j).getFullName()))
                {

                    String newStr=","+String.valueOf("(role:"+movies.get(i).getCast().get(j).getRole()+")");
                    mp1.put(movies.get(i).getCast().get(j).getFullName(),mp1.get(movies.get(i).getCast().get(j).getFullName())+newStr);
                }
                else {
                    mp1.put(movies.get(i).getCast().get(j).getFullName(),str+"(role:"+movies.get(i).getCast().get(j).getRole()+")");
                }
            }
        }
        TreeMap<String,String> sortedMap=new TreeMap<>();
        sortedMap.putAll(mp1);
        for(Map.Entry<String,String> entry:sortedMap.entrySet())
        {
            System.out.println("Actor:"+entry.getKey());
            System.out.println("MOVIES:["+entry.getValue()+"]");
            System.out.println();
            System.out.println();
        }
    }


}
