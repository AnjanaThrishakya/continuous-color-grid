package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dto.Node;

public class ColorComparator {

    
    List<Node> maxNodeList = new ArrayList<>();
    Integer count = 0;

    List<List<String>> colorGrid;

    public List<List<String>> findLargeGrid(List<List<String>> colorGrid) {
        
        this.colorGrid =  colorGrid;

        for(Integer row = 0; row< colorGrid.size(); row ++){
            List<String> columns = colorGrid.get(row);
            //System.out.println(row);
            for(Integer column = 0; column<columns.size(); column++){
                List<Node> nodeList = new ArrayList<>();
                //System.out.println(column);
                Node node = new Node(row, column);
                if(!nodeList.contains(node)){
                    nodeList.add(node);
                }
                
                try {
                    initiateSearch(row, column, nodeList, false,true, true, false, colorGrid.size());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if(count<nodeList.size()){
                    count = nodeList.size();
                    maxNodeList = nodeList;
                    nodeList = new ArrayList<>();
                }
               
            }

            
           // System.out.println(Arrays.toString(maxNodeList.toArray()));
            //break;
        }

        List<List<String>> result = getResults();
        return result;
    }
    private List<List<String>> getResults() {

        List<List<String>> resultList = new ArrayList<>();

        if(maxNodeList != null && !maxNodeList.isEmpty()){

            String color = colorGrid.get(maxNodeList.get(0).getRow()).get(maxNodeList.get(0).getColumn());

            for (int i = 0; i < colorGrid.size(); i++) {
                List<String> resultRows = new ArrayList<>();
                for (int j = 0; j < colorGrid.get(0).size(); j++) {
                    if(maxNodeList.contains(new Node(i, j))){
                        resultRows.add(color);
                    } else{
                        resultRows.add(".");
                    }
                }
                resultList.add(resultRows);
            }
        }

        return resultList;
    }
    private void initiateSearch(Integer row, Integer column, List<Node> nodeList, boolean checkLeft, boolean checkRight, boolean checkBottom, boolean checkTop, Integer rowCount) throws Exception{
        
        List<String> columns = this.colorGrid.get(row);
        
        if(checkRight){
            Integer rightColumn = column+1;
            if(rightColumn<columns.size()){
                String color = columns.get(column);
                if(color.equals(columns.get(rightColumn))){
                    Node node = new Node(row, rightColumn);
                    if(!nodeList.contains(node)){
                        nodeList.add(node);
                        initiateSearch(row, rightColumn, nodeList, false, true, true, true, rowCount);
                    }
                    
                }
            }
        }
        

        if(checkBottom){
            Integer bottomRow = row + 1;
            if(bottomRow < rowCount){
                List<String> bottomColumns = this.colorGrid.get(bottomRow);
                String color = columns.get(column);
                if(color.equals(bottomColumns.get(column))){
                    Node node = new Node(bottomRow, column);
                    if(!nodeList.contains(node)){
                        nodeList.add(node);
                        initiateSearch(bottomRow, column, nodeList, true, true, true, false, rowCount);
                    }
                    
                }
    
            }
        }

        if(checkTop){
            Integer topRow = row - 1;
            if(topRow >= 0){
                List<String> topColumns = this.colorGrid.get(topRow);
                String color = columns.get(column);
                if(color.equals(topColumns.get(column))){
                    Node node = new Node(topRow, column);
                    if(!nodeList.contains(node)){
                        nodeList.add(node);
                        initiateSearch(topRow, column, nodeList, true, true, false, true, rowCount);
                    }
                 
                }
    
            }
        }
        
        if(checkLeft){
            Integer leftColumn = column-1;
            if(leftColumn>=0){
                String color = columns.get(column);
                if(color.equals(columns.get(leftColumn))){
                    
                     Node node = new Node(row, leftColumn);
                     if(!nodeList.contains(node)){
                         nodeList.add(node);
                         initiateSearch(row, leftColumn, nodeList, true, false, true, true, rowCount);
                     }
                    
                }
             }
        }

    }

}
