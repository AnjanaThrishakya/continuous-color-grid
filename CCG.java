import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import util.ColorComparator;
import util.ColorGridGenerator;

public class CCG {

    public static void main(String[] args) {
        List<List<String>> colorGrid = new ColorGridGenerator().generate(10, 10);
        for (List<String> list : colorGrid) {
           // System.out.println(Arrays.toString(list.toArray()));
            for (String color: list) {
                System.out.print(color + " ");
            }
            System.out.println();
        }

        List<List<String>> largestGrid = new ColorComparator().findLargeGrid(colorGrid);

        System.out.println("");
        for (List<String> list : largestGrid) {
            for (String color: list) {
                System.out.print(color + " ");
            }
            System.out.println();
        }

    }
    
}
