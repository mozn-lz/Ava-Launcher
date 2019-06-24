package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Flyable fly;
        String file;
        if(args.length == 0) {
            file = args[1];
        } else{
            file = "scenario.txt";
        }
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            while (line != null){
//                call other function
                switch (){

                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
