package com.company;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // Самый простой способ прочитать файл (но это по символьно и неудобно) (ノ_<。)
        System.out.println("---------------------1---------------------");
        Reader reader = new FileReader("text.txt");
        int i = 0;
        while((i = reader.read())!=-1){
            System.out.println((char)i);
        }

        // можно прочитать в массив, но необходимо делать проверки, а иначе он будет пустые клетки делать
        System.out.println("---------------------2---------------------");
        reader = new FileReader("text.txt");
        char[] chars = new char[50];
        while (reader.read(chars) != -1){
            for (int j =0; j<chars.length; j++){
                if (Character.isAlphabetic(chars[j]) || Character.isWhitespace(chars[j])){
                    System.out.println(chars[j]);
                }
            }
        }

        // Через этот способ намного легче и проще всё сделать и читать будет по строке (*^.^*)
        System.out.println("---------------------3---------------------");
        BufferedReader bufferedReader = new BufferedReader(new FileReader("text.txt"));
        List<String> list = new ArrayList<>();
        list.add(bufferedReader.readLine());
        for(String s:list){
            System.out.println(s);
        }

        System.out.println("---------------------4---------------------");
    }
}
