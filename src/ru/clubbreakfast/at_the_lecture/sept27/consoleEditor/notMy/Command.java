package ru.clubbreakfast.at_the_lecture.sept27.consoleEditor.notMy;

public class Command {

    public enum EnumCommand {
        READ,
        WRITE,
        APPEND,
        APPEND_TO_LINE,
        EXIT
    }

    public static EnumCommand getCommand(String s) {
        if (s.indexOf(" ") < 0) return EnumCommand.EXIT;
        String command = s.substring(0, s.indexOf(" "));
        if (command.equals("read")) return EnumCommand.READ;
        if (command.equals("write")) return EnumCommand.WRITE;
        if (command.equals("append")) return EnumCommand.APPEND;
        if (command.equals("appendToLine")) return EnumCommand.APPEND_TO_LINE;
        return EnumCommand.EXIT;
    }

    public static boolean doCommand(String str, FileEditor fe) {
        String[] strings = str.split("\"");
        String fileName = null;
        String argStr = null;
        int arg;
        if (strings.length > 1) {
            fileName = strings[1];
        }
        if (strings.length > 3) {
            argStr = strings[3];
        }
        if (strings.length > 4) {
            arg = Integer.valueOf(strings[4].trim());
        } else arg = -1;

        switch (Command.getCommand(str)) {
            case READ: System.out.println(fe.read(fileName)); break;
            case WRITE: fe.write(fileName, argStr); break;
            case APPEND: fe.append(fileName, argStr); break;
            case APPEND_TO_LINE: fe.appendToLine(fileName, argStr, arg); break;
            case EXIT: return true;
        }
        return false;
    }

}
