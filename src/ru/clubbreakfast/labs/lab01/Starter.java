package ru.clubbreakfast.labs.lab01;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Starter {


    public static void main(String[] args) throws InterruptedException {
        if (args.length == 0) {
            System.out.printf("Не передан ни один аргумент!");
        } else {
            System.out.println("Программа может выводить полные и промежуточные отчеты\nВыводить промежуточные отчеты ?");
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                setOptionVal(reader);
            } catch (IOException e) {
                e.printStackTrace();
            }
Date time = new Date();
            List<File> checkedFiles = getFiles(args);
            ThreadHerd threads = new ThreadHerd(checkedFiles);

            if (Result.withoutDetails) {
                while (!ThreadHerd.isStopped()) {

                    System.out.println("Промежуточный отчет:");
                    Result.printResult();

                    System.out.println();
                    Thread.sleep(10);
                }
            }
            threads.executor.shutdown();
            threads.executor.awaitTermination(1, TimeUnit.SECONDS);
            System.out.println("\nИтоговый отчет");
            Result.printResult();
            System.out.println((new Date().getTime())-time.getTime());
//            Thread.sleep(10000);

            //утилизация памяти -> единичное событие - 4.13мб
            //утилизачия  CPU -> пики каждую секунду по 20% и программа тут не при чем!
        }

    }

    /**
     * The method sets the value of the variable {@link Result # withoutDetails}
     * By its value, the output mode in the console
     *
     * @param reader from test
     */
    private static void setOptionVal(BufferedReader reader) {
        String tmpVal;
        try {
            tmpVal = reader.readLine();
            if (tmpVal.equalsIgnoreCase("Y")) Result.withoutDetails = true;
            else if (tmpVal.equalsIgnoreCase("N")) Result.withoutDetails = false;
            else {
                System.out.println("Введенное значение должно быть Y или N");
                setOptionVal(reader);
            }
        } catch (IOException e) {
            System.out.printf("Ошибка ввода-вывода. Отчеты будут подробными.");

        }
    }

    /**
     * The method filters incoming rows by the sign, whether they are the path to the file.
     *
     * @param fileNames - args[];
     * @return List checkedFiles;
     */
    static List<File> getFiles(String[] fileNames) {
        ArrayList<File> listFiles = new ArrayList<>();
        for (String name : fileNames) {
            File file = new File(name);
            if (file.exists()) {
                if (file.isDirectory()) System.out.printf("Переданный файл %s является директорией\n", name);
                else listFiles.add(file);
            } else System.out.printf("Переданный файл %s не существует \n", name);
        }
        return listFiles;
    }
}