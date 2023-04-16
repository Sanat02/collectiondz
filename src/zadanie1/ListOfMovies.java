package zadanie1;

import com.google.gson.annotations.SerializedName;

import java.util.*;

public class ListOfMovies {
    @SerializedName("movies")
    private List<Movies> movies;

//    public List<Movies> getSimilarMovies()
//    {
//        List<Movies> nameOfMovies=new ArrayList<>();
//        Set<String> set=new HashSet<>();
//        List<String> duplicates=new ArrayList<>();
//        List<String> list=new ArrayList<>();
//        for(int i=0;i<movies.size()-1;i++)
//        {
//            String text=String.valueOf(movies.get(i).getName());
//            text=text.replace("\\s+"," ");
//           String[] arr=text.split("\\s");
//            for(int j=0;j< arr.length;j++)
//            {
//                System.out.println(arr[j]);
//                list.add(arr[j].toLowerCase(Locale.ROOT));
//            }
//            System.out.println("");
//        }
//        List<String> removedWords=new ArrayList<>();
//        removedWords.add("the");
//        removedWords.add("an");
//        removedWords.add("and");
//        removedWords.add("of");
//        list.removeAll(removedWords);
//        System.out.println(list);
//        String w="";
//        for(String i:list)
//        {
//
//            if(set.contains(i))
//            {
//
//                duplicates.add(i);
//            }else
//            {
//               set.add(i) ;
//            }
//        }
//        System.out.println(duplicates);
//
//        return nameOfMovies;
//    }

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
}
