package ru.clubbreakfast.labs.lab01;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class ParserTest {
    private Parser parser = new Parser();

    @Test
    void parseLine() {
        try {
            String txt = "Эти достоинства и недостатки будут error.";
            parser.parseLine(txt);
        } catch (Parser.FileParseException e) {
            System.out.println(e.getLocalizedMessage());
            assertNotNull(e);
        }
    }
}