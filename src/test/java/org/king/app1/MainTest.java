package org.king.app1;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {    
    @Test
    void testFun1() {
        Library library = new Library();
        ArrayList<String> result = library.func1();
        assertEquals(3, result.size());
        assertEquals("greet from plataforma, app1", result.get(0));
        assertEquals("greet from plataforma-consumer-1 app1", result.get(1));
        assertEquals("greet from libdep1, app1", result.get(2));
    }    
    @Test
    void testFun2() {
        Library library = new Library();
        ArrayList<String> result = library.func2();
        assertEquals(5, result.size());
        assertEquals("greet from plataforma, app1", result.get(0));
        assertEquals("greet1 from plataforma greet from libdep1, app1", result.get(1));
        assertEquals("greet2 from plataforma greet from libdep2, app1", result.get(2));
        assertEquals("greet from plataforma-consumer-1 app1", result.get(3));
        assertEquals("greet from libdep1, app1", result.get(4));
    }    
}
