package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // Самый простой способ прочитать файл (но это по символьно и неудобно)
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
    }
}
