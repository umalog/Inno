package ru.clubbreakfast.at_the_lecture.sept27.consoleEditor.notMy;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FileEditorTest {

    private static FileEditor editor = new FileEditor();

    @Test
    void read() throws IOException {
        BufferedReader reader = mock(BufferedReader.class);
        when(reader.readLine()).thenReturn("test").thenReturn(null);
        String s = editor.read(reader);
        assertEquals("test", s);
    }

    @Test
    void write() throws IOException {
        BufferedWriter writer = mock(BufferedWriter.class);
        editor.write(writer, "test");
        verify(writer).write("test");
    }

    @Test
    void append() throws IOException {
        BufferedWriter writer = mock(BufferedWriter.class);
        editor.append(writer, "test");
        verify(writer).write("\ntest");
    }

    @Test
    void appendToLine() throws IOException {
        BufferedReader reader = mock(BufferedReader.class);
        BufferedWriter writer = mock(BufferedWriter.class);
        when(reader.readLine()).thenReturn("tes1").thenReturn("tes2").thenReturn(null);
        editor.appendToLine(reader, writer, "test", 2);
        verify(writer).write("tes1\ntest\ntes2\n");
    }

}