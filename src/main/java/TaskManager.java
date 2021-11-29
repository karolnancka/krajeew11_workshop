import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class TaskManager {

    public static void main(String[] args) {
        Options();


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

    public static void Options(){
        System.out.println(pl.coderslab.ConsoleColors.BLUE + "Please select an option");
        System.out.println(pl.coderslab.ConsoleColors.RESET + "a = add");
        System.out.println("r = remove");
        System.out.println("l = list");
        System.out.println("e = exit");
        listOfStrings();



    }
    public static void listOfStrings(){
        Scanner scanList = new Scanner(System.in);
        String scanListString = scanList.nextLine();
        if("l".equals(scanListString)){
            ReadFile("src/main/Files/tasks.csv");
        }

    }
}
