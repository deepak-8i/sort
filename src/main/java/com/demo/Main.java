package com.demo;

import java.util.Arrays;

public class Main {

    public static void main(String args[]) {

        String[] colourArray = new String[]{"b", "g", "r", "b", "b", "g", "r", "b", "b", "g", "r", "b"};
        String[] colourArray2 = new String[]{"b", "g", "r", "b", "r", "g", "b"};

        System.out.println(Arrays.toString(sort2N(colourArray)));
        System.out.println(Arrays.toString(sortN(colourArray2)));
    }

    public static String[] sortN(String[] colourArray) {

        int redIndex = 0;
        int blueIndex = colourArray.length -1 ;
        int greenIndex = 0;
        String temp = null;

        // r, g, b order of sorting
        // initial          i = 0       b g r b r g b
        // i --             i = 0       b g r b r g b
        // first iteration  i = 1       g g r b r b b
        // second iteration i = 2       g g r b r b b
        // third  iteration i = 3       r g g b r b b
        // i--    iteration i = 3       r g g r b b b
        // fourth iteration i = 4       r r g g b b b


        for(int i=0 ; i <= blueIndex; i++){

            if("r".equals(colourArray[i])){  // then move the redIndex

                temp = colourArray[redIndex];
                colourArray[redIndex] = colourArray[i];
                colourArray[i] = temp;
                redIndex++;
                greenIndex++;

            } else if("b".equals(colourArray[i])){ // then swap to the last and decrease the blueIndex

                /*while(colourArray[blueIndex].equals("b")){
                    blueIndex--;
                }*/
                temp = colourArray[blueIndex];
                colourArray[blueIndex] = colourArray[i];
                colourArray[i] = temp;
                blueIndex--;
                i--;
            } else { // else for greenIndex move the pointer
                greenIndex++;
            }
        }
        return colourArray;
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
}
