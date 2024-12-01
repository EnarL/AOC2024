import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Day1 {
    public static void main(String[] args) {
        ArrayList<String> lines = new ArrayList<String>();
        readFile(lines);
        System.out.println(totalDistance(lines));
        System.out.println(totalDistance2(lines));

    }

    public static void readFile(ArrayList<String> lines) {
        try {
            File myObj = new File("input.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                lines.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    // Part 1
   private static int totalDistance(ArrayList<String> lines) {
        ArrayList<String> leftSide = new ArrayList<String>();
        ArrayList<String> rightSide = new ArrayList<String>();
        for (String line : lines) {
            leftSide.add(line.split(" ")[0]);
            rightSide.add(line.split(" ")[3]);
        }
        int distance =0;
       leftSide.sort(Comparator.comparingInt(Integer::parseInt));
       rightSide.sort(Comparator.comparingInt(Integer::parseInt));
       for (int i = 0; i < lines.size(); i++) {
           int left = Integer.parseInt(leftSide.get(i));
           int right = Integer.parseInt(rightSide.get(i));
           if (left > right) {
               distance += left - right;
           }
           else{
               distance += right - left;
           }
       }
       return distance;
   }
   // Part 2
    private static int totalDistance2(ArrayList<String> lines){

        ArrayList<String> leftSide = new ArrayList<String>();
        ArrayList<String> rightSide = new ArrayList<String>();
        for (String line : lines) {
            leftSide.add(line.split(" ")[0]);
            rightSide.add(line.split(" ")[3]);
        }
        int similarity =0;
        leftSide.sort(Comparator.comparingInt(Integer::parseInt));
        rightSide.sort(Comparator.comparingInt(Integer::parseInt));
        for (int i = 0; i < lines.size(); i++) {
            for (int j = 0; j < lines.size(); j++) {
                int left = Integer.parseInt(leftSide.get(i));
                int right = Integer.parseInt(rightSide.get(j));
                if (left == right) {
                    similarity += left;

                }
            }


        }
        return similarity;
    }

}
