package ru.clubbreakfast.labs.lab01;

import java.io.IOException;
import java.util.regex.Pattern;

class Parser {

    /* Regexp on: Number is a Latin letter */
    private final Pattern latin = Pattern.compile("[A-z@#$%^&*_<>|'{}\\]\\[\\\\/~0-9]");
    private final Pattern splitter = Pattern.compile("[^А-я\\-]");


    void parseLine(String line) throws FileParseException {
        if (latin.matcher((line)).find()) {
            ThreadHerd.setIsStopped();
            throw new FileParseException(line);
        } else {
            String[] choppedLine = splitter.split(line);
            for (String snip : choppedLine) {
                snip = snip.trim();
                if (!snip.equals("")) {
                    if (!ThreadHerd.isStopped()) {
                        currentPut(snip);
                    } else if (!Result.withoutDetails) {
                        andThatWouldBe(snip);
                    }
                }
            }

        }
    }

    /**
     * The procedure for writing the processed string {@link Result#putResultMap}
     *
     * @param element - the processed value of the string.
     */
    private void currentPut(String element) {
        if (Result.getResultMap().containsKey(element)) {
            Integer putValue = Result.getResultMap().get(element) + 1;
            Result.putResultMap(element, putValue);
            if (!Result.withoutDetails)
                System.out.printf("\"%s\" - вхождение %d %s\n", element, putValue, Thread.currentThread().getName());
        } else {
            Result.putResultMap(element, 1);
            if (!Result.withoutDetails)
                System.out.println("\"" + element + "\" – добавлен из потока " + Thread.currentThread().getName());

        }
    }

    /**
     * Notice about the cancellation of the records of the read lines.
     *
     * @param element - the processed value of the string.
     */
    private void andThatWouldBe(String element) {
        if (Result.getResultMap().containsKey(element)) {
            Integer expectedValue = Result.getResultMap().get(element) + 1;
            System.out.printf("Т.к. процесс остановлен, считанное значение \"%s\" не подняло счетчик до %d (поток %s)\n", element, expectedValue, Thread.currentThread().getName());
        } else {
            System.out.println("Т.к. процесс остановлен, считанное значение \"" + element + "\" не записано (" + Thread.currentThread().getName() + ")");
        }
    }

    class FileParseException extends IOException {
        FileParseException(String s) {
            super(s);
        }
    }
}
