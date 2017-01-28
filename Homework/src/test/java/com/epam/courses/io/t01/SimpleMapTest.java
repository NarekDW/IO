package com.epam.courses.io.t01;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Narek on 28.01.2017.
 */
public class SimpleMapTest {
    private SimpleMap smap = new SimpleMap();

    @Test
    public void simpleMapTest(){
        smap.add("A");
        smap.add("A");
        smap.add("B");
        smap.add("C");
        assertThat(smap.toString(), is("A - 2\nB - 1\nC - 1\n"));
    }
}