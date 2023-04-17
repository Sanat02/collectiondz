package zadanie3;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// Реализация ИНТЕРФЕЙСА для наших методов
    startAction();
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
    public static void printCommands()
    {
        System.out.println("____________________________________________________________________");
        System.out.printf("| 1)Вывести ПОЛНЫЙ список фильмов%35s%n| Сортировка коллекции фильмов:%37s%n|  2)по году ВЫПУСКА%48s%n|  3)по НАЗВАНИЮ%52s%n|  4)по РЕЖИССЕРУ%51s%n","|","|","|","|","|");
        System.out.printf("| 5)Вывести актеров и фильмы в которых он снимался%18s%n| 6)Вывести все фильмы с режиссорами%32s%n| 7)Вывести все фильмы и год их выпуска%29s%n| 8)Вывести актера и его роли в фильме%30s%n| 9)Вывести актера с его ролью (с сортировкой по имени)%13s%n","|","|","|","|","|");
        System.out.println("____________________________________________________________________");
    }
    public static void startAction()
    {
        System.out.println("-------------------------------Начало-------------------------------");
        int isContinue=0;
        while(isContinue==0) {
            printCommands();
            System.out.println("Выберите комманду от 1-9:");
            int num = returnValidNumber(1, 9);
            performCommand(num);
            isContinue = continueAction();
        }
        System.out.println("-------------------------------Конец-------------------------------");

    }
    public static int returnValidNumber(int startNum,int endNum)
    {
        Scanner in=new Scanner(System.in);
        int num= in.nextInt();
        while(num<startNum||num>endNum)
        {
            System.out.printf("Непрвильное значение!%nВыберите комманду от %s-%s:%n",startNum,endNum);
            num= in.nextInt();
        }
        return num;
    }
    public static void performCommand(int num)
    {
        String json=readFile();
        ListOfMovies movies=new Gson().fromJson(json, ListOfMovies.class);
        switch (num)
        {
            case 1:
                System.out.printf("ПОЛНЫЙ список фильмов:%s%n",movies);
                break;
            case 2:
                System.out.println("СОРТИРОВКА");
                movies.sortByDate();
                break;
            case 3:
                System.out.println("СОРТИРОВКА");
                movies.sortByName();
                break;
            case 4:
                System.out.println("СОРТИРОВКА");
                movies.sortByDirector();
                break;
            case 5:
                System.out.println("Список акторов и фильмы в которых он снимался:");
                movies.getActor();
                break;
            case 6:
                System.out.println("Список Режиссоров их фильмов:");
                movies.getDirector();
                break;
            case 7:
                System.out.println("Список фильмов и год их выуска:");
                movies.getByDate();
                break;
            case 8:
                System.out.println("Список актеров и их роли+фильмы:");
                movies.getActorRole();
                break;
            case 9:
                System.out.println("Список актеров и их роли+фильмы:");
                movies.getActorRoleList2();
                break;
            default:
                System.out.println("Error!");
                break;
        }
    }
    public static int continueAction()
    {
        Scanner in=new Scanner(System.in);
        System.out.println("Хотите ли ПРОДОЛЖИТЬ?(0-ДА,1-НЕТ)");
        int num=returnValidNumber(0,1);
        return num;
    }


}
