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

    public static String[][] ReadFile(String directory){

        Path path = Paths.get(directory);
        String[][] fileTable = new String[3][3];
        if(Files.exists(path)) {
            try {
                for (String s : Files.readAllLines(path)) {
                    int i = 0;
                    i++;
                    for(int j = 0; j < fileTable[i].length; j++){
                        fileTable[i] = s.split(", ");
                    }
                    System.out.println(Arrays.toString(fileTable[i]));
                }

            } catch (IOException e) {
                System.out.println(e);
            }
        }
        return null;

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
                System.out.println("remove");
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
}
