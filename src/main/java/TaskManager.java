import org.apache.commons.lang3.ArrayUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TaskManager {

    public static void main(String[] args) {
        Menu();


    }

    public static void ReadFile(String directory){

        Path path = Paths.get(directory);
        int i = 0;
        //String[][] fileTable = new String[3][3];
        if(Files.exists(path)) {
            try {
                for (String s : Files.readAllLines(path)) {

                    System.out.println(i + " : " + s);
                    i++;

                }

            } catch (IOException e) {
                System.out.println(e);
            }
        }

    }

    public static void Menu(){
        System.out.println(pl.coderslab.ConsoleColors.BLUE + "Please select an option");
        System.out.println(pl.coderslab.ConsoleColors.RESET + "a = add");
        System.out.println("r = remove");
        System.out.println("l = list");
        System.out.println("e = exit");
        Input();



    }
    public static void Input(){
        Scanner scanList = new Scanner(System.in);
        String input = scanList.nextLine();
        switch(input){
            case "l" :
                ReadFile("src/main/Files/tasks.csv");
                otherAction();
                break;
            case "a" :
                addTask();
                otherAction();
                break;
            case "r" :
                removeTask();
                otherAction();
                break;
            case "e" :
                System.out.println("exit");
                otherAction();
                break;
        }



    }
    public static void otherAction(){
        System.out.println("\n"+"\n"+"Wold you like to perform other actions? (y/n)" );
        Scanner scanList = new Scanner(System.in);
        String input = scanList.nextLine();
        switch (input){
            case "y" :
                Menu();
                break;
            case "n" :
                break;
        }
    }
    public static void addTask(){
        System.out.println("\n" + "Please add task description");
        Scanner scan = new Scanner(System.in);
        String inputDesc = scan.nextLine();


        System.out.println("\n" + "Please add task due date");
        Scanner scan2 = new Scanner(System.in);
        String inputDueDate = scan.nextLine();

        System.out.println("\n" + "Is Your task important (true/false)");
        Scanner scan3 = new Scanner(System.in);
        String inputImportant= scan.nextLine();

        //save to file method

        Path path = Paths.get("src/main/Files/tasks.csv");
        List<String> outList = new ArrayList<>();
        String newRecord = inputDesc + ", " + inputDueDate + ", " + inputImportant;

        try {
            Files.writeString(path, "\n", StandardOpenOption.APPEND);
            Files.writeString(path, newRecord, StandardOpenOption.APPEND);
        } catch (IOException ex) {
            System.out.println("Can't sava a new record");
        }

    }
    public static void removeTask() {

        System.out.println("Please provide number of line to be removed");

        Scanner scan = new Scanner(System.in);
        int numberOfLine = scan.nextInt();
        Path path = Paths.get("src/main/Files/tasks.csv");

        int i = 0;
        int j = 0;
        // counting numbers of records in file
        try {
            for (String s : Files.readAllLines(path)) {
                i++;
            }
        } catch (IOException e) {
            System.out.println(e);
        }

        String[] table = new String[i];

        //input of records to new table
        try {
            for (String s : Files.readAllLines(path)) {
                table[j] = s;
                j++;

            }
        } catch (IOException e) {
            System.out.println(e);
        }

        String[] result = ArrayUtils.remove(table, numberOfLine);
        List<String> outList = new ArrayList<>();

        //replace of the old records with te new ones


        try {
            for (int k = 0; k < result.length; k++) {
                outList.add(result[k]);
                Files.write(path, outList);

            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

}
