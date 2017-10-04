package ru.clubbreakfast.at_the_lecture.sept27.consoleEditor.notMy;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        FileEditor fe = new FileEditor();

        System.out.println("read \"fname\" - reads from file 'fname'");
        System.out.println("write \"fname\" \"str\" - writes str to file 'fname'");
        System.out.println("append \"fname\" \"str\" - append str to file 'fname'");
        System.out.println("appendToLine \"fname\" \"str\" pos - append str to file 'fname' at pos line (starts from 1)");
        System.out.println("something else will close program");
        System.out.println("Your choice?");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean exit = false;
        while (!exit) {
            try {
                if (Command.doCommand(br.readLine(), fe)) System.out.println("Operation completed. Your choice?");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }
}
