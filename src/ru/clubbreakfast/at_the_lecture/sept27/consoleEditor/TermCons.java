package ru.clubbreakfast.at_the_lecture.sept27.consoleEditor;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class TermCons {
    private static void isExist(String str){
        Path file = Paths.get(str);
        if (!Files.exists(file))throw new IllegalArgumentException("404. File not found");
        if (Files.isDirectory(file))throw new IllegalArgumentException("this file is directory");
    }
    public static void main(String[] args) {
        System.out.println("Вводить запросы вида: оператор файл записываемыйТекст \n" +
                "Операторы: read, write, append \n " +
                "Оператор appendToLine экспериментальный. Синтаксис: appendToLine файл добавляемыйТекст №строки");
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        try {
            str = bf.readLine();
        } catch (IOException e) { e.printStackTrace(); }
        String[] arr = str.split(" ",3);
        String doIt = arr[0];
        if (arr[1]==null) throw new IllegalArgumentException("File not found");
        try {
            bf.close();
        } catch (IOException e) { e.printStackTrace(); }

        switch (doIt) {
            case "read":
                TermCons.isExist(arr[1].trim());
                try (FileReader fr = new FileReader(arr[1].trim());
                     BufferedReader br = new BufferedReader(fr)) {
                    while (br.ready())
                        System.out.println(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }

                break;
            case "write":
                if (arr[2] == null) throw new IllegalArgumentException("укажите что писать");
                try (FileWriter fw = new FileWriter(arr[1].trim());
                     BufferedWriter buffW = new BufferedWriter(fw)) {
                    buffW.write(arr[2].trim());
                    buffW.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                break;
            case "append":
                if (arr[2] == null) throw new IllegalArgumentException("укажите что писать");
                try (FileWriter fw = new FileWriter(arr[1].trim(), true);
                     BufferedWriter buffW = new BufferedWriter(fw)) {
                    buffW.write("\n");
                    buffW.write(arr[2].trim());
                    buffW.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                break;
            case "appendToLine":
                TermCons.isExist(arr[1].trim());
                if (arr[2] == null) throw new IllegalArgumentException("укажите что писать");
                int slash = (arr[2].trim()).lastIndexOf(" ");
                int numberLine = Integer.parseInt(arr[2].substring(slash).trim());
                String addingTXT = arr[2].substring(0, slash).trim();

                ArrayList<String> list = null;
                Path file = Paths.get(arr[1].trim());
                try {
                    list = (ArrayList<String>) Files.readAllLines(file, Charset.defaultCharset());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (list == null) throw new IllegalArgumentException("укажите что писать");
                if (numberLine < 0 | numberLine > list.size())
                    throw new IllegalArgumentException("укажите корректную строку для записи");
                list.add(numberLine, addingTXT);
                try {
                    Files.delete(file);
                    try (PrintWriter pw = new PrintWriter(new FileWriter(arr[1].trim(), true))) {
                        for(String st:list) pw.println(st);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } catch (IOException e) { e.printStackTrace(); }

                break;
            default:
                throw new IllegalArgumentException("current key: read/write/append");
        }
    }
}
