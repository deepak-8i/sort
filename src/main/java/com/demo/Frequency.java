package com.demo;

import java.util.Calendar;

public class Frequency {


    public static void main(String args[]) {

        System.out.println(executeOnFrequency(5));
    }

    public static boolean executeOnFrequency(int frequency){

        Calendar current = Calendar.getInstance();
        int hour = current.get(Calendar.HOUR_OF_DAY);
        int minutes = current.get(Calendar.MINUTE);
        int totalMinute = hour * 60 + minutes;

        if(totalMinute % frequency == 0){
            method();
            return true;
        }
        return false;
    }

    private static void method() {
        // do something
    }

}
