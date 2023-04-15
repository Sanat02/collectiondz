package utils;

import entity.Person;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Person[] person= FileService.readFile();
        for(Person p:person)
        {
            System.out.println(p);
            p.setId(1312);
        }
        System.out.println();
        FileService.writeFile(person);




    }
    private static void initPersonState(Person[] person)
    { 

    }

}
