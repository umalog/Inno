package ru.clubbreakfast.labs.lab01;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class StarterTest {

    @Test
    void setOptionVal() throws IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> c = Starter.class;
        Method method = c.getDeclaredMethod("setOptionVal", BufferedReader.class);
        method.setAccessible(true);

        BufferedReader bReader = mock(BufferedReader.class);
        when(bReader.readLine()).thenReturn("y");
        method.invoke(null, bReader);
        assertEquals(Result.withoutDetails, true);
    }

    @Test
    void getFiles() {
        String[] testArr = {"/Users/umalog/Downloads", "/Users/umalog/Downloads/aaa.txt"};
        List<File> listFiles = Starter.getFiles(testArr);

        assertTrue(listFiles.get(0).equals(new File("/Users/umalog/Downloads/aaa.txt")));
        assertTrue(listFiles.size() == 1);
    }
}