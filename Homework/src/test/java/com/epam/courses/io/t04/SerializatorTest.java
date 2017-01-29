package com.epam.courses.io.t04;

import org.junit.Test;
import java.io.File;
import java.io.InvalidObjectException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Date: 29.01.2017
 *
 * @author Karapetyan N.K
 */
public class SerializatorTest {
    private FilmCollection f = new FilmCollection();
    private File file = new File("Film.data");
    @Test
    public void serializatorTest() throws InvalidObjectException {
        initialization();
        Serializator.serialization(f,file);
        FilmCollection deserial = Serializator.deserialization(file);

        assertThat(f.toString(), is(deserial.toString()));
    }

    private void initialization() {
        f.add("Операция «Ы» и другие приключения Шурика",
                "Александр Демьяненко", "Наталья Селезнёва");
        // Добавятся только уникальные имена
        f.add("Операция «Ы» и другие приключения Шурика",
                "Александр Демьяненко", "Наталья Селезнёва", "Юрий Никулин");
        f.add("Иван Васильевич меняет профессию",
                "Александр Демьяненко", "Юрий Яковлев");
        f.add("Иван Васильевич меняет профессию",
                "Леонид Куравлёв");
        f.add("Бриллиантовая рука",
                "Юрий Никулин", "Андрей Миронов", "Анатолий Папанов");

    }

}