package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LionParamTest {
    @Mock
    Feline felineMock;

    private final String sex;
    private final boolean expectedHasMane;

    public LionParamTest(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
        MockitoAnnotations.openMocks(this);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"Самец", true},
                {"Самка", false}
        });
    }

    @Test
    public void testDoesHaveMane() throws Exception {
        Lion lion = new Lion(sex, felineMock);
        assertEquals("Для пола '" + sex + "' наличие гривы должно быть " + expectedHasMane,
                expectedHasMane, lion.doesHaveMane());
    }

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