package ru.clubbreakfast.at_the_lecture.sept27.MockExample;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DelitelTest {
    @Test
    void delit() {
    Kvadrator kvadrator = mock(Kvadrator.class);
    when(kvadrator.kvadrat(2)).thenReturn(4d);
    Delitel.kvadrator = kvadrator;
    double result = Delitel.delit(2);
    assertEquals(4d/5d,result);
    }

}