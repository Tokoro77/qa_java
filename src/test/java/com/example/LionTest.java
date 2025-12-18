package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline felineMock;

    @Test
    public void testGetKittens() throws Exception {
        when(felineMock.getKittens()).thenReturn(5);
        Lion lion = new Lion("Самец", felineMock);
        assertEquals("Lion.getKittens() должен возвращать значение от Feline.getKittens()",
                5, lion.getKittens());
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(felineMock.getFood("Хищник")).thenReturn(expectedFood);
        Lion lion = new Lion("Самка", felineMock);
        assertEquals("Lion.getFood() должен возвращать список от Feline.getFood('Хищник')",
                expectedFood, lion.getFood());
    }

    // ТЕСТ НА ИСКЛЮЧЕНИЕ ПЕРЕНЕСЁН СЮДА ИЗ LionParamTest
    @Test
    public void testConstructorWithInvalidSexThrowsException() {
        Exception exception = assertThrows(
                "При создании Lion с полом 'Неизвестно' должно быть выброшено исключение",
                Exception.class,
                () -> new Lion("Неизвестно", felineMock)
        );
        assertEquals("Текст сообщения об ошибке должен быть корректным",
                "Используйте допустимые значения пола животного - самец или самка",
                exception.getMessage());
    }
}