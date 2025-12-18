package com.example;

import org.junit.Test;
import java.util.List;
import java.util.Arrays;
import static org.junit.Assert.*;

public class FelineTest {

    @Test
    public void testGetFamily() {
        Feline feline = new Feline();
        assertEquals("Метод getFamily() должен возвращать 'Кошачьи'",
                "Кошачьи",
                feline.getFamily());
    }

    @Test
    public void testGetKittensNoArgument() {
        Feline feline = new Feline();
        assertEquals("Метод getKittens() без параметров должен возвращать 1",
                1,
                feline.getKittens());
    }

    // Исправлено: вместо одного метода с тремя проверками - три отдельных метода

    @Test
    public void testGetKittensWithPositiveArgument() {
        Feline feline = new Feline();
        assertEquals("Метод getKittens(5) должен возвращать 5",
                5,
                feline.getKittens(5));
    }

    @Test
    public void testGetKittensWithZero() {
        Feline feline = new Feline();
        assertEquals("Метод getKittens(0) должен возвращать 0",
                0,
                feline.getKittens(0));
    }

    @Test
    public void testGetKittensWithNegativeArgument() {
        Feline feline = new Feline();
        assertEquals("Метод getKittens(-3) должен возвращать -3",
                -3,
                feline.getKittens(-3));
    }

    @Test
    public void testEatMeat() throws Exception {
        Feline feline = new Feline();
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        List<String> actualFood = feline.eatMeat();

        assertEquals("Метод eatMeat() должен возвращать список: [Животные, Птицы, Рыба]",
                expectedFood,
                actualFood);
    }
}