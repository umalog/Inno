package ru.clubbreakfast.at_the_lecture.sept27.consoleEditor.notMy;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileEditor {

    public String read(String fileName) {
        try {
            try (FileInputStream fileIn = new FileInputStream(fileName);
                BufferedReader reader = new BufferedReader(new InputStreamReader(fileIn))) {
                return read(reader);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String read(BufferedReader reader) throws IOException {
        String s = reader.readLine();
        String result = "";
        while (s != null) {
            result += s;
            s = reader.readLine();
            if (s != null) result += "\n";
        }
        return result;
    }

    public void write(BufferedWriter writer, String string) throws IOException {
        writer.write(string);
    }

    public void write(String fileName, String str) {
        if (fileName == null) throw new IllegalArgumentException("Wrong file name");
        if (str == null) throw new IllegalArgumentException("String argument not found");
        try (FileWriter fw = new FileWriter(fileName);
             BufferedWriter writer = new BufferedWriter(fw)) {
            write(writer, str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void append(BufferedWriter writer, String string) throws IOException {
        writer.write("\n" + string);
    }

    public void append(String fileName, String str) {
        if (fileName == null) throw new IllegalArgumentException("Wrong file name");
        if (str == null) throw new IllegalArgumentException("String argument not found");
        try (FileWriter fw = new FileWriter(fileName, true);
             BufferedWriter writer = new BufferedWriter(fw)) {
            append(writer, str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void appendToLine(BufferedReader reader, BufferedWriter writer, String str, int line) throws IOException {
        List<String> strings = new ArrayList<>();
        String s = reader.readLine();
        while (s != null) {
            strings.add(s);
            s = reader.readLine();
        }
        if (line > strings.size() + 1) // '+ 1' allows to append a new string to the end of file
            throw new IllegalArgumentException("Line number is too big for this file");
        strings.add(line - 1, str);
        String result = "";
        for (String s1 : strings) {
            result += s1 + "\n";
        }
        writer.write(result);
    }

    public void appendToLine(String fileName, String str, int line) {
        if (fileName == null) throw new IllegalArgumentException("Wrong file name");
        if (str == null) throw new IllegalArgumentException("String argument not found");
        if (line <= 0) throw new IllegalArgumentException("Line number must be a positive value");
        try (FileReader fr = new FileReader(fileName);
             BufferedReader reader = new BufferedReader(fr);
             FileWriter fw = new FileWriter(fileName);
             BufferedWriter writer = new BufferedWriter(fw)) {
            appendToLine(reader, writer, str, line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
