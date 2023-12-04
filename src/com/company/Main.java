package com.company;

import java.io.*;
import java.util.*;
import java.util.zip.ZipInputStream;

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
        reader.close();

        // true необходим, а иначе затирает текст
        Writer writer = new FileWriter("text.txt", true);
        writer.write("str\n");
        writer.flush();
        writer.close();

        // Через этот способ намного легче и проще всё сделать и читать будет по строке (*^.^*)
        System.out.println("---------------------3---------------------");
        BufferedReader bufferedReader = new BufferedReader(new FileReader("text.txt"));
        String s;
        while((s = bufferedReader.readLine()) != null){
            System.out.println(s);
        }
        bufferedReader.close();

        try(BufferedWriter bufferedWriter = new BufferedWriter( new FileWriter("text.txt", true))) {
            bufferedWriter.write("trs");
            bufferedWriter.newLine();
        }

        // Считывает по битам каждый символ
        System.out.println("---------------------4---------------------");
        InputStream inputStream = new FileInputStream("text.txt");
        i=0;
        while((i = inputStream.read()) != -1){
            System.out.println(i);
        }

        try(OutputStream outputStream = new FileOutputStream("text.txt", true)) {
            outputStream.write(107);
            outputStream.write(10);
        }

        // Еще есть BufferedInputStream/BufferedOutputStream/DataInputStream/ZipInputStream
    }
}
