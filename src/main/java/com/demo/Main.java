package com.demo;

import java.util.Arrays;

public class Main {

    public static void main(String args[]) {

        String[] colourArray = new String[]{"b", "g", "r", "b", "b", "g", "r", "b", "b", "g", "r", "b"};

        System.out.println(Arrays.toString(sort2N(colourArray)));
    }

    public static String[] sort2N(String[] colourArray) {

        int redIndex = 0;
        int blueIndex = 0;
        int greenIndex = 0;

        String[] sortedColorArray = new String[colourArray.length];

        for (String color : colourArray) {

            if ("r".equals(color)) {
                redIndex++;
            } else if ("b".equals(color)) {
                blueIndex++;
            } else {
                greenIndex++;
            }
        }

        for (int i =0; i < colourArray.length; i++) {

            if(i < redIndex) {
                sortedColorArray[i] = "r";
            } else if ( i < redIndex+greenIndex){
                sortedColorArray[i]  = "g";
            } else {
                sortedColorArray[i]  = "b";
            }

        }
        return sortedColorArray;
    }


    public static String[] sortN(String[] colourArray) {


        int redIndex = 0;
        int blueIndex = colourArray.length;


        for(int i=0 ; i< blueIndex; i++){

            if("r".equals(colourArray[i])){
                redIndex++;
            } else if("b".equals(colourArray[i])){

                while(colourArray[blueIndex].equals("b") && blueIndex >= 0 ){
                    blueIndex--;
                }


            } else {

            }

        }

        return colourArray;
    }
}
