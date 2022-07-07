package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ColorGridGenerator {

    public List<List<String>> generate(Integer row, Integer column) {
        
        List<List<String>> colorGrid= new ArrayList<>(); 
        for(Integer i = 0; i < row; i++){
            List<String> colorRow = new ArrayList<>();
            for(Integer j = 0; j < column; j++){
                colorRow.add(getRandomColor());
            }
            colorGrid.add(colorRow);
        }
        return colorGrid;
    }

    private String getRandomColor() {
        String [] colorArr = {"R", "G", "B"};

        Random r = new Random();
        int index = r.nextInt(3);

        return colorArr[index];
    }

    

}
