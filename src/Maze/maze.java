package src.Maze;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class maze {

    public static void getMaze() {
        try {
            File myObj = new File("maze.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              System.out.println(data);
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
        }
    
}
