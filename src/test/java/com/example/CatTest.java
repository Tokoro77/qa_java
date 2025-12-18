package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Mock
    Feline feline;

    @Test
    public void testGetSound() {
        Cat cat = new Cat(feline);
        assertEquals("Кошка должна говорить 'Мяу'",
                "Мяу", cat.getSound());
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(feline.eatMeat()).thenReturn(expectedFood);

        Cat cat = new Cat(feline);
        List<String> actualFood = cat.getFood();

        assertEquals("Метод getFood() должен возвращать то, что вернул feline.eatMeat()",
                expectedFood, actualFood);
    }
}